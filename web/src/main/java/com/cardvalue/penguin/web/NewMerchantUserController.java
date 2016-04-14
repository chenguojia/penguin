package com.cardvalue.penguin.web;


import com.cardvalue.penguin.dto.*;
import com.cardvalue.penguin.model.*;
import com.cardvalue.penguin.repository.ClientVersionRepository;
import com.cardvalue.penguin.repository.LoginModelRepository;
import com.cardvalue.penguin.repository.WelecomeSetRepository;
import com.cardvalue.penguin.service.AllKindSelectService;
import com.cardvalue.penguin.service.MerchantService;
import com.cardvalue.penguin.service.NewMerchantService;
import com.cardvalue.penguin.service.SmsService;
import com.cardvalue.penguin.service.impl.SmsServiceImpl;
import com.cardvalue.penguin.util.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpPost;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by guojia.chen on 2016-01-06 10:19.
 */
@Controller
@RequestMapping(value = "/new/m")
public class NewMerchantUserController {

    private static final Logger logger = LoggerFactory.getLogger(NewMerchantUserController.class);

    @Resource
    private SmsService smsService;

    @Value("${ws.crm.restful.merchant.url}")
    private String wsCrmRestfulMerchantUrl;

    @Value("${ws.local.ip}")
    private String wsLocalIp;

    @Value("${ws.jxl.url.crm}")
    private String wsJxlUrl;

    @Resource
    private HttpServletRequest request;

    @Resource
    private NewMerchantService newMerchantService;

    @Resource
    private MerchantService merchantService;

    @Resource
    private ClientVersionRepository clientVersionRepository;

    @Value("${sms.signature}")
    private String smsSignature;

    @Value("${sms.account}")
    private String smsAccount;

    @Value("${sms.password}")
    private String smsPassword;

    @Resource
    private WelecomeSetRepository welecomeSetRepository;

    @Resource
    private AllKindSelectService allKindSelectService;

    @Resource
    private LoginModelRepository loginModelRepository;

    /**
     * 新版商户微信菜单入口
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public ModelAndView enter(@RequestParam String code, HttpSession session, HttpServletRequest request) {
        session.setAttribute("user-agent",request.getHeader("user-agent"));
        ModelAndView mv = new ModelAndView("newm/index");
        NewMerchantUserModel newMerchantUserModel = newMerchantService.enter(code, session, request);
        if (newMerchantUserModel != null) {
            if (StringUtils.isNotBlank(newMerchantUserModel.getAgreeToLicense()) && newMerchantUserModel.getAgreeToLicense().equals("1")) { //绑定后，判断有误确定授权条款
                return home(session,"0");//表示已经同意过授权，直接进入首页
            } else {
                return home(session,"0");//现在不需要授权条款了，直接进入首页.
//                return showAccredit(); //表示还未同意授权，进入授权显示界面
            }
        }
        return mv;
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("newm/index");
        return mv;
    }

    /**
     * TAB - 我的账户 - TAB
     *
     * @return
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView account(HttpSession session) {
        //删除绑卡时的缓存信息
//        session.removeAttribute("sessionApplication");

        ModelAndView mv = new ModelAndView("newm/account");
        ApplicationModel applicationModel = null;
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
        }
        //将当申请记录保存，是否正在计算授信字段存在于申请记录中
        mv.addObject("applicationModel", applicationModel);
        mv.addObject("newMerchantUserModel", newMerchantUserModel);

        //查询多商户
        List<Map> muliteMerchant = newMerchantService.queryMuliteMerchant(session);
        mv.addObject("muliteMerchant",muliteMerchant);

        List list0 = null;
        List list1 = null;
        if(newMerchantUserModel!=null){
            list0 = newMerchantService.queryCoupons(newMerchantUserModel.getObjectId(), "0", "0");
            list1 = newMerchantService.queryCoupons(newMerchantUserModel.getObjectId(), "1", "0");
            int total = list0.size()+list1.size();
            mv.addObject("total",total);
        }


        Map map = new HashMap();
        if(newMerchantUserModel!=null && newMerchantUserModel.getObjectId()!=null){
            map = newMerchantService.invitedRecord(newMerchantUserModel.getObjectId());
        }
        mv.addObject("map",map);
        session.setAttribute("inviteHistory",map);
        return mv;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////TAB - 更多 - TAB///////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * TAB - 更多 - TAB
     *
     * @return
     */
    @RequestMapping(value = "/more", method = RequestMethod.GET)
    public ModelAndView more() {
        ModelAndView mv = new ModelAndView("newm/more/more");
        return mv;
    }

