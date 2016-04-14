package com.cardvalue.penguin.web.message.handler;

import cn.cvbaoli.www.AddServiceBindingStub;
import cn.cvbaoli.www.SoapGetUserRequestMain;
import cn.cvbaoli.www.SoapRequestAuths;

import com.cardvalue.penguin.dto.MerchantRegisterDTO;
import com.cardvalue.penguin.dto.UserRegisterDTO;
import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.model.Parameter;
import com.cardvalue.penguin.model.ReferrerLink;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.*;
import com.cardvalue.penguin.service.MerchantService;
import com.cardvalue.penguin.service.UserService;
import com.cardvalue.penguin.service.WeChatService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.LogService;
import com.cardvalue.penguin.util.Result;
import com.cardvalue.penguin.util.XMLConverter;
import com.cardvalue.penguin.web.message.MessageHandler;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

public class SubscribeMessageHandler extends MessageHandler {

    private final static Logger logger = LoggerFactory.getLogger(SubscribeMessageHandler.class);

    @Resource
    private UserRepository userRepo;

    @Resource
    private LogService logService;

    @Value("${wechat.username}")
    private String weChatUsername;

    @Value("${we.oauth.url}")
    private String oAuthURL;

    @Value("${wechat.base.url}")
    private String baseURL;

    @Value("${wechat.app.name}")
    private String appName;

    @Value("${wechat.appid}")
    private String weAppId;

    @Resource
    private XMLConverter xmlConverter;

    @Resource
    private WeChatService weService;

    @Resource
    private UtilRepository utilRepo;

    @Resource
    private ParamRepository paramRepo;

    @Resource
    private KeyMerchantRepository keyMerchantRepository;

    @Resource
    private MessageContentRepository messageContentRepo;

    @Resource
    private ReferrerLinkRepository referrerLinkRepo;

    @Resource
    private AddServiceBindingStub addServiceBindingStub;

    @Resource
    private UserService userService;

    @Resource
    private MerchantService merchantService;

