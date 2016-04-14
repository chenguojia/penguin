package com.cardvalue.penguin.web.message.handler;

import cn.cvbaoli.www.AddServiceBindingStub;
import cn.cvbaoli.www.SoapGetUserRequestMain;
import cn.cvbaoli.www.SoapRequestAuths;

import com.cardvalue.penguin.dto.MerchantRegisterDTO;
import com.cardvalue.penguin.dto.UserRegisterDTO;
import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.UserRepository;
import com.cardvalue.penguin.service.MerchantService;
import com.cardvalue.penguin.service.UserService;
import com.cardvalue.penguin.service.WeChatService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.LogService;
import com.cardvalue.penguin.util.Result;
import com.cardvalue.penguin.web.message.MessageHandler;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.Map;

public class ScanMessageHandler extends MessageHandler {

	private final static Logger logger = LoggerFactory.getLogger(ScanMessageHandler.class);

	@Value("${wechat.app.name}")
	private String appName;

	@Value("${wechat.appid}")
	private String weAppId;

	@Resource
	private UserRepository userRepo;
	
	@Resource
	private LogService logService;

	@Resource
	private AddServiceBindingStub addServiceBindingStub;

	@Resource
	private UserService userService;

	@Resource
	private WeChatService weService;

	@Resource
	private MerchantService merchantService;
	
	@Override
	public String handle(WeChatMessage message) {
		if(StringUtils.isNotBlank(message.getTicket())){
			String openId = message.getFromUserName();
			String eventKey = message.getEventKey();
			String key = eventKey;
			WeUser referrer = null;
			if(key.startsWith(Constants.QRCODE_PREFIX_LINK)){
				//表示添加商户
				//code....
			}else if(key.startsWith(Constants.QRCODE_PREFIX_LINK_INSTANT_CREDIT)){
				/**表示web网站扫描速融二维码*/

				//速融申请扫描推送系统消息
				String pushMesg = "";
				//拼接url(oauth)
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?"
						+ "redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + appName
						+ "%2Fhome%2Fenter%3FredirectUrl%3D%2Fm%2FinstantCreditShow&response_type=code&scope=snsapi_base&appid=" + weAppId;
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

				if(!pushMesg.equals("")){
					//推送速融进入消息
					weService.pushMessage(openId, pushMesg);
				}
			}else{
				//其他
				String referrerIdStr = message.getEventKey();
				referrer = userRepo.findByUsername(referrerIdStr);
				if(referrer != null){
					logService.insertActionLog(Constants.ACTION_SCAN_QRCODE, null, message.getFromUserName(), "[code:" + referrerIdStr + "]");
				}
			}

		}
		return null;
	}

}