    /**
     * TAB - 更多 - 案例分享
     *
     * @return
     */
    @RequestMapping(value = "/more/caseShare", method = RequestMethod.GET)
    public ModelAndView caseShare(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/caseShare");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 -
     *
     * @return
     */
    @RequestMapping(value = "/more/regular", method = RequestMethod.GET)
    public ModelAndView regular(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/regular");
        mv.addObject("isApp", isApp);
        return mv;
    }

    @RequestMapping(value = "/more/regular2", method = RequestMethod.GET)
    public ModelAndView regular2(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/regular2");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 常见问题
     *
     * @return
     */
    @RequestMapping(value = "/more/question", method = RequestMethod.GET)
    public ModelAndView question(@RequestParam(defaultValue = "1") String isApp) {//默认是1，不显示头部，0显示头部
        ModelAndView mv = new ModelAndView("newm/more/question");
//        ModelAndView mv = new ModelAndView("/merchant/page/question2");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 公司简介
     *
     * @return
     */
    @RequestMapping(value = "/more/aboutUs", method = RequestMethod.GET)
    public ModelAndView aboutUs(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/aboutUs");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 资质荣誉
     *
     * @return
     */
    @RequestMapping(value = "/more/honor", method = RequestMethod.GET)
    public ModelAndView honor(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/honor");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 新闻中心
     *
     * @return
     */
    @RequestMapping(value = "/more/news", method = RequestMethod.GET)
    public ModelAndView news(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/news");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 新闻中心
     *
     * @return
     */
    @RequestMapping(value = "/more/newsDetails", method = RequestMethod.GET)
    public ModelAndView newsDetails(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/newsDetails");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 联系方式
     *
     * @return
     */
    @RequestMapping(value = "/more/contactUs", method = RequestMethod.GET)
    public ModelAndView contactUs(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/contactUs");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 意见反馈
     *
     * @return
     */
    @RequestMapping(value = "/more/comments", method = RequestMethod.GET)
    public ModelAndView comments(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/comments");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * 保存反馈意见
     * @param feedbackTO
     * @param session
     * @return
     */
    @RequestMapping(value = "/feedback/content",method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult saveFeedbackComments(FeedbackTO feedbackTO,String dataList,String nameList,HttpSession session){
        if(dataList!=null && !dataList.equals("") && nameList!=null && !nameList.equals("")){
            String dlist[] = dataList.split("@&@");
            String nlist[] = nameList.split("@&@");
            feedbackTO.setDataList(Arrays.asList(dlist));
            feedbackTO.setNameList(Arrays.asList(nlist));
        }
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if(newMerchantUserModel!=null){
            result =  newMerchantService.saveFeedbackComments(feedbackTO,session);
        }
        return result;
    }

    @RequestMapping(value = "/getSize")
    @ResponseBody
    public RestfulResult getSize(Object object,HttpSession session){
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        return result;
    }

    /**
     * TAB - 更多 - 关于小企鹅
     *
     * @return
     */
    @RequestMapping(value = "/more/aboutPenguin", method = RequestMethod.GET)
    public ModelAndView aboutPenguin(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/aboutPenguin");
        mv.addObject("isApp", isApp);
        return mv;
    }


    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////TAB - 更多 - TAB///////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 条款  - 注册
     *
     * @return
     */
    @RequestMapping(value = "/clause/register", method = RequestMethod.GET)
    public ModelAndView registerClause() {
        ModelAndView mv = new ModelAndView("newm/clause/register");
        return mv;
    }

    /**
     * 条款  - 注册
     *
     * @return
     */
    @RequestMapping(value = "/clause/privacy", method = RequestMethod.GET)
    public ModelAndView privacyClause() {
        ModelAndView mv = new ModelAndView("newm/clause/privacy");
        return mv;
    }

    /**
     * 条款  - 注册后同意
     *
     * @return
     */
    @RequestMapping(value = "/clause/registerFinish", method = RequestMethod.GET)
    public ModelAndView registerFinish() {
        ModelAndView mv = new ModelAndView("newm/clause/registerFinish");
        return mv;
    }

    /**
     * 条款  - 创建申请
     *
     * @return
     */
    @RequestMapping(value = "/clause/createApply", method = RequestMethod.GET)
    public ModelAndView createApply() {
        ModelAndView mv = new ModelAndView("newm/clause/createApply");
        return mv;
    }

    /**
     * 条款  - 放款待确认
     *
     * @return
     */
    @RequestMapping(value = "/clause/affirmLoansClause", method = RequestMethod.GET)
    public ModelAndView affirmLoans() {
        ModelAndView mv = new ModelAndView("newm/clause/affirmLoansClause");
        return mv;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////用户相关操作///////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 判断验证码是否正确
     * 正确返回true
     * @param code 102：crm端验证码正确，103：验证码错误次数超过3次，0：验证码错误
     * @return
     */
    public String checkCode(String code,String mobile){

        Map paramMap = new HashMap();
        paramMap.put("mobilePhone",mobile);
        if(code!=null && !code.equals("")){
            paramMap.put("imageVerifyCode",code);
        }
        String url = wsCrmRestfulMerchantUrl + "/mobilePhoneVerifyCode";
        ObjectMapper mapper = new ObjectMapper();
        String responseBody = "";
        HashMap map = null;
        try {
            responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(paramMap));
            logger.info("从CRM获取手机验证码responseBody:"+responseBody);
            if(!responseBody.equals("")){
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                map = mapper.readValue(responseBody, HashMap.class) ; //将json解析成HashMap
            }
            if(map != null && map.get("createdAt")!=null && !map.get("createdAt").equals("")){
                return "102";//验证码正确
            }
            if(map != null && map.get("error")!=null && map.get("code")!=null && (map.get("code")+"").equals("242")){
                return "103";
            }
            if(map != null && map.get("error")!=null && !map.get("error").equals("") && map.get("code")!=null && map.get("code").equals("241")){
                return "0";//
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }


    /**
     * 绑定账号获取验证码
     *
     * @param session
     * @return 1表示生成验证 0表示失败
     */
    @RequestMapping(value = "/getCheckCode", method = {RequestMethod.GET})
    @ResponseBody
    public String getCheckCode(String mobile, HttpSession session,String code) {

        if(StringUtils.isBlank(mobile) || StringUtils.isBlank(code)){
            return "0";
        }
        String checkCode = checkCode(code,mobile);
        if(checkCode!=null && !checkCode.equals("102")){
            return checkCode;//
        }else{
            return "1";
        }
    }


    /**
     * 绑定账号获取验证码 -ad/ ios
     *
     */
    @RequestMapping(value = "/getCheckCode/query", method = {RequestMethod.GET})
    @ResponseBody
    public Object queryGetCheckCode(String mobile) {
        String Ip = SmsServiceImpl.getIp(request);
        System.out.print(String.format("========%s=======",Ip));

        RestfulResult result = new RestfulResult("-1", "获取验证码出错!", null);
        String checCode = Utility.createRandom(true, 4);//生成验证码
        int flag = smsService.sendSms(mobile, "您好，您的验证码为:" + checCode + "，2分钟内有效，请勿泄露。");
        Map map = new HashMap();
        if (flag > 0) {
            //短信发送成功，map返回

            map.put("checkCode", checCode);
            map.put("checkCodeMobile", mobile);
            map.put("checkCodeSetDate", new Date().getTime());

            map.put("code", Constants.RESTFUL_RESULT_FAILED);
            map.put("error", "APP升级中，你可以微信关注‘小企额’，点击下方融资入口进行注册！");


            map.put("resultCode",Constants.RESTFUL_RESULT_FAILED);
            map.put("resultMsg","APP升级中，你可以微信关注‘小企额’，点击下方融资入口进行注册！");

            System.out.println("短息发送成功!");
        }else if(flag==-100) {
            //短信发送失败，被列入黑名单
            map.put("code", Constants.RESTFUL_RESULT_FAILED);
            map.put("error","APP升级中，你可以微信关注‘小企额’，点击下方融资入口进行注册！");
            map.put("resultCode",Constants.RESTFUL_RESULT_FAILED);
            map.put("resultMsg","APP升级中，你可以微信关注‘小企额’，点击下方融资入口进行注册！");
        }else{
            //短信发送失败，被列入黑名单
            map.put("code", Constants.RESTFUL_RESULT_FAILED);
            map.put("error", "APP升级中，你可以微信关注‘小企额’，点击下方融资入口进行注册！");
            map.put("resultCode", Constants.RESTFUL_RESULT_FAILED);
            map.put("resultMsg","APP升级中，你可以微信关注‘小企额’，点击下方融资入口进行注册！");
        }
        return map;
    }


    /**
     * 新用户绑定显示界面 - 只给后台验证未登录失败时跳转，前端页面不允许访问
     *
     * @return
     */
    @RequestMapping(value = "/bind/show", method = RequestMethod.GET)
    public ModelAndView showBind() {
        ModelAndView mv = new ModelAndView("newm/bind");

        //卡兜暂时没有认证，测试环境中暂时手动添加openId
//        request.getSession().setAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID, UUIDGenerator.getUUID());
        return mv;
    }

    /**
     * 新用户绑定
     *
     * @return
     */
    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult bind(BindDTO dto, HttpSession session, HttpServletRequest request) {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword(dto.getPassword());
        loginDTO.setMobile(dto.getMobile());
        loginDTO.setType(false);
        //查询该手机号码是否已经被注册
        RestfulResult result = newMerchantService.login(loginDTO, session, request);
        if(result.getResultCode()!=null && result.getResultCode().equals("1")){
            result.setResultCode("-1");
            result.setResultMsg("该手机号码已经被注册!");
            return result;
        }else{
            return newMerchantService.bind(dto, session, request);
        }

    }

    /**
     * 用户登录 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/login/show", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        ModelAndView mv = new ModelAndView("newm/login");
        return mv;
    }

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult login(LoginDTO dto, HttpSession session, HttpServletRequest request) {
        return newMerchantService.login(dto, session, request);
    }

    /**
     * 忘记密码 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/forgetPassword/show", method = RequestMethod.GET)
    public ModelAndView showForgetPassword() {
        ModelAndView mv = new ModelAndView("newm/forgetPassword");
        //卡兜暂时没有认证，测试环境中暂时手动添加openId
//        request.getSession().setAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID,UUIDGenerator.getUUID());
        return mv;
    }

    /**
     * 忘记密码
     *
     * @return
     */
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult forgetPassword(ForgetPasswordDTO dto, HttpSession session) {

        return newMerchantService.forgetPassword(dto, session);
    }

    /**
     * 修改密码 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/updatePassword/show", method = RequestMethod.GET)
    public ModelAndView showUpdatePassword() {
        ModelAndView mv = new ModelAndView("newm/updatePassword");
        return mv;
    }

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult updatePassword(UpdatePasswordDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            dto.setMerchantId(newMerchantUserModel.getObjectId());
            result = newMerchantService.updatePassword(dto);
        }
        return result;
    }

    /**
     * 我的账户
     *
     * @return
     */
    @RequestMapping(value = "/userInfo/show", method = RequestMethod.GET)
    public ModelAndView showUserInfo() {
        ModelAndView mv = new ModelAndView("newm/userInfo");
        return mv;
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult logout(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            result = newMerchantService.logout(session);
        }
        return result;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////商户相关操作///////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 授权 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/accredit/show", method = RequestMethod.GET)
    public ModelAndView showAccredit() {
        ModelAndView mv = new ModelAndView("newm/accredit");
        return mv;
    }

    /**
     * 授权条款
     *
     * @return
     */
    @RequestMapping(value = "/accredit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult accredit(HttpSession session, HttpServletRequest request) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            //插入条款 - 同意类型
            // 以后，CRM自动修改AGREELICENCE为1
            result = newMerchantService.accredit(Constants.CLAUSE_TYPE_ACCREDIT, newMerchantUserModel.getObjectId(), newMerchantUserModel.getApplicationId(), newMerchantUserModel.getMobilePhone(), Utility.getRemoteIp(request),
                    session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString(),
                    null, newMerchantUserModel.getLongitude() + "," + newMerchantUserModel.getLatitude(), request.getHeader("user-agent"));
        }
        return result;
    }


    @RequestMapping(value = "/exchangeMerchant", method = RequestMethod.POST)
    @ResponseBody
    public Map exchangeMerchant(HttpSession session,String merchantId,String applicationId){
        Boolean flag = session.getAttribute("objectId").equals(merchantId);
        logger.info("flag"+flag);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code","-1");
        if(flag==false){
            //表示切换用户不是当前用户
            session.setAttribute("objectId", merchantId);//保存用户id
            NewMerchantUserModel newMerchantUserModel = newMerchantService.getMerchantUserById(merchantId);
            if(newMerchantUserModel!=null ){
                session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT,newMerchantUserModel);
                map.put("code","1");
            }
        }
        return map;
    }

    /**
     * 添加商户
     * @param session
     * @param step
     * @return
     */
    @RequestMapping(value = "/addMerchant", method = RequestMethod.GET)
    @ResponseBody
    public Map addMerchant(HttpSession session,@RequestParam(defaultValue = "0",required = false)String step){
        Map map =  newMerchantService.addMerchant(session);
        return map;
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session,@RequestParam(defaultValue = "-1",required = false)String step) {

        ModelAndView mv = new ModelAndView("newm/home");
        //===============================================基础资料begin=====================================

        List<Map> muliteMerchant = newMerchantService.queryMuliteMerchant(session);
        if(muliteMerchant!=null && muliteMerchant.size()>=1 && muliteMerchant.get(0).get("error")!=null){
            mv.addObject("error",muliteMerchant.get(0).get("error"));
            mv.addObject("step","0");
            return mv;
        }
        mv.addObject("muliteMerchant",muliteMerchant);

       NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if(newMerchantUserModel!=null && newMerchantUserModel.getObjectId()!=null){
            newMerchantUserModel = newMerchantService.getMerchantUserById(newMerchantUserModel.getObjectId());
            if (newMerchantUserModel != null)
                session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel); //保存绑定或者登录成功的用户信息
        }

        ApplicationModel applicationModel = null;
        mv.addObject("newMerchantUserModel", newMerchantUserModel);
        mv.addObject("industryGIds", newMerchantService.queryIndustrys());//查询所有一级行业
        mv.addObject("provinceIds", newMerchantService.queryProvinces());//查询所有省份
        mv.addObject("planFundTerm", allKindSelectService.getPlanFundTerm());//融资期限
        //==================判断是否是第一次登陆======begin==============
            newMerchantService.isFirstTimeLogin(session);//如果是第一次在微信小企额中登陆，会显示遮罩层
        //==================判断是否是第一次登陆==end==================

        if(step.equals("-1")){
            mv.addObject("step","0");
        }else{
            mv.addObject("step",step);
        }

        if (newMerchantUserModel != null) {
            if(newMerchantUserModel.getLeaseContractStartTime()!=null && !newMerchantUserModel.getLeaseContractStartTime().equals("") && newMerchantUserModel.getLeaseContractStartTime().length()>14){
                newMerchantUserModel.setLeaseContractStartTime(newMerchantUserModel.getLeaseContractStartTime().substring(0,newMerchantUserModel.getLeaseContractStartTime().length()-8));
            }

            if(newMerchantUserModel.getLeaseContractEndTime()!=null && !newMerchantUserModel.getLeaseContractEndTime().equals("") && newMerchantUserModel.getLeaseContractEndTime().length()>14){
                newMerchantUserModel.setLeaseContractEndTime(newMerchantUserModel.getLeaseContractEndTime().substring(0, newMerchantUserModel.getLeaseContractEndTime().length() - 8));
            }

            session.setAttribute("merchantId",newMerchantUserModel.getObjectId());
            applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                List list = newMerchantService.queryPosCreditsMids(applicationModel.getCreditId());
                mv.addObject("size", list.size()); //查询已经添加过的商编
                if(step.equals("-1") && applicationModel.getCreditId()!=null && !applicationModel.getCreditId().equals("")){
                    mv.addObject("step", "1");//首页显示第几个页面
                }
                if(step.equals("-1") && applicationModel.getCreditId()!=null && !applicationModel.getCreditId().equals("") && applicationModel.getIsDocumentLocked().equals("1")){
                    mv.addObject("step","2");//首页显示第几个页面
                }
            }
            if(applicationModel!=null && applicationModel.getAmountRequested()!=null){
                String  rnum = applicationModel.getAmountRequested()+"";
                if(rnum.contains(".")){
                    applicationModel.setRequestAmount(Integer.parseInt(String.valueOf(rnum.substring(0,rnum.length()-2))));
                }

            }
            if(applicationModel!=null && applicationModel.getAmountRequested()==null){
                applicationModel.setRequestAmount(0);
            }

        }
        //===============================================基础资料end=====================================
        //===============================================完善信息（填写申请）begin=====================================
        if (newMerchantUserModel != null) {
            //获取大类图片
            mv.addObject("uploadFileChildModels", newMerchantService.queryUploadFileChildModel2(newMerchantUserModel.getObjectId())); //查询所有子分组
            //获取小类，此处获取租赁合同或房产证照片
            mv.addObject("uploadFileChild", newMerchantService.queryUploadFileChildModel3(newMerchantUserModel.getObjectId())); //查询所有子分组

        }

        mv.addObject("wsCrmRestfulMerchantUrl", wsCrmRestfulMerchantUrl);

        //===============================================完善信息（填写申请）end=====================================

        //===============================================补件（补全资料）end=====================================
        if (newMerchantUserModel != null) {
            mv.addObject("uploadFileMainModels", newMerchantService.queryUploadFileMain(newMerchantUserModel.getObjectId(), true));//补件列表
        }
        mv.addObject("sourceType", "1");
        //===============================================补件（补全资料）end=====================================
        mv.addObject("wsJxlUrl",wsJxlUrl);//聚信立
        //===============================================红包 begin 优惠券=====================================
        /**
         *
         * 只能使用优惠券
         * 只显示优惠券，现金券不显示
         * 现金券可以提现使用
         * type： 1 现金券  0 优惠券
         * status：1 已经使用  0 未使用
         * session.setAttribute("couponIds","nonuse");
         */


        if(applicationModel!=null && applicationModel.getIsSubmitApplication()!=null && applicationModel.getIsDocumentLocked()!=null
                && (applicationModel.getIsSubmitApplication().equals("1") || applicationModel.getIsDocumentLocked().equals("1"))){

            //已提交申请，页面展示crm返回的优惠券信息
            mv.addObject("coupons", null);//查询未使用的优惠券
            mv.addObject("maxCoupon",null);
            mv.addObject("maxCouponId", "");
            session.setAttribute("couponIds", "");

        }else if (newMerchantUserModel != null && (session.getAttribute("couponIds")==null || session.getAttribute("couponIds").equals(""))) {

            if(applicationModel.getCoupons()==null ||   applicationModel.getCoupons().size()==0){
                List list = newMerchantService.queryCoupons(newMerchantUserModel.getObjectId(), "0", "0");
                applicationModel.setCoupons(list);
                mv.addObject("coupons", list);//查询未使用的优惠券
                if(applicationModel!=null &&  (applicationModel.getCoupons()== null || applicationModel.getCoupons().size()==0) && list.size()>0){
                    //取第一个值
                    Map map1 = (Map) list.get(0);
                    String num = map1.get("amount")+"";
                    num = num.substring(0,num.lastIndexOf("."));
                    Integer max = (Integer.parseInt(num)) ;

                    String maxId = map1.get("id")+"";
                    Map map = null;
                    for(int i = 0;i<list.size();i++){
                        map = (Map) list.get(i);
                        String tempNum = map.get("amount")+"";
                        String tempId = map.get("id")+"";
                        tempNum = tempNum.substring(0,tempNum.lastIndexOf("."));
                        Integer amount = (Integer.parseInt(tempNum)) ;
                        if(i>=1){
                            if(amount>max){
                                max = amount;
                                maxId = tempId;
                            }
                        }
                    }
                    //取最大值
                    mv.addObject("maxCoupon",max);
                    mv.addObject("maxCouponId",maxId);
                    session.setAttribute("couponIds", maxId);
                }
            }
        }else if(newMerchantUserModel!=null && newMerchantUserModel.getObjectId()!=null && session.getAttribute("couponIds")!=null && session.getAttribute("couponIds").equals("nonuse")){
            applicationModel.setCoupons(null);
            mv.addObject("coupons", null);//查询未使用的优惠券
            mv.addObject("maxCoupon",null);
            mv.addObject("maxCouponId", "");
            session.setAttribute("couponIds", "");
        }else if(newMerchantUserModel!=null && newMerchantUserModel.getObjectId()!=null && session.getAttribute("couponIds")!=null && !session.getAttribute("couponIds").equals("nonuse")){
            applicationModel.setCoupons(new ArrayList());
            //取用户选择的优惠券
            mv.addObject("couponIds",session.getAttribute("couponIds"));
            mv.addObject("maxCoupon",session.getAttribute("selectedName"));
        }
        mv.addObject("applicationModel", applicationModel);
        //===============================================红包 end =====================================

        //查询确认清单 : 1：申请信息，2：融资方案，3：融资保理通知书=================
        String type = null;
        if(applicationModel!=null && applicationModel.getCashadvanceStatus()!=null && applicationModel.getIsWithdrawConfirm()!=null && applicationModel.getCashadvanceStatus().equals("签约前审核完成") && applicationModel.getIsWithdrawConfirm().equals("0")){
            type = "2";
        }else if(applicationModel!=null && applicationModel.getCashadvanceStatus()!=null && applicationModel.getCashadvanceStatus().equals("还款清算")){
            type = "3";
        }else{
            type = "1";
        }
        if(type!=null && newMerchantUserModel!=null && newMerchantUserModel.getApplicationId()!=null){
            Map map =  newMerchantService.financingPlan(newMerchantUserModel.getApplicationId(),type);
            mv.addObject("plan",map);
        }
        //查询确认清单 : 1：申请信息，2：融资方案，3：融资保理通知书=================

        //================罩层显示=========secondaryBankName

        //获取授信情况
        if(applicationModel!=null && applicationModel.getCreditId() !=null && !applicationModel.getCreditId().equals("")){
            RestfulResult result = newMerchantService.getCredits(applicationModel.getCreditId());

            if(result!=null){

                CreditsTaskModel creditsTaskModel = (CreditsTaskModel)result.getResultData();
                if(creditsTaskModel!=null && creditsTaskModel.getInvalidDate()!=null){
                    mv.addObject("invalidDate", creditsTaskModel.getInvalidDate());//参考融资期限
                }

                if(creditsTaskModel!=null && creditsTaskModel.getPaymentMethodId()!=null){
                    mv.addObject("paymentMethodId", creditsTaskModel.getPaymentMethodId());//参考融资期限
                }

                if(creditsTaskModel!=null && creditsTaskModel.getPaymentMethod()!=null){
                    mv.addObject("paymentMethod",creditsTaskModel.getPaymentMethod());//还款方式
                }

                if(creditsTaskModel!=null && creditsTaskModel.getLoanPeriod()!=null){
                    mv.addObject("loanPeriod",creditsTaskModel.getLoanPeriod());//参考融资期限
                }
                SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if(creditsTaskModel!=null && creditsTaskModel.getInvalidDate()!=null){
                    Long difDay = 0l;
                    try {
                        difDay = Utility.getDateDiff(sdf.parse(creditsTaskModel.getInvalidDate()+" 00:00:00"),new Date(),"d");
                    } catch (ParseException e) {
                        logger.info("date parse failed :" + e);
                    }
                    mv.addObject("difDay",difDay);
                    logger.info(result.getResultData()+"");
                }

            }
        }
        return mv;
    }



    /**
     * 授信 - 倒计时
     *
     * @return
     */
    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult credit(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "正在计算额度!!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = null;
            if (session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT_APPLICATION) == null) {
                applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            } else {
                applicationModel = (ApplicationModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT_APPLICATION);
            }
            if (applicationModel != null) {
                //获取授信情况
                result = newMerchantService.getCredits(applicationModel.getCreditId());
                //如果剩余时间为0则计算成功
                if (!(result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS) && ((CreditsTaskModel) result.getResultData()).getWaitSeconds().equals("0"))) {
                    result = new RestfulResult("-1", "正在计算额度!!", null);
                }
            }
        }
        return result;
    }

    /**
     * 我的额度
     * 显示基础资料
     * @return
     */
    @RequestMapping(value = "/myLimit", method = RequestMethod.GET)
    public ModelAndView myLimit(HttpSession session) {

        //判断是否允许重算额度.
        ModelAndView mv = new ModelAndView("newm/basicLimit");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        mv.addObject("newMerchantUserModel", newMerchantUserModel);
        mv.addObject("industryPIds", newMerchantService.queryIndustrys());//查询所有一级行业
        mv.addObject("provinceIds", newMerchantService.queryProvinces());//查询所有省份
        mv.addObject("IsShow","2");

        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                List list = newMerchantService.queryPosCreditsMids(applicationModel.getCreditId());
                mv.addObject("size", list.size()); //查询已经添加过的商编
            }
        }
        return mv;
    }

    /**
     * POS额度 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/posLimit/show", method = RequestMethod.GET)
    public ModelAndView showPosLimit(HttpSession session,@RequestParam(required=false) String IsShow) {
        ModelAndView mv = new ModelAndView("newm/posLimit");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        //此处刷新用户信息，是因为在进入pos添加页面时，用户有可能修改了基础额度信息
        if(newMerchantUserModel!=null && newMerchantUserModel.getObjectId()!=null){
            newMerchantUserModel = newMerchantService.getMerchantUserById(newMerchantUserModel.getObjectId());
            if (newMerchantUserModel != null)
                session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel); //保存绑定或者登录成功的用户信息
        }

        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                List list = newMerchantService.queryPosCreditsMids(applicationModel.getCreditId());
                mv.addObject("posCreditsMids", list); //查询已经添加过的商编
                mv.addObject("checkFailMid", newMerchantService.queryCheckFailMid(list));//获取验证失的POS记录
                mv.addObject("processingMid", newMerchantService.queryProcessingMid(list));//获取正在授信的POS记录
                mv.addObject("makingQuestionsMid", newMerchantService.queryMakingQuestionsMid(list));//获取待生成验证问题的记录
            }
        }
        if(IsShow!=null) {
            mv.addObject("IsShow",IsShow);
        }else{
            mv.addObject("IsShow","2");
        }
        return mv;
    }

    /**
     * 局部刷新获取商编
     *
     * @return
     */
    @RequestMapping(value = "/posLimit/query", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult queryPosLimit(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "正在计算额度!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                List list = newMerchantService.queryPosCreditsMids(applicationModel.getCreditId());
                String isHaveMakingQuestionsMid = newMerchantService.queryMakingQuestionsMid(list) == null ? "0" : "1";//是否有正在生成问题的记录,1有，0没有
                Map map = new HashMap();
                map.put("isHaveMakingQuestionsMid",isHaveMakingQuestionsMid);
                map.put("posCreditsMids",list);
                result.setResultData(map);
                result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
            }
        }
        return result;
    }

    /**
     * POS额度
     * 1、创建商编.   http://192.168.0.208:81/rest/1.2/api.php/credits/4481/mids
     * 2、查询商编   http://192.168.0.208:81/rest/1.2/api.php/credits/4881/mids
     * 3、点击验证获取交易流水生成问题  http://192.168.0.208:81/rest/1.2/api.php/credits/4881/transactions
     * 4、开始验证回答问题(更新商编):http://192.168.0.208:81/rest/1.2/api.php/credits/4883/mids/998556666612345 ，获取验证问题如果没有流水提示给用户稍后再试，用户过一会点击以后如果获取到了就直接返回首页，
     * 5、第四步调用以后CRM会监听授信返回，如果返回验证成功，CRM会自动修改将isConputer置为0已经计算成功，此时微信首页直接显示授信的额度.
     *
     * @return
     */
    @RequestMapping(value = "/posLimit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult posLimit(PosLimitDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "正在计算额度!!", null);
        //查询授信id
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                dto.setCreditId(applicationModel.getCreditId());
                result = newMerchantService.posLimit(dto, session);
            }
        }
        return result;
    }

    /**
     * 基础额度 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/basicLimit/show", method = RequestMethod.GET)
    public ModelAndView showBasicLimit(HttpSession session,@RequestParam(required=false) String IsShow) {
        //判断是否允许重算额度.
        ModelAndView mv = new ModelAndView("newm/basicLimit");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        mv.addObject("newMerchantUserModel", newMerchantUserModel);
        mv.addObject("industryPIds", newMerchantService.queryIndustrys());//查询所有一级行业
        mv.addObject("provinceIds", newMerchantService.queryProvinces());//查询所有省份
        if(IsShow!=null) {
            mv.addObject("IsShow",IsShow);
        }else{
            mv.addObject("IsShow","2");
        }

        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                List list = newMerchantService.queryPosCreditsMids(applicationModel.getCreditId());
                mv.addObject("size", list.size()); //查询已经添加过的商编
            }
            mv.addObject("applicationModel", applicationModel);
        }


        return mv;
    }

    /**
     * 基础额度-通过省份查询城市
     *
     * @return
     */
    @RequestMapping(value = "/queryCitys", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult queryCitys(String provinceId) {
        if(provinceId==null || provinceId.trim().equals("") || provinceId.equals("0")){
            return new RestfulResult("1", "查询城市失败，请重新选择", null);
        }
        return new RestfulResult("1", "查询城市成功", newMerchantService.queryCitys(provinceId));
    }

    /**
     * 基础额度-根据一及行业id查询所有对应子行业
     *
     * @return
     */
    @RequestMapping(value = "/queryIndustryDetails", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult queryIndustryDetails(String industryId,HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "查询行业分类出错!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
       /* if (newMerchantUserModel != null) {
            return new RestfulResult("1", "查询子行业成功", newMerchantService.queryIndustryDetails(industryId,newMerchantUserModel.getObjectId()));
        }*/
        if (industryId != null) {
            return new RestfulResult("1", "查询子行业成功", newMerchantService.queryIndustryDetails(industryId,""));
        }
        return result;
    }


    /**
     * 基础额度-根据一及行业id查询所有对应子行业
     *
     * @return
     */
    @RequestMapping(value = "/queryIndustryPIdDetails", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult queryIndustryTidDetails(String industryId,HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "查询行业分类出错!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            return new RestfulResult("1", "查询子行业成功", newMerchantService.queryIndustryPidDetails(industryId, newMerchantUserModel.getObjectId()));
        }
        return result;
    }

    /**
     * 基础额度
     *
     * @return
     */
    @RequestMapping(value = "/basicLimit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult basicLimit(BasicLimitDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            return newMerchantService.basicLimit(dto, newMerchantUserModel, session);
        }
        return result;
    }


    /**
     * 聚信立额度 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/juxinliLimit/show", method = RequestMethod.GET)
    public ModelAndView showJuxinliLimit(HttpSession session) {
        //判断是否允许重算额度.
//        ModelAndView mv = new ModelAndView("newm/juxinliLimitLack");
        ModelAndView mv = new ModelAndView("newm/juxinliLimit");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        mv.addObject("newMerchantUserModel",newMerchantUserModel);
        mv.addObject("wsJxlUrl",wsJxlUrl);
        return mv;
    }

    /**
     * 聚信立额度
     * 将手机号码、姓名、身份证保存到CRM
     *
     * @return
     */
    @RequestMapping(value = "/juxinliLimit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult juxinliLimit(JuxinliLimitDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null && dto!=null) {
            return newMerchantService.juxinliLimit(dto, newMerchantUserModel, session);
        }
        return result;
    }


    /**
     * 征信报告授权展示
     * @param
     * @param session
     * @return
     */
    @RequestMapping(value = "/creditReport/show")
    public ModelAndView crediAauthorization(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/newm/creditReport");
        Map map = newMerchantService.crediAauthoriza(newMerchantUserModel,session);

        //征信报告图片
        mv.addObject("zhengxinFile", newMerchantService.queryUploadFileChildModel4(newMerchantUserModel.getObjectId())); //查询所有子分组
        mv.addObject("zhengxinMap",map);
        mv.addObject("wsCrmRestfulMerchantUrl", wsCrmRestfulMerchantUrl);
        mv.addObject("newMerchantUserModel",newMerchantUserModel);

        return mv;
    }



    /**
     * 获取验证码
     * @param session
     * @return
     */
    @RequestMapping(value = "/getvVerifyCode")
    @ResponseBody
    public Map getVerifyCode(HttpSession session) {
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        Map map = newMerchantService.crediAauthoriza(newMerchantUserModel,session);
        return map;
    }



    /**
     * 邮箱验证额度 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/emailLimit/show", method = RequestMethod.GET)
    public ModelAndView showEmailLimit(HttpSession session) {
        //判断是否允许重算额度.
        ModelAndView mv = new ModelAndView("newm/emailLimit");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        mv.addObject("newMerchantUserModel", newMerchantUserModel);
        return mv;
    }

    /**
     * 邮箱验证
     *
     * @return
     */
    @RequestMapping(value = "/emailLimit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult emailLimit(EmailLimitDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            return newMerchantService.emailLimit(dto, newMerchantUserModel, session);
        }
        return result;
    }