    @Override
    public String handle(WeChatMessage message) {
        logger.info("Start handle subscribe message...");
        String openId = message.getFromUserName();
        WeUser user = userRepo.findByOpenId(openId);

        //速融申请扫描推送系统消息,
        //message.getEventKey()此方法如果是用户直接通过微信搜索公众号搜索添加则为null，如果是通过二维码扫描则不为空里面为参数
        String pushMesg = "";
        //拼接url(oauth)
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + appName
                + "%2Fhome%2Fenter%3FredirectUrl%3D%2Fm%2FinstantCreditShow&response_type=code&scope=snsapi_base&appid=" + weAppId;

        //新用户且扫描推荐
        if (user == null && StringUtils.isNotBlank(message.getEventKey())) {
            String eventKey = message.getEventKey();
            String key = StringUtils.substringAfter(eventKey, Constants.WE_SCAN_KEY_PREFIX);
            WeUser referrer = null;
            if (key.startsWith(Constants.QRCODE_PREFIX_LINK)) {
                /**表示添加商户扫描请求*/
                //mid参数
                String linkId = key.substring(1);
                ReferrerLink link = referrerLinkRepo.attachOpenId(Long.valueOf(linkId), openId);
                referrer = userRepo.findOne(link.getReferrerId());
                if (referrer != null) {
                    //客户经理二维码加商户
                    url = baseURL + appName + "/sales/merchant/register/show?linkId=" + link.getId();
                    String encodedURL = null;
                    try {
                        encodedURL = URLEncoder.encode(url, "utf-8");
                    } catch (Exception e) {
                        logger.warn("encoding not supportted");
                    }
                    String registerMerchantURL = String.format(oAuthURL, encodedURL, weAppId);

                    if (referrer.getType() != Constants.USER_TYPE_MERCHANT) {
                        //商户扫描客户经理添加
                        weService.pushMessage(referrer.getOpenId(), "您推荐的商户已经关注了卡得万利公众平台，还需要完善商户相关信息，请点击<a href=\""
                                + registerMerchantURL + "\">链接</a>(一小时内有效)完善商户信息.");
                    } else {
                        //商户扫描商户添加
                        weService.pushMessage(referrer.getOpenId(), "您推荐的商户已经关注了卡得万利公众平台，请提醒他（她）及时进行注册操作，并在注册信息中填写您的手机号码为推荐人号码，你将获得以下两种奖励方式：1、当推荐商户成功注册并且成功认证后，你将获取50元现金券。2、当推荐商户放款一次后你将获得200元现金券。");
                    }

                    logger.info("Store referrer id " + referrer.getId() + " into session.");
                    logService.insertActionLog(Constants.ACTION_SUBSCRIBE_QRCODE, null, message.getFromUserName(), "[key:" + key + "]");
                }
            }else if(key.startsWith(Constants.QRCODE_PREFIX_LINK_INSTANT_CREDIT)){
                /**表示用户在网站上扫描速融请求*/
                try {
                    String userId = key.substring(2);//截取userId
                    //调用网站接口获取用户名
                    SoapRequestAuths SoapRequestAuths = new SoapRequestAuths("","");
                    SoapGetUserRequestMain SoapGetUserRequestMain = new SoapGetUserRequestMain(userId);
                    cn.cvbaoli.www.ArrResponse arrResponse = addServiceBindingStub.getUser(SoapRequestAuths, SoapGetUserRequestMain);
                    if(arrResponse.getStatus().equals("1")){
                        //表示获取用户名成功
                        ObjectMapper mapper = new ObjectMapper();
                        Map<String, String> map = mapper.readValue(arrResponse.getData(), new TypeReference<Map<String,String>>(){});
                        //获取用户名
                        String username = map.get("mobile");
                        //判断用户是否存在
                        WeUser dbUser = userService.findByUsername(username);
                        //如果用户存在,表示网站和微信用户同步
                        if(dbUser != null){
                            //判断数据库中user是否有openId
                            if(StringUtils.isNotBlank(dbUser.getOpenId())){
                                //表示数据库中的用户有openId,此时判断数据库中的openId和当前传入的openId是否一致
                                if(openId.equals(dbUser.getOpenId())){
                                    //表示数据库中的openId和传入一致,推送消息
                                    pushMesg = "请点击此<a href='"+url+"'>链接</a>,进入速融申请界面!";
                                }else{
                                    //表示扫二维码的人和二维码中人的openId不一致,此时需要给扫二维码的人推送提示消息
                                    pushMesg = "该二维码已经和手机号绑定，请使用正确的手机号登录!";
                                }
                            }else{
                                //表示数据库中的用户没有openId
                                //通过用户名绑定openid,如果没有激活需要激活（相当于登录）
                                userService.bind(username, openId);
                                //绑定推送消息
                                pushMesg = "请点击此<a href='"+url+"'>链接</a>,进入速融申请界面!";
                            }
                        }else{
                            //step1.网站那边存有用户，微信这边没有用户，此时需要同步用户
                            UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
                            userRegisterDTO.setName(map.get("user_name"));
                            userRegisterDTO.setProvinceId(Integer.valueOf(map.get("province_id")));
                            userRegisterDTO.setRegionId(Integer.valueOf(map.get("city_id")));
                            userRegisterDTO.setMobile(map.get("mobile"));
                            userRegisterDTO.setEmail(map.get("email"));
                            userRegisterDTO.setPassword("");//密码不用设置，直接绑定
                            Result<?> r = userService.createUser(userRegisterDTO,null);
                            if(r.getCode().equals(Constants.RESULT_CODE_SUCCESS)){
                                //step2.用户认证
                                WeUser tempUser = userService.findByUsername(map.get("mobile"));
                                MerchantRegisterDTO merchantRegisterDTO = new MerchantRegisterDTO();
                                merchantRegisterDTO.setMerchantName(map.get("merchantName"));//店铺名称
                                merchantRegisterDTO.setMid(map.get("mid"));//POS机商编
                                merchantRegisterDTO.setAddress(map.get("address"));//店铺地址
                                merchantRegisterDTO.setContactName(map.get("real_name"));//联系人姓名
                                merchantRegisterDTO.setContactMobile(map.get("mobile"));//联系电话
                                merchantRegisterDTO.setContactPosition(1);//身份默认法人
                                Result<?> r2 = merchantService.createMerchant(merchantRegisterDTO, null,tempUser,null);
                                if(r2.getCode().equals(Constants.RESULT_CODE_SUCCESS)){
                                    //通过用户名绑定openid,如果没有激活需要激活（相当于登录）
                                    userService.bind(username, openId);
                                    //绑定推送消息
                                    pushMesg = "请点击此<a href='"+url+"'>链接</a>,进入速融申请界面!";
                                }else{
                                    //表示微信端后台认证失败
                                    logger.error(r2.getMessage());
                                    pushMesg = "系统处理异常，请稍后再试";
                                }
                            }else{
                                //表示微信端后天添加用户失败
                                logger.error(r.getMessage());
                                pushMesg = "系统处理异常，请稍后再试";
                            }
                        }
                    }else{
                        //表示获取用户名失败
                        logger.error("网站扫描速融二维码，获取网站用户名，网站段返回失败:"+arrResponse.getMsg());
                        pushMesg = "系统处理异常，请稍后再试";
                    }
                } catch (Exception e) {
                    logger.error("网站扫描速融二维码，获取网站用户名失败:",e);
                    pushMesg = "系统处理异常，请稍后再试";
                }

            } else if (key.startsWith(Constants.QRCODE_PREFIX_LINK_DISTRIBUTOR)) {
                //分销商扫描
                String linkId = key.substring(1);//分销商的主商户id
                logService.insertActionLog(Constants.ACTION_SUBSCRIBE_QRCODE_DISTRIBUTOR, null, message.getFromUserName(), linkId);
            } else {
                //地区统计
                logService.insertActionLog(Constants.ACTION_SUBSCRIBE_QRCODE, null, message.getFromUserName(), "[branch:" + key + "]");
            }
        }
        Parameter typeParam = paramRepo.findByGroupAndName("welcome_message", "type");
        Parameter idParam = paramRepo.findByGroupAndName("welcome_message", "message_id");
        String respXML = null;
        if (typeParam != null && idParam != null) {
            try {
                respXML = this.generateReturnMessage(openId, typeParam.getValue(), Integer.parseInt(idParam.getValue()), message.getContent());
            } catch (IOException e) {
                logger.error("Error occurs while generating welcome message", e);
            }
        }
        logger.info("Complete handle subscribe message.");
        return respXML;
    }

}
