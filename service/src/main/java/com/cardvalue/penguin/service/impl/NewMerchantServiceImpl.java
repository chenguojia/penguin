package com.cardvalue.penguin.service.impl;


import com.cardvalue.penguin.dto.*;
import com.cardvalue.penguin.model.*;
import com.cardvalue.penguin.repository.ActionLogRepository;
import com.cardvalue.penguin.repository.LoginModelRepository;
import com.cardvalue.penguin.service.NewMerchantService;
import com.cardvalue.penguin.service.UtilityService;
import com.cardvalue.penguin.service.WeChatService;
import com.cardvalue.penguin.util.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service(value = "newMerchantService")
public class NewMerchantServiceImpl implements NewMerchantService {

    @Resource
    private LoginModelRepository loginModelRepository;
    public NewMerchantServiceImpl() {
    }

    private final static Logger logger = LoggerFactory.getLogger(NewMerchantServiceImpl.class);

   /* @Resource
    private MerchantServiceImplPortBindingStub merchantServiceImplPortBindingStub; // 获取商户流水验证问题接口*/

    @Resource
    private NewMerchantService newMerchantService;

    @Resource
    private UtilityService utilityService;

    @Resource
    private ActionLogRepository actionLogRepository;

    @Value("${ws.crm.restful.merchant.url}")
    private String wsCrmRestfulMerchantUrl;

    @Value("${ws.jxl.url}")
    private String wsJxlUrl;

    @Value("${ws.jxl.url.crm}")
    private String getWsJxlUrl;

    @Value("${ws.local.ip}")
    private String wsLocalIp;

    @Resource
    private WeChatService weChatService;

    @Resource
    private AuthenticationManager authenticationManager;


    @Resource
    private HttpServletRequest request;


    //定义一个全局的tempStr，用于接口调用时接收返回结果，在异常日志中打印出来
    String tempStr = "";

    /**
     * 用户绑定接口
     *
     * @param code    微信编码
     * @param session
     * @param request
     * @return
     */
    public NewMerchantUserModel enter(String code, HttpSession session, HttpServletRequest request) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("code", code);

        NewMerchantUserModel newMerchantUserModel = null;
        //默认如果OPENID为空或未绑定,则跳转到绑定界面
        String openId = weChatService.getOpenIdByAccessToken(code);
        if (StringUtils.isBlank(openId)) {
            openId = code; //测试代码
        }
        if (openId != null) {
            session.setAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID, openId);
            try {
                //判断此微信的OPENID是否已经绑定过
                String url = wsCrmRestfulMerchantUrl + "/wechatUsers/" + openId;
                String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
                tempStr = responseBody;
                if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                    //表示已经绑定过
                    Map<String, String> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, String>>() {
                    });
                    //调用接口储存登录的信息
                    newMerchantUserModel = this.getMerchantUserById(map.get("merchantId"));
                    //判断绑定的用户是否存在
                    if (newMerchantUserModel != null) {
                        //保存绑定或者登录成功的用户信息
                        session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel);
                        //设置特殊的用户名和密码
                        authenticateUserAndSetSession(Constants.SESSION_KEY_NEW_MERCHANT, Constants.SESSION_KEY_NEW_MERCHANT, request);
                    }
                } else {
                    //未绑定返回绑定界面
                    logger.info("调用查询用户是否绑定接口 - CRM返回错误：responseBody ", responseBody);
                }
            } catch (Exception e) {
                String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
            }
        }
        return newMerchantUserModel;
    }

    /**
     * SPRING-SECURITY框架登录
     *
     * @param username 用户名
     * @param password 密码
     * @param request  请求
     */
    private void authenticateUserAndSetSession(String username, String password, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

    /**
     * 获取验证问题交易流水
     *
     * @param creditId 获取验证问题流水的授信id
     * @return
     */
    public List getVerifyQuestion(String creditId, String mid) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("creditId", creditId);
        callMethodParams.put("X-CRM-Access-Token", request.getSession().getAttribute("accessToken") + "");
        List<VerifyQuestionModel> questions = new ArrayList<VerifyQuestionModel>(); //问题集合
        List<TransactionsModel> list = new ArrayList<TransactionsModel>();
        try {

            //小企额1.3
            String url = wsCrmRestfulMerchantUrl + "/credits/" + creditId + "/mids/" + mid + "/verifyQuestion";
            Map parameter = new HashMap();
            //小企额1.2
//            String url = wsCrmRestfulMerchantUrl + "/credits/" + creditId + "/transactions";
//            parameter.put("where", "{\"mid\":\"" + mid + "\"}");
            //小企额1.2
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //获取交易流水
                HashMap<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<HashMap<String, Object>>() {
                });
                List listRes = null;
                if (map.get("answers") != null) {
                    listRes = (List) map.get("answers");
                }
                VerifyQuestionModel questionModel = new VerifyQuestionModel();
                questionModel.setId(1);
                questionModel.setQuestionAnswers((List) map.get("answers"));
                questionModel.setQuestionTitle((String) map.get("question"));
                questionModel.setQuestionRightAnswers(Double.parseDouble(map.get("correctAnswers") + ""));
                logger.info("correctAnswers:" + map.get("correctAnswers"));
                questionModel.setVerifyId(map.get("verifyId") + "");
                questions.add(questionModel);
            } else {
                String errorMsg = "调用crm接口:获取验证问题交易流水失败!responseBody:" + responseBody;
                logger.info(errorMsg);
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return questions;
    }

    /**
     * 修改授信系统验证问题次数
     *
     * @param creditId  授信id
     * @param mid       验证问题的mid
     * @param parameter 调用验证问题接口需要的参数
     * @return
     */
    public RestfulResult updateCreditCheckQuestions(String creditId, String mid, Map parameter) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("creditId", creditId);
        callMethodParams.put("mid", mid);
        callMethodParams.put("parameter", parameter);

        RestfulResult result = new RestfulResult("-1", "系统出错!", null);//定义返回
        try {
            String url = wsCrmRestfulMerchantUrl + "/credits/" + creditId + "/mids/" + mid;
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, Constants.HTTP_METHOD_PUT, mapper.writeValueAsString(parameter));//修改使用put方式
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回验证剩余次数和验证状态
                CreditVerifyQuestionModel creditVerifyQuestionModel = new ObjectMapper().readValue(responseBody, new TypeReference<CreditVerifyQuestionModel>() {
                });
                //返回结果
                result.setResultCode("1");
                result.setResultMsg("修改成功!");
                result.setResultData(creditVerifyQuestionModel);
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口:修改授信系统验证问题次数失败!";
              /*  utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }


    /**
     * 微信绑定新商户
     *
     * @param dto     前台传入参数
     * @param session
     * @param request 请求
     * @return
     */
    public RestfulResult bind(BindDTO dto, HttpSession session, HttpServletRequest request) {
        //记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        callMethodParams.put("openId", session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID));
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
//        String checkCodeResult = utilityService.validateCheckCode(session, dto.getMobile(), dto.getCheckCode());
        String checkCodeResult = null;//小企额1.3.0版本开始，短信由CRM端校验，微信端不再进行短信校验。
//        if (!wsLocalIp.equals("192.168.0.209")) checkCodeResult = null;//正式环境发短信
        if (checkCodeResult == null) {
            //验证码成功,判断是否存在OPENID
            if (session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null) {
                result.setResultMsg("本系统只允许使用在微信内使用!");
                return result;
            }
            Map parameter = new HashMap();//构建参数
            parameter.put("openId", session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID));
            parameter.put("mobilePhone", dto.getMobile());
            parameter.put("mobilePhoneVerified", "1");
            //注册时处理加密
            String password = dto.getPassword();
            password = Encryption.encryptionUFR(password);
            parameter.put("password", password);
            parameter.put("inviteCode", dto.getInviteCode());
            parameter.put("type", "5");
            parameter.put("mobilePhoneVerifyCode", dto.getCheckCode());
            parameter.put("ipAddress",Utility.getRemoteIp(request));
            parameter.put("blackBox",session.getAttribute("blackBox"));


            result = this.bindOrForgetPassword(parameter, result, callMethodParams, session, request);
        } else {
            result.setResultMsg(checkCodeResult);
        }
        return result;
    }

    /**
     * 忘记密码
     *
     * @param dto     前台传入参数
     * @param session
     * @return
     */
    public RestfulResult forgetPassword(ForgetPasswordDTO dto, HttpSession session) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        Map parameter = new HashMap();