    /**
     * 修改用户基本资料
     *
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult updateUser(UpdateUserDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            if(session.getAttribute("couponIds")!=null){
                dto.setCouponIds(session.getAttribute("couponIds")+"");
            }else{
                dto.setCouponIds(null);
            }
            Map<String, Object> parameter = objectMapper.convertValue(dto, Map.class); // 对象转MAP
            return newMerchantService.updateMerchantUser(newMerchantUserModel.getObjectId(), parameter, session);
        }
        return result;
    }


    /**
     * 上传材料主页面 - 显示
     *
     * @return
     */
    @RequestMapping(value = "/uploadFile/show", method = RequestMethod.GET)
    public ModelAndView showUploadFile(HttpSession session, @RequestParam(defaultValue = "1") String selectedTabIndex,@RequestParam(defaultValue = "0")String isView) {
        ModelAndView mv = new ModelAndView("newm/uploadFile");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                mv.addObject("applicationModel", applicationModel);
            }
            //表示验证通过，直接进入上传资料界面
            mv.addObject("selectedTabIndex",selectedTabIndex.replace(" ",""));//选中tab
            mv.addObject("newMerchantUserModel", newMerchantUserModel);
        }

        if (newMerchantUserModel != null) {
            mv.addObject("uploadFileChildModels", newMerchantService.queryUploadFileChildModel2(newMerchantUserModel.getObjectId())); //查询所有子分组
        }
        mv.addObject("wsCrmRestfulMerchantUrl", wsCrmRestfulMerchantUrl);
        mv.addObject("isView", isView);
        return mv;
    }

    /**
     * 查询所有已经上传的文件
     * @param session
     * @return
     */
    @RequestMapping(value = "/getFiles", method = RequestMethod.POST)
    @ResponseBody
    public List getFiles(HttpSession session){
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        List list = null;
        if (newMerchantUserModel != null) {
            list = newMerchantService.queryUploadFileChildModel2(newMerchantUserModel.getObjectId()); //查询所有子分组
        }
        return list;
    }



    /**
     * 查询征信报告图片信息
     * @param session
     * @return
     */
    @RequestMapping(value = "/getSmallFiles", method = RequestMethod.POST)
    @ResponseBody
    public List getSmallFiles(HttpSession session){

        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        List list = new ArrayList();
        if(newMerchantUserModel!=null && newMerchantUserModel.getObjectId()!=null ){
            list = newMerchantService.queryUploadFileChildModel4(newMerchantUserModel.getObjectId());
        }
        return list;
    }


    /**
     * 上传材料
     * 5，提交申请；6：提交补件；7：确认申请；8：拒绝申请；
     *
     * @return
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult uploadFile(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                Map<String, Object> parameter = new HashMap<String, Object>();
                parameter.put("isSubmitApplication", "1");
                parameter.put("couponIds",session.getAttribute("couponIds"));
                result = newMerchantService.updateApplication(applicationModel.getObjectId(), parameter);
            }
        }
        return result;
    }

    @RequestMapping(value = "/getApplication", method = RequestMethod.POST)
    @ResponseBody
    public Map getApplication(HttpSession session) {

        Map map = new HashMap();
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            map.put("applicationModel",applicationModel);

            RestfulResult result = newMerchantService.getCredits(applicationModel.getCreditId());
            CreditsTaskModel creditsTaskModel = (CreditsTaskModel)result.getResultData();
            if(creditsTaskModel!=null && creditsTaskModel.getInvalidDate()!=null){
                map.put("invalidDate", creditsTaskModel.getInvalidDate());//参考融资期限
            }
            if(creditsTaskModel!=null && creditsTaskModel.getPaymentMethod()!=null){
                map.put("paymentMethod", creditsTaskModel.getPaymentMethod());//还款方式
            }
            if(creditsTaskModel!=null && creditsTaskModel.getLoanPeriod()!=null){
                map.put("loanPeriod", creditsTaskModel.getLoanPeriod());//参考融资期限
            }

            SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(creditsTaskModel!=null && creditsTaskModel.getInvalidDate()!=null){
                Long difDay = 0l;
                try {
                    difDay = Utility.getDateDiff(sdf.parse(creditsTaskModel.getInvalidDate()+" 00:00:00"),new Date(),"d");
                } catch (ParseException e) {
                    logger.info("date parse failed :" + e);
                }
                map.put("difDay", difDay);
            }

        }
        return map;
    }




    /**
     * 上传材料详细界面
     *
     * @param groupName  父分组名称
     * @param sourceType 返回页面类型
     * @param session
     * @return
     */
    @RequestMapping(value = "/uploadFileDetail/show", method = RequestMethod.GET)
    public ModelAndView uploadFileDetail(String groupName, @RequestParam(defaultValue = "1") String sourceType, HttpSession session,@RequestParam(defaultValue = "1")String isView) {
        ModelAndView mv = new ModelAndView("newm/uploadFileDetail");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            mv.addObject("newMerchantUserModel", newMerchantUserModel);
            mv.addObject("uploadFileChildModels", newMerchantService.queryUploadFileChildModel(newMerchantUserModel.getObjectId(), Utility.transcoding(groupName))); //查询所有子分组
        }
        mv.addObject("wsCrmRestfulMerchantUrl", wsCrmRestfulMerchantUrl);
        mv.addObject("sourceType", sourceType);
        mv.addObject("isView", "2");
        mv.addObject("groupName", Utility.transcoding(groupName));
        String str =  Utility.transcoding(groupName);
        return mv;
    }

    /**
     * 补件父界面 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/addFile/show", method = RequestMethod.GET)
    public ModelAndView showAddFile(@RequestParam(defaultValue = "1") String sourceType, HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/addFile");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            mv.addObject("uploadFileMainModels", newMerchantService.queryUploadFileMain(newMerchantUserModel.getObjectId(), true));//补件列表
        }
        mv.addObject("sourceType", sourceType);
        return mv;
    }

    /**
     * 补件子界面 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/addFileDetail/show", method = RequestMethod.GET)
    public ModelAndView showAddFileDetail(String baoliId) {
        ModelAndView mv = new ModelAndView("newm/addFile");
        mv.addObject("baoliId", baoliId);
        return mv;
    }

    /**
     * 补件
     * 5，提交申请；6：提交补件；7：确认申请；8：拒绝申请；
     *
     * @return
     */
    @RequestMapping(value = "/addFile", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult addFile(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                Map<String, Object> parameter = new HashMap<String, Object>();
                parameter.put("type", "6");
                result = newMerchantService.updateApplication(applicationModel.getObjectId(), parameter);
            }
        }
        return result;
    }


    /**
     * 还款明细 - 初次进入界面
     * 小企额1.3版本
     * @return
     */
    @RequestMapping(value = "/refundDetail", method = RequestMethod.GET)
    public ModelAndView refundDetail(@RequestParam String baoliId,@RequestParam(defaultValue = "1") String sourceType) {
        ModelAndView mv = new ModelAndView("newm/refundDetail");
        try {
            //返回查询明细
            List<HashMap<String, String>> lists = merchantService.bankStatementLists(baoliId);
            mv.addObject("lists",lists);
            mv.addObject("sourceType", sourceType);
        } catch (Exception e) {
            logger.error("获取对账单记录出错:", e.getMessage());
        }
        return mv;
    }

    /**
     * 还款明细 - 初次进入界面
     * 小企额2.0版本
     * @return
     */
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    public ModelAndView getDetail(String applicationId, @RequestParam(required=false,defaultValue = "0") String skip,@RequestParam(required = false,defaultValue = "100")String limit) {
        ModelAndView mv = new ModelAndView("newm/refundDetail");
        if(applicationId == null || applicationId.equals("")){
            return mv;
        }
        try {
            Map  map = merchantService.getStatementLists(applicationId,skip,limit);
            mv.addObject("map",map);
        } catch (Exception e) {
            logger.error("获取对账单记录出错:", e.getMessage());
        }
        return mv;
    }


    /**
     * 还款明细 - 初次进入界面
     * 手机端调用
     * @return
     */
    @RequestMapping(value = "/loadRefundDetail", method = RequestMethod.GET)
    @ResponseBody
    public Map loadRefundDetail(String applicationId, @RequestParam(required=false,defaultValue = "0") String skip,@RequestParam(required = false,defaultValue = "100")String limit) {

        if(applicationId == null || applicationId.equals("")){
            return null;
        }
        try {
            Map  map = merchantService.getStatementLists(applicationId,skip,limit);
            if(map!=null || map.get("results")!=null){
                Map map1 = (Map) map.get("results");
            }
            return map;
            //返回查询明细1.3版本
           /* List<HashMap<String, String>> lists = merchantService.bankStatementLists(baoliId);
            return lists;*/

        } catch (Exception e) {
            logger.error("获取对账单记录出错:", e.getMessage());
        }
        return null;
    }


    /**
     * 商户所有申请状态列表 申请|线索
     *
     * @return
     */
    @RequestMapping(value = "/applyStatus/show", method = RequestMethod.GET)
    public ModelAndView showApplyStatus(HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/applyStatus");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) { //查询已存在的基础信息
            mv.addObject("applications", newMerchantService.queryApplications(newMerchantUserModel.getObjectId()));
        }
        return mv;
    }

    /**
     * 创建新申请
     * 首贷
     * 1.改更新申请 ，线索状态为 "12:额度已核算"
     * 2.开始添加授权记录
     * 续贷
     * 1.创建申请 - 创建新申请  {"leadStatus":"76","appId":4345}
     * 2.开始添加授权
     *
     * @return
     */
    @RequestMapping(value = "/applyStatus", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult applyStatus(HttpSession session, HttpServletRequest request) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {

            //表示首次贷款或续贷贷款调用同一方法
            result = newMerchantService.createApplication(newMerchantUserModel.getObjectId(), session);
            if (result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS)) {
                //插入条款 - 申请类型
               /* result = newMerchantService.accredit(Constants.CLAUSE_TYPE_ALL, newMerchantUserModel.getObjectId(), null, newMerchantUserModel.getMobilePhone(), Utility.getRemoteIp(request),
                        session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString(),
                        null, newMerchantUserModel.getLongitude() + "," + newMerchantUserModel.getLatitude(), request.getHeader("user-agent"));*/

                //如果是续贷，要提醒前端授信额度已经过期，需要重新授信，跳转到授信界面
                if (result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS)) {
                    if ((newMerchantService.queryApplications(newMerchantUserModel.getObjectId()).size() >= 1 &&
                            StringUtils.isNotBlank(newMerchantUserModel.getIsRenewable()) && newMerchantUserModel.getIsRenewable().equals("1"))) {
                        result.setResultData("1");//表示续贷
                    }
                }
            }

        }
        return result;
    }

    /**
     * 申请书待确认 - 显示界面
     * 提现确认
     * @return
     */
    @RequestMapping(value = "/affirmLoans/show", method = RequestMethod.GET)
    public ModelAndView showAffirmLoans(HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/affirmLoans");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            mv.addObject("confirmlists", newMerchantService.queryConfirmlists(newMerchantUserModel.getApplicationId()));//调用查询确认文件清单接口   //正式代码
            mv.addObject("newMerchantUserModel", newMerchantUserModel);
        }
        return mv;
    }

    /**
     * 申请书待确认 - 确认|放弃
     * 同意  1.更改申请type为:7  2.添加确认授权条款
     * 拒绝  1.更改申请type为:8 拒绝原因:canceldescother
     * 状态  5，提交申请；6：提交补件；7：确认申请；8：拒绝申请；
     *
     * @return
     */
    @RequestMapping(value = "/affirmLoans", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult affirmLoans(String isOk, String reson, HttpSession session, HttpServletRequest request,String checkCode) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        String checkCodeResult = null;
        if (checkCodeResult == null) {
            if (newMerchantUserModel != null) {
                ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
                Map<String, Object> parameter = new HashMap<String, Object>();
                if (applicationModel != null) {//如果申请不为空
                    if (StringUtils.isNotBlank(isOk) && isOk.equals("1")) {
                        parameter.put("type", "7");
                        result = newMerchantService.updateApplication(applicationModel.getObjectId(), parameter);
                    } else if (StringUtils.isNotBlank(isOk) && isOk.equals("0") && StringUtils.isNotBlank(reson)) {
                        //表示拒绝
                        parameter.put("type", "8");
                        parameter.put("canceldescOther", reson);
                        result = newMerchantService.updateApplication(applicationModel.getObjectId(), parameter);
                    }
                }

            }
        } else {
            result.setResultMsg(checkCodeResult);
        }
        return result;
    }

    /**
     * 商户身份验证 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/verify/show", method = RequestMethod.GET)
    public ModelAndView showVerify(HttpSession session, String mid) {
        ModelAndView mv = new ModelAndView("newm/verify");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                //获取验证问题并生成验证问题
                List questions = newMerchantService.getVerifyQuestion(applicationModel.getCreditId(), mid); //正式代码
                mv.addObject("questions", questions);
                session.setAttribute("questions", questions);//将问题保存到session
            }
        }
        mv.addObject("mid", mid);
        return mv;
    }

    /**
     * 随机生成验证问题公共方法 - ios | android
     *
     * @return
     */
    @RequestMapping(value = "/verify/query", method = RequestMethod.GET)
    @ResponseBody
    public List queryVerify(String creditId,String mid) {
        if(creditId == null || mid == null ){
            return new ArrayList();
        }
        List questions = newMerchantService.getVerifyQuestion(creditId, mid);
        return questions;
    }

    /**
     * 商户身份验证 1.3
     * 验证pos流水
     * @return
     */
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult verify(String mid,String midVerification,String selectedAmt, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            String credits = applicationModel.getCreditId();
            result = newMerchantService.validateQuestionAnswer(selectedAmt, credits, midVerification,session);
        }
        return result;
    }


    /**
     * 获取客户端最新版本信息
     *
     */
    @RequestMapping(value = "/clientVersion/query", method = {RequestMethod.GET})
    @ResponseBody
    public RestfulResult queryClientVersion(String type) {
        RestfulResult result = new RestfulResult("-1", "获取客户端最新版本信息出错!", null);
        try {
            List<ClientVersion> list = clientVersionRepository.findByType(type);
            List<WelecomeSet> welecomeSets = welecomeSetRepository.findWelecomeSetByStatus("1");
            if (list != null && list.size() > 0) {
                if(welecomeSets!=null && welecomeSets.size()>0){
                    list.get(0).setWelecomeSet(welecomeSets.get(0));
                }
                result.setResultData(list.get(0));
                result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
                result.setResultMsg("获取客户端最新版本信息成功!");
            }
        }catch (Exception e){
            logger.info("==============获取客户端最新版本信息====================="+e);
        }

        return result;
    }

    /**
     * 我的红包
     *
     * @return
     */
    @RequestMapping(value = "/redPacket", method = RequestMethod.GET)
    public ModelAndView redPacket() {
        ModelAndView mv = new ModelAndView("newm/redPacket");
        return mv;
    }

    /**
     * 我的红包
     *
     * @return
     */
    @RequestMapping(value = "/inviteMerchant", method = RequestMethod.GET)
    public ModelAndView inviteMerchant() {
        ModelAndView mv = new ModelAndView("newm/inviteMerchant");
        return mv;
    }

    /**
     * 活动设置
     * @return
     */
    @RequestMapping(value = "/welcome/query", method = {RequestMethod.GET})
    @ResponseBody
    public RestfulResult queryWelcomePic() throws IOException {
        RestfulResult result = new RestfulResult("-1", "获取客户端最新活动信息出错!", null);
        List<WelecomeSet> list = welecomeSetRepository.findWelecomeSetByStatus("1");
        if (list != null && list.size() > 0) {
            result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
            result.setResultMsg("获取广告图成功!");
            result.setResultData(list.get(0));
        }
        return result;
    }

    /**
     * 百度地图
     * @return
     */
    @RequestMapping(value = "/getMultiLngAndLat", method = {RequestMethod.GET})
    @ResponseBody
    public Object getMultiLngAndLat(String address) {
        HashMap map = null;
        if(address==null || address.equals("") || StringUtils.trim(address).equals("")){
            map = new HashMap();
            map.put("code","-1");
            map.put("resultCode","-1");
            map.put("error","查询地址不能为空!");
            return (Object)map;
        }
        try {
            address = new String(address.getBytes("ISO-8859-1"),"utf-8");
            address = address.replaceAll(" ","");
        } catch (UnsupportedEncodingException e) {
            logger.info("获取位置信息失败："+e);
        }
        logger.info("地址:========="+address);
        Object result = BaiDuMapUtil.getMultiLngAndLat(address);
        String res = ((HashMap)result).get("resultData")+"";
        if(res!=null && res.contains("Failure") && res.contains("Ral")){
            map = new HashMap();
            map.put("code","-1");
            map.put("resultCode","-1");
            map.put("error","没有找到你要的位置!");
            return (Object)map;
        }
       /* if (((HashMap)result).get("resultData") != null && ((List) ((HashMap) result).get("resultData")).size() < 1) {
            //继续调用查询单个地址
            return BaiDuMapUtil.getSingleLngAndLat(address);
        }*/
        return result;
    }


    /**
     * 调用百度地图、获取地理位置
     * @param address
     * @return
     */
    @RequestMapping(value = "/gpsPosition")
    @ResponseBody
    public Object gspPosition(@RequestParam(required = false)String address){
        Object result = this.getMultiLngAndLat(address);
        return result;
    }


    /**
     * 选择位置
     * @param city
     * @param district
     * @param name
     * @param lngAndlat
     * @return
     */
    @RequestMapping(value = "/chosePosition")
    public ModelAndView chosePosition(@RequestParam(required = false)String city,String district,String name,String lngAndlat){
        RestfulResult result = new RestfulResult();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:newm/basicLimit");
        mv.addObject("result",result);
        return mv;
    }

    /**
     *征信报告授权
     * @param session
     * @return
     */
    @RequestMapping(value = "/creditReport")
    @ResponseBody
    public Map creditReport(CreditReportModel reportModel,HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        ModelAndView mv = new ModelAndView();
        Map map = newMerchantService.creditReport(reportModel, newMerchantUserModel.getApplicationId(), session);
        mv.addObject("map", map);

        return map;
    }


}