//        String checkCodeResult = utilityService.validateCheckCode(session, dto.getMobile(), dto.getCheckCode());
        String checkCodeResult = null;
        if (!wsLocalIp.equals("192.168.0.209")) checkCodeResult = null;//正式环境发短信
        if (checkCodeResult == null) {

            parameter.put("mobilePhone", dto.getMobile());
            parameter.put("mobilePhoneVerified", "1");
            String password = dto.getPassword();
            //忘记密码时，处理加密
            password = Encryption.encryptionUFR(password);
            parameter.put("password", password);
            parameter.put("type", "2");
            parameter.put("mobilePhoneVerifyCode", dto.getCheckCode());
            if (session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) != null) {
                result = this.bindOrForgetPassword(parameter, result, callMethodParams, session, null); //登录
            } else {
                result.setResultMsg("本系统只允许使用在微信内使用!");//
                return result;
            }
        } else {
            result.setResultMsg(checkCodeResult);
        }

        return result;
    }

    /**
     * 绑定或忘记密码公用方法
     * @param parameter        接口调用需传入参数
     * @param result           返回结果
     * @param callMethodParams 出错参数记录
     * @param session
     * @param request          请求
     */
    private RestfulResult bindOrForgetPassword(Map parameter, RestfulResult result, Map callMethodParams, HttpSession session, HttpServletRequest request) {
        // 调用绑定接口
        try {
            String url = wsCrmRestfulMerchantUrl + "/merchantsByMobilePhone";
            if (this.accredit(Constants.CLAUSE_TYPE_ALL, null, null, parameter.get("mobilePhone")+"", Utility.getRemoteIp(request),
                    session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString(),
                    null, "", request.getHeader("user-agent")).getResultCode().
                    equals(Constants.RESTFUL_RESULT_SUCCESS)) {
            } else {
                result.setResultMsg("授权失败!");
            }

            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //绑定成功,储存绑定商户信息
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });

                session.setAttribute("accessToken", map.get("accessToken"));//保存token
                session.setAttribute("objectId", map.get("objectId"));//保存用户id
                NewMerchantUserModel newMerchantUserModel = this.getMerchantUserById(map.get("objectId"));

                if (newMerchantUserModel != null) {
                    if (request != null) {
                        //表示是绑定时调用，继续创建授权
                        if (this.accredit(Constants.CLAUSE_TYPE_ALL, newMerchantUserModel.getObjectId(), null, newMerchantUserModel.getMobilePhone(), Utility.getRemoteIp(request),
                                session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString(),
                                null, newMerchantUserModel.getLongitude() + "," + newMerchantUserModel.getLatitude(), request.getHeader("user-agent")).getResultCode().
                                equals(Constants.RESTFUL_RESULT_SUCCESS)) {
                            //保存绑定或者登录成功的用户信息
                            session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel);
                            //设置特殊的用户名和密码
                            authenticateUserAndSetSession(Constants.SESSION_KEY_NEW_MERCHANT, Constants.SESSION_KEY_NEW_MERCHANT, request);
                            result.setResultCode("1");
                            result.setResultMsg("成功!");
                            //判断是否已经同意过条款
                            if (StringUtils.isNotBlank(newMerchantUserModel.getAgreeToLicense()) && newMerchantUserModel.getAgreeToLicense().equals("1")) {
                                result.setResultData("1");
                            }
                        } else {
                            result.setResultMsg("授权失败!");
                        }
                    } else {
                        //表示是忘记密码调用，直接返回成功
                        result.setResultCode("1");
                        result.setResultMsg("成功!");
                    }
                } else {
                    result.setResultMsg("绑定用户成功，获取用户信息失败!");
                }
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                /*String errorMsg = "调用crm接口:绑定或忘记密码公用方法失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_BIND, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }


    /**
     * 登录
     *
     * @param dto     前台传入参数
     * @param session
     * @param request 请求
     * @return
     */
    public RestfulResult login(LoginDTO dto, HttpSession session, HttpServletRequest request) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);//定义返回
        Map parameter = new HashMap();//构建参数
        parameter.put("mobilePhone", dto.getMobile());
        parameter.put("ipAddress",Utility.getRemoteIp(request));
        parameter.put("blackBox",session.getAttribute("blackBox"));
        String password = dto.getPassword();
        //登录时加密处理
        password = Encryption.encryption(password);

        parameter.put("password", password);
        //卡兜暂时没有认证，测试环境中暂时手动添加openId
//        session.setAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID,UUIDGenerator.getUUID());
        //判断有无OPENID
        if (session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) != null) {
            parameter.put("openId", session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString());
        } else {
            result.setResultMsg("本系统只允许使用在微信内使用!");
            return result;
        }
        //调用接口,
        try {
            //如果需要授权，先进行授权，再进行登录
            if(dto.getType()==true){
                RestfulResult res =  this.accredit(Constants.CLAUSE_TYPE_ALL, null, null, dto.getMobile(), Utility.getRemoteIp(request),
                        session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString(),
                        null, "", request.getHeader("user-agent"));
                if(!res.getResultCode().equals("1")){
                    res.setResultCode("-1");
                    res.setResultMsg("授权失败");
                    return res;
                }

            }

            String url = wsCrmRestfulMerchantUrl + "/login";
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("207") > 0) {
                result.setResultMsg("用户名或密码错误!");
            }
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //登录成功
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                session.setAttribute("accessToken", map.get("accessToken"));//保存token
                logger.info("accessToken==================" + map.get("accessToken"));
                session.setAttribute("objectId", map.get("objectId"));//保存用户id
                NewMerchantUserModel newMerchantUserModel = this.getMerchantUserById(map.get("objectId"));

                if (newMerchantUserModel != null) {
                    //保存绑定或者登录成功的用户信息
                    session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel);
                    //设置特殊的用户名和密码
                    authenticateUserAndSetSession(Constants.SESSION_KEY_NEW_MERCHANT, Constants.SESSION_KEY_NEW_MERCHANT, request);
                    //返回成功
                    result.setResultCode("1");
                    result.setResultMsg("成功!");

                } else {
                    result.setResultMsg("获取用户失败!");
                }

            } else {
//                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
//                });
//                result.setResultMsg(map.get("error"));
//                String errorMsg = "调用crm接口:登录失败!";
                //utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_BIND, new Date(),
                // this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }

    /**
     * 登出
     *
     * @param session
     * @return
     */
    public RestfulResult logout(HttpSession session) {
        String openId = session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString();
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("openId", openId);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);//定义返回
        Map parameter = new HashMap();//构建参数
        try {
            String url = wsCrmRestfulMerchantUrl + "/wechatUsers/" + openId + "/logout";
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));//修改使用put方式
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //session移除登录用户对象
                session.removeAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
                //返回成功结果集
                result.setResultCode("1");
                result.setResultMsg("成功!");
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
              /*  String errorMsg = "调用crm接口:登出失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_BIND, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }

    /**
     * 修改密码
     *
     * @param dto 前台传入参数
     * @return
     */
    public RestfulResult updatePassword(UpdatePasswordDTO dto) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        //定义返回
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        try {
            Map parameter = new HashMap();
            String oldPassword = dto.getOldPassword();
            String newPassword = dto.getNewPassword();
            //修改密码时处理加密
            oldPassword = Encryption.encryptionUFR(oldPassword);
            newPassword = Encryption.encryptionUFR(newPassword);

            parameter.put("oldPassword", oldPassword);
            parameter.put("newPassword", newPassword);

            String url = wsCrmRestfulMerchantUrl + "/merchants/" + dto.getMerchantId() + "/updatePassword";
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, Constants.HTTP_METHOD_PUT, mapper.writeValueAsString(parameter));//修改使用put方式
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //修改成功
                result.setResultCode("1");
                result.setResultMsg("成功!");
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
              /*  String errorMsg = "调用crm接口:修改密码失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_UPDATE_PASSWORD, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }

    /**
     * 获取商户对应的用户
     *
     * @param merchantUserId 用户id
     * @return
     */
    public NewMerchantUserModel getMerchantUserById(String merchantUserId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantUserId", merchantUserId);
        NewMerchantUserModel newMerchantUserModel = null;
        try {
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantUserId;
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功,处理业务逻辑
                newMerchantUserModel = new ObjectMapper().readValue(responseBody, new TypeReference<NewMerchantUserModel>() {
                });
            } else {
                String errorMsg = "调用crm接口:获取商户对应的用户失败!";
              /*  utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return newMerchantUserModel;
    }


    /**
     * 创建授权
     *
     * @param type          授权类型 1：同意注册条款；2：同意授权条款；3：同意申请条款；4：同意确认条款
     * @param merchantId    商户对应的用户ID，类型为1、2时必填
     * @param applicationId 商户对应的申请ID，类型为3、4时必填
     * @param mobilePhone   用户手机号
     * @param ip            用户IP
     * @param openId        微信ID
     * @param deviceNumber  手机序列号
     * @param gps           当前GPS
     * @param agent         浏览器对应的agent
     * @return
     */
    public RestfulResult accredit(String type, String merchantId, String applicationId, String mobilePhone,
                                  String ip, String openId, String deviceNumber, String gps, String agent) {
        //构建返回
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        Map<String, Object> callMethodParams = null;
        try {
            Map parameter = new HashMap(); //构建参数
            parameter.put("type", type);
            parameter.put("merchantId", merchantId);
            parameter.put("applicationId", applicationId);
            parameter.put("mobilePhone", mobilePhone);
            parameter.put("openId", openId);
            parameter.put("time", Utility.formatBasicDate(new Date()));
            parameter.put("ip", ip);
            parameter.put("deviceNumber", deviceNumber);
            parameter.put("gps", gps);
            parameter.put("agent", agent);
            parameter.put("time", new Date());
            callMethodParams = parameter; //记录日志 - 记录当前请求参数
            String url = wsCrmRestfulMerchantUrl + "/authorizations";//调用接口
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultData(map.get("objectId"));//返回授权新建的id
                result.setResultCode("1");
                result.setResultMsg("成功!");
            } else {
                //打印错误信息到前台
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                /*String errorMsg = "调用crm接口:创建授权失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_BIND, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            logger.info("授权:" + e);
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }

    /**
     * 获取申请记录
     * 此申请不代表是APPID而是APPLICATIONID
     *
     * @param applicationId
     * @return
     */
    public ApplicationModel getApplicationById(String applicationId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("applicationId", applicationId);

        callMethodParams.put("X-CRM-Access-Token", request.getSession().getAttribute("accessToken"));
        ApplicationModel applicationModel = null;
        if (StringUtils.isBlank(applicationId)) return applicationModel;
        try {
            String url = wsCrmRestfulMerchantUrl + "/applications/" + applicationId;
            logger.info("获取申请信息：url：" + url);
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功,处理业务逻辑
                applicationModel = new ObjectMapper().readValue(responseBody, new TypeReference<ApplicationModel>() {
                });
                logger.info("获取申请信息：applicationModel：" + applicationModel);
            } else {
                logger.info("获取申请记录失败[responseBody]： " + responseBody);
               /* String errorMsg = "调用crm接口:获取申请记录失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return applicationModel;
    }

    /**
     * 提交POS额度 - 创建商编
     *
     * @param dto     前台传入参数
     * @param session
     * @return
     */
    public RestfulResult posLimit(PosLimitDTO dto, HttpSession session) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        if (StringUtils.isBlank(dto.getCreditId())) return result;
        try {
            String url = wsCrmRestfulMerchantUrl + "/credits/" + dto.getCreditId() + "/mids";
            Map parameter = new HashMap();
            parameter.put("mid", dto.getMids());
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                result.setResultCode("1");//{"resCode":"0000","resMsg":"添加成功"}
                /*AddMidModel addMidModel = mapper.readValue(responseBody, new TypeReference<AddMidModel>() {
                });*/ //将添加商编以后的状态返回前台,状态只可能为2个：Q生成验证问题中、U问题已经生成完毕
                HashMap map = mapper.readValue(responseBody, new TypeReference<HashMap>() {
                });
                result.setResultData(map);
                result.setResultMsg("调用成功!");//
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
              /*  String errorMsg = "调用提交POS额度创建商编 失败!"; //返回错误信息接口
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }


    /**
     * 提交基础额度
     * 1、修改user保存基础额度信息
     * 2、创建授信 调用http://192.168.0.208:81/rest/1.2/api.php/credits
     *
     * @param dto
     * @return
     */
    public RestfulResult basicLimit(BasicLimitDTO dto, NewMerchantUserModel newMerchantUserModel, HttpSession session) {

        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);

        /** step1.修改个人的基础资料 */
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> parameter = objectMapper.convertValue(dto, Map.class); // 对象转MAP
        RestfulResult result = this.updateMerchantUser(newMerchantUserModel.getObjectId(), parameter, session);

        if (result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS)) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            ObjectMapper mapper = new ObjectMapper();
            String creditId = "";
            try {
                /**判断是否授信*/
                if(applicationModel!=null && (applicationModel.getCreditId()==null || applicationModel.getCreditId().equals(""))){
                    /** step2.调用接口创建授信 */
                    String errorMsg = "";
                    String url = wsCrmRestfulMerchantUrl + "/credits";
                    parameter = new HashMap();
                    parameter.put("applicationId", newMerchantUserModel.getApplicationId());
                    String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
                    tempStr = responseBody;
                    if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                        Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                        });
                        creditId = map.get("objectId")+"";//授信成功之后，获取授信id
                        applicationModel.setCreditId(creditId);
                    } else {
                        Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                        });
                        result.setResultMsg(map.get("error"));
                    }
                }
                /**
                 * 获取授信额度
                 */

                String getCreditUrl = wsCrmRestfulMerchantUrl + "/credits/"+applicationModel.getCreditId();
                Map<String,String> pmap = new HashMap<String, String>();
                pmap.put("credits",applicationModel.getCreditId());
                String responseBody = HttpUtils.executeCrmHttpRequest(getCreditUrl, pmap, HttpGet.METHOD_NAME, null);
                if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                    //重新更新SESSION中的用户信息，重新获取isComputingAmount字段
                    session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, this.getMerchantUserById(newMerchantUserModel.getObjectId()));
                    Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                    });
                    if(map!=null && map.get("creditStatus")!=null && !map.get("creditStatus").equals("")){
                        //获取授信成功
                        result.setResultCode("1");
                        result.setResultMsg("额度核算成功!");
                        session.setAttribute("callCredits",new Date());
                    }
                    if(map!=null && map.get("totalCreditLine")!=null && !map.get("totalCreditLine").equals("")){
                        session.setAttribute("totalCreditLine",map.get("totalCreditLine"));
                    }
                }
            } catch (Exception e) {
                logger.info("授信出错:" + e);
                String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
            }
        }else{
            result.setResultCode("-100");
        }
        return result;
    }

    /**
     * 查询所有申请记录通过商户用户id
     *
     * @param merchantId
     * @return
     */
    public List queryApplications(String merchantId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);
        callMethodParams.put("X-CRM-Access-Token", request.getSession().getAttribute("accessToken"));
        List<ApplicationModel> applicationModel = new ArrayList<ApplicationModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/applications";
            Map parameter = new HashMap();
            parameter.put("where", "{\"merchantId\":\"" + merchantId + "\",\"isEnabled\":1}");//
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    applicationModel = (List<ApplicationModel>) map.get("results");
                }
            } else {
               /* String errorMsg = "调用crm接口:获取商户对应的用户失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return applicationModel;
    }


    /**
     * 创建申请
     * 1.若当前申请未激活，则自动激活申请，将申请的创建时间更新为当前时间，并将线索的状态改为12（额度已核算）
     * 2.若当前申请已激活，则自动创建一条新线索，状态为76（收到授权书，待核算额度），处理机构为330（未选择处理机构），
     * 线索来源为66（手机申请），线上客户经理为15712（指定的线上客户经理ID），法人手机号码为merchants.mobilePhone，
     * 并进行续签关联（renewAppId为当前申请表中的app_id），将app表中的信息更新到leads表中，并在CRM编辑线索页面可显示；同时创建一条新申请。
     *
     * @param merchantId
     * @param session
     * @return
     */
    public RestfulResult createApplication(String merchantId, HttpSession session) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);//定义返回
        Map parameter = new HashMap();//构建参数
        parameter.put("merchantId", merchantId);
        try {
            String url = wsCrmRestfulMerchantUrl + "/applications";
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));//修改使用put方式
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //更新SESSION中的用户申请
                session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, this.getMerchantUserById(merchantId));
                //返回成功
                result.setResultCode("1");
                result.setResultMsg("成功!");
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
               /* String errorMsg = "调用crm接口:创建申请!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_BIND, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }


    /**
     * 查询确认书待确认显示字段信息
     *
     * @param applicationId
     * @return
     */
    public List queryConfirmlists(String applicationId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("applicationId", applicationId);
        List<ConfirmlistModel> confirmlistModels = new ArrayList<ConfirmlistModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/applications/" + applicationId + "/confirmlists";
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功,处理业务逻辑
                confirmlistModels = new ObjectMapper().readValue(responseBody, new TypeReference<List<ConfirmlistModel>>() {
                });
            } else {
              /*  String errorMsg = "调用crm接口:查询确认书待确认显示字段信息失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return confirmlistModels;
    }

    /**
     * 查询文件列表或者补件列表
     *
     * @param merchantId 用户id
     * @param isPending  是否补件列表
     * @return
     */
    public List queryUploadFileMain(String merchantId, boolean isPending) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);
        callMethodParams.put("isPending", isPending);

        List<UploadFileMainModel> uploadFileMainModels = new ArrayList<UploadFileMainModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantId + "/checklists";
            Map parameter = new HashMap();
            if (isPending == false)
                parameter.put("where", "{\"aggregation\":\"layerSecond\"}");//正常清单列表
            else
                parameter.put("where", "{\"aggregation\":\"layerSecond\",\"status\":\"Pending\"}");//补件
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    uploadFileMainModels = (List<UploadFileMainModel>) map.get("results");

                }
            } else {
               /* String errorMsg = "调用crm接口:查询文件列表或者补件列表失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return uploadFileMainModels;
    }

    /**
     * 查询优惠券
     * @param merchantId
     * @param type 类型：1 现金券 0优惠券
     * @param status 状态： 1 已经使用 0 未使用
     * @return
     */
    @Override
    public List queryCoupons(String merchantId, String type, String status) {

        List<HashMap<String,String>> coupons = new ArrayList<HashMap<String, String>>();
        //调用接口
        String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantId + "/coupons";
        Map parameter = new HashMap();
        parameter.put("where", "{\"type\":\""+type+"\",\"status\":\""+status+"\"}");//补件
        try {
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                ObjectMapper mapper = new ObjectMapper();
                //返回成功,处理业务逻辑
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                coupons = mapper.readValue(responseBody, ArrayList.class) ;
            }
        } catch (Exception e) {
            logger.info("查询优惠券信息失败:" + e);
        }
        return coupons;
    }

    @Override
    public Map financingPlan(String applicationId, String type) {
        List<HashMap<String,String>> res = new ArrayList<HashMap<String, String>>();
        Map parameter = new HashMap();
        Map<String,String> resMap = new HashMap<String,String>();
        parameter.put("where", "{\"type\":\""+type+"\"}");//补件
        //调用接口
        String url = wsCrmRestfulMerchantUrl + "/applications/" + applicationId + "/confirmlists";
        try {
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                ObjectMapper mapper = new ObjectMapper();
                //返回成功,处理业务逻辑
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                res = mapper.readValue(responseBody, ArrayList.class) ;
                if(res!=null && res.size()>0){
                    resMap = res.get(0);
                }
            }
        } catch (Exception e) {
            logger.info("查询确认清单 : 1：申请信息，2：融资方案，3：融资保理通知书 出错:"+e);
            e.printStackTrace();
        }
        return resMap;
    }

    /**
     * 查询父分组下所有子分组
     *
     * @param merchantId
     * @param groupName
     * @return
     */
    public List queryUploadFileChildModel(String merchantId, String groupName) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);
        callMethodParams.put("groupName", groupName);
        List<UploadFileChildModel> uploadFileChildModels = new ArrayList<UploadFileChildModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantId + "/filelists";
            Map parameter = new HashMap();
            parameter.put("where", "{\"layerSecond\":\"" + groupName + "\"}");//补件
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    uploadFileChildModels = (List<UploadFileChildModel>) map.get("results");
                }
            } else {
               /* String errorMsg = "调用crm接口:查询父分组下所有子分组失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return uploadFileChildModels;
    }

    /**
     * 查询父分组下所有子分组
     *
     * @param merchantId
     * @param groupName
     * @return
     */
    public List queryUploadFileChildModel2(String merchantId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);
//        callMethodParams.put("groupName", groupName);
        List<UploadFileChildModel> uploadFileChildModels = new ArrayList<UploadFileChildModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantId + "/newfilelists";
            Map parameter = new HashMap();
//            parameter.put("where", "{\"layerSecond\":\"" + groupName + "\"}");//补件
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    uploadFileChildModels = (List<UploadFileChildModel>) map.get("results");
                }
            } else {
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
//        uploadFileChildModels.get(1).setLackFiles("2");
        return uploadFileChildModels;
    }
    //查询小类
    public List queryUploadFileChildModel3(String merchantId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);
        callMethodParams.put("where", "{\"checklistId\":\"39\"}");
        List<UploadFileChildModel> uploadFileChild = new ArrayList<UploadFileChildModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantId + "/filelists";
            Map parameter = new HashMap();
            parameter.put("merchantId", merchantId);
            parameter.put("where", "{\"checklistId\":\"39\"}");
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    uploadFileChild = (List<UploadFileChildModel>) map.get("results");
                }
            } else {
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return uploadFileChild;
    }


    //查询小类
    public List queryUploadFileChildModel4(String merchantId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);
        callMethodParams.put("where", "{\"checklistId\":\"42\"}");
        List<UploadFileChildModel> uploadFileChild = new ArrayList<UploadFileChildModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantId + "/filelists";
            Map parameter = new HashMap();
            parameter.put("merchantId", merchantId);
            parameter.put("where", "{\"checklistId\":\"42\"}");
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    uploadFileChild = (List<UploadFileChildModel>) map.get("results");
                }
            } else {
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return uploadFileChild;
    }

    /**
     * 修改用户信息
     *
     * @param merchantUserId
     * @param parameter
     * @return
     */
    public RestfulResult updateMerchantUser(String merchantUserId, Map parameter, HttpSession session) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantUserId);
        callMethodParams.put("parameter", parameter);
        //定义返回
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String errorMsg = "";
            parameter.put("ipAddress",Utility.getRemoteIp(request));
            parameter.put("blackBox",session.getAttribute("blackBox"));
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantUserId;
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, Constants.HTTP_METHOD_PUT, mapper.writeValueAsString(parameter));//修改使用put方式
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //重新更新SESSION中的用户申请
                session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, this.getMerchantUserById(merchantUserId));
                //返回成功
                result.setResultCode("1");
                result.setResultMsg("修改成功!");
            } else {
                //打印错误信息到前台
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                String errorCode = map.get("code");
                if (errorCode.equals("201")) {
                    result.setResultMsg("微信公众平台openid未绑定");
                } else if (errorCode.equals("202")) {
                    result.setResultMsg("找不到手机号码对应的用户");
                } else if (errorCode.equals("211")) {
                    result.setResultMsg("创建授信失败,请稍后重试!");
                } else {
                    result.setResultMsg(map.get("error"));
                }
                errorMsg = "调用修改用户信息 失败!"; //返回错误信息接口
            }
           /* if (StringUtils.isNotBlank(errorMsg)) {
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }*/
        } catch (Exception e) {
            logger.info("调用修改用户信息 失败!" + e);

            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 修改用户的经度维度
     *
     * @param openId
     * @param parameter
     * @return
     */
    public RestfulResult updateMerchantUserlatitudeAndLongitude(String openId, Map parameter) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("openId", openId);
        callMethodParams.put("parameter", parameter);
        //定义返回
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String errorMsg = "";
            String url = wsCrmRestfulMerchantUrl + "/wechatUsers/" + openId + "/lonlat";
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));//修改使用put方式
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功
                result.setResultCode("1");
                result.setResultMsg("修改成功!");
            } else {
                //打印错误信息到前台
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                errorMsg = "调用修改用户的经度维度 失败!"; //返回错误信息接口
            }
            /*if (StringUtils.isNotBlank(errorMsg)) {
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }*/
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 修改申请信息
     *
     * @param applicationId
     * @param parameter
     * @return
     */
    public RestfulResult updateApplication(String applicationId, Map parameter) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        //修改申请信息时添加童盾标示
        parameter.put("ipAddress",Utility.getRemoteIp(request));
        parameter.put("blackBox",request.getSession().getAttribute("blackBox"));

        callMethodParams.put("applicationId", applicationId);
        callMethodParams.put("parameter", parameter);
        //定义返回
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String errorMsg = "";
            String url = wsCrmRestfulMerchantUrl + "/applications/" + applicationId;
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, Constants.HTTP_METHOD_PUT, mapper.writeValueAsString(parameter));//修改使用put方式
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                result.setResultCode("1");//成功
                result.setResultMsg("修改成功!");
            } else {
                //打印错误信息到前台
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                errorMsg = "调用crm接口修改申请信息 失败!"; //返回错误信息接口
            }
          /*  if (StringUtils.isNotBlank(errorMsg)) {
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }*/
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 获取店铺|申请APP下的所有保理记录
     *
     * @param appId
     * @return
     */
    public List getCashdvancesAppById(String appId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("appId", appId);
        List<CashadvancesModel> shopModels = new ArrayList<CashadvancesModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/cashadvances";
            Map parameter = new HashMap();
            parameter.put("where", "{\"appId\":" + appId + "}");
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    shopModels = (List<CashadvancesModel>) map.get("results");
                }
            } else {
               /* String errorMsg = "调用crm接口:获取店铺|申请APP下的所有保理记录失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return shopModels;
    }


    /**
     * 提交补件申请
     *
     * @param baoliId
     * @return
     */
    public RestfulResult addFile(String baoliId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("baoliId", baoliId);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String url = wsCrmRestfulMerchantUrl + "/apps";
            Map parameter = new HashMap();
            parameter.put("status", "已补件");
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                result.setResultCode("1"); //返回成功标志
                result.setResultMsg("提交成功!");
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
              /*  String errorMsg = "调用crm接口提交补件申请失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_ADD_FILE, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 基础额度中查询所有省份
     *
     * @return
     */
    public List queryProvinces() {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        List<ProvinceModel> list = new ArrayList<ProvinceModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/provincelist";
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                list = new ObjectMapper().readValue(responseBody, new TypeReference<List<ProvinceModel>>() {
                });
            } else {
               /* //记录错误信息到数据库
                String errorMsg = "调用crm接口:基础额度中查询所有省份失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return list;
    }

    /**
     * 基础额度中根据省份查询所有市
     *
     * @return
     */
    public List queryCitys(String provinceId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("provinceId", provinceId);
        List<CityModel> list = new ArrayList<CityModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/proid/" + provinceId;
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                list = new ObjectMapper().readValue(responseBody, new TypeReference<List<CityModel>>() {
                });
            } else {
                String errorMsg = "调用crm接口:基础额度中根据省份查询所有市失败!";
              /*  utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));

        }
        return list;
    }

    /**
     * 基础额度中查询所有一级行业
     *
     * @return
     */
    public List queryIndustrys() {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        List<IndustryModel> list = new ArrayList<IndustryModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/industrylists";
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                list = new ObjectMapper().readValue(responseBody, new TypeReference<List<IndustryModel>>() {
                });
            } else {
                String errorMsg = "调用crm接口:基础额度中查询所有一级行业失败!";
              /*  utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return list;
    }

    /**
     * 基础额度中根据一及行业id查询所有对应子行业
     *
     * @param industryId 大类id
     * @param merchantId 当前申请id
     * @return
     */
    public List queryIndustryDetails(String industryId, String merchantId) {

        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("industryId", industryId);
        List<IndustryDetailModel> list = new ArrayList<IndustryDetailModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/industrylists";
            Map parameter = new HashMap();
            parameter.put("where", "{\"industryGId\":\"" + industryId + "\"}");
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                list = new ObjectMapper().readValue(responseBody, new TypeReference<List<IndustryDetailModel>>() {
                });
            } else {
                String errorMsg = "调用crm接口:基础额度中根据以及行业id查询所有对应子行业失败!";
               /* utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return list;
    }


    public List queryIndustryPidDetails(String industryId, String merchantId) {

        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("industryId", industryId);
        List<IndustryDetailModel> list = new ArrayList<IndustryDetailModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/industrylists";
            Map parameter = new HashMap();
            parameter.put("where", "{\"industryPId\":\"" + industryId + "\",\"merchantId\":\"" + merchantId + "\"}");
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                list = new ObjectMapper().readValue(responseBody, new TypeReference<List<IndustryDetailModel>>() {
                });
            } else {
                String errorMsg = "调用crm接口:基础额度中根据以及行业id查询所有对应子行业失败!";
               /* utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return list;
    }


    /**
     * 获取授信情况是否正在计算（获取授信系统正在执行的授信任务）
     *
     * @return
     */
    public RestfulResult getCredits(String creditId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("creditId", creditId);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        try {
            //调用接口获取授信记录
            if (StringUtils.isBlank(creditId)) return result;
            String url = wsCrmRestfulMerchantUrl + "/credits/" + creditId;
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            logger.info("responseBody:" + responseBody);
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                CreditsTaskModel creditsTaskModel = new ObjectMapper().readValue(responseBody, new TypeReference<CreditsTaskModel>() {
                });
                result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
                result.setResultMsg("成功");
                result.setResultData(creditsTaskModel);
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口:获取授信失败!";
               /* utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            HttpSession session = Utility.session();
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 获取POS额度中的POS商编
     *
     * @param creditId 授信id
     * @return
     */
    public List queryPosCreditsMids(String creditId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("creditId", creditId);
        List<PosMidModel> list = new ArrayList<PosMidModel>();
        try {
            if (StringUtils.isBlank(creditId)) return list;
            String url = wsCrmRestfulMerchantUrl + "/credits/" + creditId + "/mids";
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            tempStr = responseBody;
            logger.info("获取POS额度中的POS商编 responseBody:" + responseBody);
            if (responseBody.indexOf("error") == -1 && responseBody.length() > 0) {
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, List<PosMidModel>>>() {
                });
                if (map.get("results") != null && !(map.get("results") + "").equals("")) {
                    list = (List<PosMidModel>) map.get("results");
                }
            } else {
               /*  String errorMsg = "调用crm接口:获取POS额度中的POS商编失败!";
                     utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));*/
            }
        } catch (Exception e) {
            HttpSession session = Utility.session();
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败  ! X-CRM-Access-Token:" + session.getAttribute("accessToken");
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return list;
    }

    /**
     * 查询POS额度中的POS商编验证失败的记录
     *
     * @param list
     * @return
     */
    public PosMidModel queryCheckFailMid(List<PosMidModel> list) {
        PosMidModel returnObj = null;
        for (PosMidModel posMidModel : list) {
            if (posMidModel.getStatus().equals("F")) {
                returnObj = posMidModel;
                break;
            }
        }
        return returnObj;
    }

    /**
     * 查询POS额度中的POS商编还有待生成验证问题的记录或者正在授信的记录
     *
     * @param list
     * @return
     */
    public PosMidModel queryProcessingMid(List<PosMidModel> list) {
        PosMidModel returnObj = null;
        for (PosMidModel posMidModel : list) {
            if (posMidModel.getStatus().equals("C")) {
                returnObj = posMidModel;
                break;
            }  //else if (posMidModel.getStatus().equals("Q")) {
//                returnObj = posMidModel;
//                break;
//            }
        }
        return returnObj;
    }

    /**
     * 查询POS额度中的POS商编还有待生成验证问题的记录
     *
     * @param list
     * @return
     */
    public PosMidModel queryMakingQuestionsMid(List<PosMidModel> list) {
        PosMidModel returnObj = null;
        for (PosMidModel posMidModel : list) {
            if (posMidModel.getStatus().equals("Q")) {
                returnObj = posMidModel;
                break;
            }
        }
        return returnObj;
    }

    /**
     * 提交聚信令
     *
     * @param dto
     * @param newMerchantUserModel
     * @param session
     * @return
     */
    public RestfulResult juxinliLimit(JuxinliLimitDTO dto, NewMerchantUserModel newMerchantUserModel, HttpSession session) {
        logger.info("come in method : " + this.getClass().getName() + Thread.currentThread().getStackTrace()[1].getMethodName());

        //记录日志 - 记录当前请求参数
        final Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        callMethodParams.put("mobile", newMerchantUserModel.getMobilePhone());
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        final ObjectMapper mapper = new ObjectMapper();
        try {
            //调用CRM保存数据

            Map parameterTemp = new HashMap();
            parameterTemp.put("ownerSSN", dto.getOwnerSSN());
            parameterTemp.put("ownerName", dto.getOwnerName());
            this.updateMerchantUser(newMerchantUserModel.getObjectId(), parameterTemp, session);

            if (StringUtils.isBlank(dto.getCheckCode())) {
                /**表示是第一次进入界面没有验证码提交**/
                //调用聚信令第一个接口
                String url = getWsJxlUrl + "/applications/"+newMerchantUserModel.getApplicationId()+"/jxlVerify";
                Map parameter = new HashMap();
                parameter.put("ownerName", dto.getOwnerName());//真实姓名
                parameter.put("ownerSSN", dto.getOwnerSSN());//身份证
                parameter.put("mobilePhone", newMerchantUserModel.getMobilePhone());//手机号码
                parameter.put("password", dto.getServicePassword());//服务密码
               /* parameter.put("ownerName", "陈国家");//真实姓名
                parameter.put("ownerSSN", "341623198906266405");//身份证
                parameter.put("mobilePhone", "15021311857");//手机号码
                parameter.put("password", "892731");//服务密码*/

                String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));//修改使用put方式
                tempStr = responseBody;
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map!=null && map.get("processCode")!=null && (map.get("processCode").equals("10002") || map.get("processCode").equals("10008") || Integer.parseInt(map.get("processCode")+"")==10002) || Integer.parseInt(map.get("processCode")+"")==10008) {

                    if (map.get("processCode").equals("10002") || Integer.parseInt(map.get("processCode")+"")==10002) {
                        //表示需要输入验证码，还是返回成功标示
                        result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
                        result.setResultMsg("手机运行商需要输入验证码!");
                        result.setResultData(map);//返回手机验证标示
                    } else if (map.get("processCode").equals("10008") || Integer.parseInt(map.get("processCode")+"")==10008) {
                        //表示不需要验证码直接采集数据成功,此时开始调用CRM接口保存数据
                        parameter = new HashMap();
                        parameter.put("ownerSSN", dto.getOwnerSSN());
                        parameter.put("ownerName", dto.getOwnerName());
                        parameter.put("isJxlValid", "1");//聚信令状态
                        result = this.updateMerchantUser(newMerchantUserModel.getObjectId(), parameter, session);
                    } else {
                        //表示失败，打印失败信息
                        result.setResultMsg(map.get("content") == null ? "" : map.get("content").toString());
                        result.setResultData(map);//保存返回结果集
                    }
                } else {
                    //表示失败，打印失败信息
                    result.setResultMsg(map.get("content") == null ? "" : map.get("content").toString());
                    result.setResultData(map);//保存返回结果集
                }
            } else {
                /**表示第二次输入了验证码以后提交**/
                String url = wsJxlUrl + "/submit";
                Map parameter = new HashMap();
                parameter.put("mobilePhone", newMerchantUserModel.getMobilePhone());//手机号
                parameter.put("password", dto.getServicePassword());//手机服务密码
//                parameter.put("mobilePhone", "15021310857");//手机号
//                parameter.put("password", "892631");//手机服务密码
                parameter.put("token", dto.getToken());//第一个接口返回的值
                parameter.put("captcha", dto.getCheckCode());//运营商发给手机的验证码
                parameter.put("website", dto.getWebsite());//手机类型：联通，移动，电信，第一个接口返回的
                final Map tempParameter = parameter;
                final String applicationId = newMerchantUserModel.getApplicationId();
                //开启新线程去采集
                new Thread() {
                    @Override
                    public void run() {
                        String tempResponseBody = "";
                        try {
                            String myUrl = getWsJxlUrl + "/applications/"+applicationId+"/jxlSubmit";
                            final String responseBody = HttpUtils.executeCrmHttpRequest(myUrl, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(tempParameter));//修改使用put方式
                            tempResponseBody = responseBody;
                            Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.info("juxinliLimit error:" + e);
//                            String errorMsg = "调用聚信令接口:提交手机号、手机密码、验证码 到聚信立系统，进行数据整合失败!";
                            String errorMsg = "调用聚信令接口:验证码输入有误！";
                            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, tempResponseBody + Utility.getExceptionInfo(e))));
                        }
                    }
                }.start();
                //调用CRM保存数据
                parameter = new HashMap();
                parameter.put("ownerSSN", dto.getOwnerSSN());
                parameter.put("ownerName", dto.getOwnerName());
                parameter.put("isJxlValid", "1");//聚信令状态
                result = this.updateMerchantUser(newMerchantUserModel.getObjectId(), parameter, session);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /*public RestfulResult juxinliLimit(JuxinliLimitDTO dto, NewMerchantUserModel newMerchantUserModel, HttpSession session) {
        logger.info("come in method : " + this.getClass().getName() + Thread.currentThread().getStackTrace()[1].getMethodName());

        //记录日志 - 记录当前请求参数
        final Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        callMethodParams.put("mobile", newMerchantUserModel.getMobilePhone());
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        final ObjectMapper mapper = new ObjectMapper();
        try {
            //调用CRM保存数据

            Map parameterTemp = new HashMap();
            parameterTemp.put("ownerSSN", dto.getOwnerSSN());
            parameterTemp.put("ownerName", dto.getOwnerName());
            this.updateMerchantUser(newMerchantUserModel.getObjectId(), parameterTemp, session);

            if (StringUtils.isBlank(dto.getCheckCode())) {
                *//**表示是第一次进入界面没有验证码提交**//*
                //调用聚信令第一个接口
                String url = wsJxlUrl + "/getverifycode";
                Map parameter = new HashMap();
                parameter.put("name", dto.getOwnerName());//真实姓名
                parameter.put("id_card_num", dto.getOwnerSSN());//身份证
                parameter.put("account", newMerchantUserModel.getMobilePhone());//手机号码
                parameter.put("password", dto.getServicePassword());//服务密码
                String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));//修改使用put方式
                tempStr = responseBody;
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                Boolean flag = Boolean.parseBoolean(map.get("success").toString());//处理结果
                Map data = (Map) map.get("data");//返回数据结果
                if (flag) {
                    if (data.get("process_code").equals("10002")) {
                        //表示需要输入验证码，还是返回成功标示
                        result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
                        result.setResultMsg("手机运行商需要输入验证码!");
                        result.setResultData(data);//返回手机验证标示
                    } else if (data.get("process_code").equals("10008")) {
                        //表示不需要验证码直接采集数据成功,此时开始调用CRM接口保存数据
                        parameter = new HashMap();
                        parameter.put("ownerSSN", dto.getOwnerSSN());
                        parameter.put("ownerName", dto.getOwnerName());
                        parameter.put("isJxlValid", "1");//聚信令状态
                        result = this.updateMerchantUser(newMerchantUserModel.getObjectId(), parameter, session);
                    } else {
                        //表示失败，打印失败信息
                        result.setResultMsg(data.get("content") == null ? "" : data.get("content").toString());
                        result.setResultData(data);//保存返回结果集
                    }
                } else {
                    //表示失败，打印失败信息
                    result.setResultMsg(data.get("content") == null ? "" : data.get("content").toString());
                    result.setResultData(data);//保存返回结果集
                }
            } else {
                *//**表示第二次输入了验证码以后提交**//*
                String url = wsJxlUrl + "/submit";
                Map parameter = new HashMap();
                parameter.put("account", newMerchantUserModel.getMobilePhone());//手机号
                parameter.put("password", dto.getServicePassword());//手机服务密码
                parameter.put("token", dto.getToken());//第一个接口返回的值
                parameter.put("captcha", dto.getCheckCode());//运营商发给手机的验证码
                parameter.put("website", dto.getWebsite());//手机类型：联通，移动，电信，第一个接口返回的
                final Map tempParameter = parameter;
                //开启新线程去采集
                new Thread() {
                    @Override
                    public void run() {
                        String tempResponseBody = "";
                        try {
                            String myUrl = wsJxlUrl + "/submit";
                            final String responseBody = HttpUtils.executeCrmHttpRequest(myUrl, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(tempParameter));//修改使用put方式
                            tempResponseBody = responseBody;
                            Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.info("juxinliLimit error:" + e);
//                            String errorMsg = "调用聚信令接口:提交手机号、手机密码、验证码 到聚信立系统，进行数据整合失败!";
                            String errorMsg = "调用聚信令接口:验证码输入有误！";
                            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, tempResponseBody + Utility.getExceptionInfo(e))));
                        }
                    }
                }.start();
                //调用CRM保存数据
                parameter = new HashMap();
                parameter.put("ownerSSN", dto.getOwnerSSN());
                parameter.put("ownerName", dto.getOwnerName());
                parameter.put("isJxlValid", "1");//聚信令状态
                result = this.updateMerchantUser(newMerchantUserModel.getObjectId(), parameter, session);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }*/


    /**
     * 征信授权
     *
     * @param newMerchantUserModel
     * @param session
     * @return
     */
    @Override
    public Map crediAauthoriza(NewMerchantUserModel newMerchantUserModel, HttpSession session) {

        String url = wsCrmRestfulMerchantUrl + "/verifyCode";
        Map<String, String> map = new HashMap<String, String>();
        map.put("where", "{\"type\":\"1\"}");
        String response = "";
        Map<String, Object> mapRes = null;
        try {
            response = HttpUtils.executeCrmHttpRequest(url, map, HttpGet.METHOD_NAME, null);
            mapRes = new ObjectMapper().readValue(response, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            logger.info("征信授权：" + e);
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + response;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), map, errorMsg, Utility.getExceptionInfo(e))));
        }
        session.setAttribute("imageUrl", map.get("imgUrl"));
        session.setAttribute("sessionId", map.get("sessionId"));
        return mapRes;
    }

    /**
     * 提交邮箱验证
     *
     * @param dto
     * @param newMerchantUserModel
     * @param session
     * @return
     */
    public RestfulResult emailLimit(EmailLimitDTO dto, NewMerchantUserModel newMerchantUserModel, HttpSession session) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);//定义返回
        try {
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + newMerchantUserModel.getObjectId() + "/verifyEmail";
            ObjectMapper mapper = new ObjectMapper();
            Map parameter = new HashMap();
            parameter.put("ownerEmail", dto.getOwnerEmail());
            if (StringUtils.isNotBlank(dto.getEmailVerifyCode()))
                parameter.put("emailVerifyCode", dto.getEmailVerifyCode());
            logger.info("============emailVerifyCode:==================" + dto.getEmailVerifyCode());
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功结果集
                result.setResultCode("1");
                //刷新session中的用户
                if (StringUtils.isNotBlank(dto.getEmailVerifyCode())) {
                    newMerchantUserModel = this.getMerchantUserById(newMerchantUserModel.getObjectId());
                    if (newMerchantUserModel != null)
                        session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel); //保存绑定或者登录成功的用户信息
                }
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }

    /**
     * 保存反馈意见
     *
     * @param feedbackTO
     * @param session
     * @return
     */
    public RestfulResult saveFeedbackComments(FeedbackTO feedbackTO, HttpSession session) {

        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("feedbackTO", feedbackTO);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);//定义返回
        try {
            String url = wsCrmRestfulMerchantUrl + "/feedback";
            ObjectMapper mapper = new ObjectMapper();

            Map parameter = new HashMap();
            Map imgMap = new HashMap();
            List list = new ArrayList();
            for (int i = 0; i < feedbackTO.getDataList().size(); i++) {
                imgMap.put("data", feedbackTO.getDataList().get(i));
                String name = feedbackTO.getNameList().get(i);
                imgMap.put("type", name.substring(name.lastIndexOf("."), name.length()));
                list.add(imgMap);
            }

            parameter.put("img", list);
            parameter.put("content", feedbackTO.getContent());
            parameter.put("connection", feedbackTO.getConnection());
            String testStr = mapper.writeValueAsString(parameter);
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
            tempStr = responseBody;
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //返回成功结果集
                result.setResultCode("1");
                result.setResultMsg("非常感谢您提出宝贵的意见，系统已经保存了您的反馈信息！");
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + tempStr;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    @Override
    public Map creditReport(CreditReportModel reportModel, String applicationId, HttpSession session) {
        Map map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        String url = wsCrmRestfulMerchantUrl + "/applications/" + applicationId + "/creditReport";
        String response = "";
        Map mapRes = null;
        if(reportModel==null || reportModel.getUserName()==null || reportModel.getPassWord()==null){
            url = wsCrmRestfulMerchantUrl + "/applications/" + applicationId ;

            map.put("creditReportStatus","1");
            try {
                response = HttpUtils.executeCrmHttpRequest(url, null, HttpPut.METHOD_NAME, mapper.writeValueAsString(map));
                mapRes = new ObjectMapper().readValue(response, new TypeReference<Map<String, Object>>() {
                });
            } catch (Exception e) {
                String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + response;
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), map, errorMsg, Utility.getExceptionInfo(e))));
            }
        }else{

            map.put("username", reportModel.getUserName());
            map.put("password", reportModel.getPassWord());
            map.put("verityCode", reportModel.getVerityCode());
            map.put("tradeCode", reportModel.getTradeCode());
            map.put("sessionId", reportModel.getSessionId());
            try {
                response = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(map));
                mapRes = new ObjectMapper().readValue(response, new TypeReference<Map<String, Object>>() {
                });
            } catch (Exception e) {
                String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + response;
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), map, errorMsg, Utility.getExceptionInfo(e))));

            }
        }
        return mapRes;
    }

    @Override
    public RestfulResult validateQuestionAnswer(String selectedAmt, String credits, String midVerification,HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        HashMap map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        map.put("selectedAmt", selectedAmt);
        String url = wsCrmRestfulMerchantUrl + "/credits/" + credits + "/midVerification/" + midVerification;
        Map mapRes = null;
        String response = null;
        try {
            response = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(map));
            mapRes = new ObjectMapper().readValue(response, new TypeReference<Map<String, Object>>() {
            });
            //verifyResult 0:验证失败，1:验证成功
            result.setResultCode(mapRes.get("verifyResult") + "");
            Integer time = Integer.parseInt(mapRes.get("leftVerifyTimes") + "");
            result.setResultMsg(mapRes.get("resMsg") + "");
            if (time == 0) {
                String msg = "对不起！您三次验证均不通过，该商编额度暂不能激活。请提供如下材料之一作为辅证，激活您的商编额度：\n" +
                        "1、POS机装机单\n" +
                        "2、收单机构提供的对账系统截屏（需包含商户注册名称、商户编号和装机地址信息）!";
                result.setResultMsg(msg);
                result.setResultCode("2");//表示3次验证均没有通过
            }
            result.setResultData(mapRes.get("resMsg"));

            if(mapRes!=null && mapRes.get("resCode")!=null){
                //resCode 为"0000"表示验证成功。
                String resCode = mapRes.get("resCode")+"";
                if(resCode!=null && resCode.equals("0000")){
                    //验证成功之后，刷新用户信息
                    NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel)request.getSession().getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
                    if(newMerchantUserModel!=null && newMerchantUserModel.getObjectId()!=null){
                        newMerchantUserModel = this.getMerchantUserById(newMerchantUserModel.getObjectId());
                        if (newMerchantUserModel != null)
                            session.removeAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
                            session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel); //保存绑定或者登录成功的用户信息
                    }

                    if(newMerchantUserModel!=null && newMerchantUserModel.getApplicationId()!=null){
                        ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
                        if(applicationModel!=null && applicationModel.getCreditId() !=null && !applicationModel.getCreditId().equals("")) {
                            RestfulResult resultCredit = newMerchantService.getCredits(applicationModel.getCreditId());
                        }
                    }

                }
            }


        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 ! responseBody:" + response;
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), map, errorMsg, Utility.getExceptionInfo(e))));

        }
        return result;
    }

    @Override
    public Map addMerchant(HttpSession session) {

        String url = wsCrmRestfulMerchantUrl + "/merchants";
        String responseBody = "";
        Map res = new HashMap();
        try {
            ObjectMapper mapper = new ObjectMapper();
            responseBody =  HttpUtils.executeCrmHttpRequest(url,null,HttpPost.METHOD_NAME,"");
            if(responseBody!=null && responseBody.length()>0){
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                res = mapper.readValue(responseBody, HashMap.class); //将json解析成HashMap
                if(res.get("error")!=null){
                    logger.info("create merchat with error 创建商户时出错:" + res.get("error"));
                    if(res.get("error").equals("")){
                        res.put("message", "添加商铺失败！");
                    }else{
                        res.put("message", res.get("error"));
                    }
                    res.put("code","-1");
                    return res;
                }else{
                    res.put("message","创建商户成功");
                    res.put("code","1");
                    //重新更新SESSION中的用户申请
                    if(res!=null && res.get("objectId")!=null){
                        session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, this.getMerchantUserById(res.get("objectId")+""));
                    }
                    //更新token值
                    session.setAttribute("accessToken", res.get("accessToken"));//保存token
                }

            }
        } catch (Exception e) {
            res.put("message","create merchant with error \n\r 创建新商户时,CRM返回信息无法解析");
            logger.info("create merchant with error  创建新商户时,服务器出错1:"+e);
        }
        return res;
    }

    @Override
    public List<Map> queryMuliteMerchant(HttpSession session) {

        String url = wsCrmRestfulMerchantUrl + "/merchants/shops";
        List<Map> resMap = new ArrayList<Map>();
        try {
            String responseBody = HttpUtils.executeCrmHttpRequest(url,null,HttpGet.METHOD_NAME,"");
            logger.info("query mulite merchant ..."+responseBody);
            if(responseBody!=null && responseBody.length()>0){
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                resMap = mapper.readValue(responseBody, List.class); //将json解析成HashMap
            }
        } catch (Exception e) {
            logger.info("query mulite merchant error ..."+e);
        }
        return resMap;
    }

    @Override
    public Map invitedRecord(String merchantId) {

        String url = wsCrmRestfulMerchantUrl + "/merchants/"+merchantId+"/inviteHistory";
        Map map = new HashMap();
        try {
            String responseBody = HttpUtils.executeCrmHttpRequest(url,null,HttpGet.METHOD_NAME,"");
            logger.info("query invitedRecord ..."+responseBody);
            if(responseBody!=null && responseBody.length()>0){
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                map = mapper.readValue(responseBody, Map.class); //将json解析成HashMap
            }
        } catch (Exception e) {
            logger.info("query mulite merchant error ..."+e);
        }
        return map;
    }

    @Override
    public void isFirstTimeLogin(HttpSession session) {

        System.out.println("...................isFirstTimeLogin..................................");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) request.getSession().getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);

        LoginModel loginModel = new LoginModel();
        if(newMerchantUserModel!=null && newMerchantUserModel.getMobilePhone()!=null){
            loginModel = loginModelRepository.findLoginModelByMobile(newMerchantUserModel.getMobilePhone());
        }
        if(loginModel==null){
            loginModel = new LoginModel();

            if(newMerchantUserModel!=null && newMerchantUserModel.getMobilePhone()!=null){
                loginModel.setMobile( newMerchantUserModel.getMobilePhone());
            }
            loginModel.setPassword("");
            loginModel.setLoginCount("1");
            loginModel.setLastLoginTime(new Date());
            loginModelRepository.save(loginModel);
            if(loginModel!=null && loginModel.getLoginCount()!=null){
                request.getSession().setAttribute("firstTime", loginModel.getLoginCount());
            }
        }else{
            if(newMerchantUserModel!=null && newMerchantUserModel.getMobilePhone()!=null){
                loginModel.setMobile(newMerchantUserModel.getMobilePhone());
            }
            loginModel.setPassword("");
            if(loginModel!=null && loginModel.getLoginCount()!=null){
                loginModel.setLoginCount((Integer.parseInt(loginModel.getLoginCount())+1)+"");
            }
            loginModel.setLastLoginTime(new Date());
            loginModelRepository.save(loginModel);
            if(loginModel!=null && loginModel.getLoginCount()!=null){
                request.getSession().setAttribute("firstTime", loginModel.getLoginCount());
            }

        }
    }


}
