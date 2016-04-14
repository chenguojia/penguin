package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.model.ActionLog;
import com.cardvalue.penguin.repository.ActionLogRepository;
import com.cardvalue.penguin.service.SmsService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.RequestPipe;
import com.cardvalue.penguin.util.SessionList;
import com.jianzhou.sdk.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by guojia.chen on 2016-01-06 10:20.
 *
 * @Description:
 */
@Service
public class SmsServiceImpl implements SmsService {

    private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
    private final static SessionList list = new SessionList();

    @Resource
    private BusinessService smsBusinessService;

    @Resource
    private ActionLogRepository actionLogRepository;

    @Value("${sms.enabled}")
    private boolean smsEnabled;

    @Resource
    private HttpServletRequest request;

    @Value("${sms.account}")
    private String smsAccount;

    @Value("${sms.password}")
    private String smsPassword;

    @Value("${sms.signature}")
    private String smsSignature;

    @Value("${ws.local.ip}")
    private String wsLocalIp;

    @Override
    public int sendSms(String mobile, String message) {
        int flag = 0;
        RequestPipe rt = new RequestPipe(getIp(request), "code");
        if (list.find(rt)) {
            if (list.getRequestPipe(rt).update(rt) == RequestPipe.RET_FAILED) {
                logger.info("failed...........................................");
                return -100;
            }
            // throw new IOException("访问过高");
        } else {
            String Ip = getIp(request);
            list.add(getIp(request), "code");
            logger.info("success...........................................");

            if (smsEnabled) {
                String messageTxt = message + smsSignature;
                //if (message.indexOf("您好，您的验证码为") != -1)  messageTxt = message + "【卡得万利 - 小企额】";
                if (wsLocalIp.equals("192.168.0.209")) {//正式环境发送信息
//                    flag = smsBusinessService.sendMessage(smsAccount, smsPassword, mobile, messageTxt);
                    flag = 100;//表示测试环境
                } else {
                    flag = 100;//表示测试环境
                }
                //logger.info("Send SMS [" + messageTxt + "] to mobile:" + mobile + ", return flag:" + flag);
                //记录发送短信日志ACTION_LOG，发送手机号、发送信息内容、发送时间、短息发送状态
                ActionLog actionLog = new ActionLog();
                actionLog.setCreateDate(new Date());
                actionLog.setAction(Constants.MOBILE_SEND);//发送短信
                actionLog.setMemo("手机号码:" + mobile + ";短信发送内容:" + message + ";发送状态" + flag + ",ip:" + Ip);
                actionLog.setIp(Ip);
                actionLog.setMobile(mobile);
                actionLogRepository.save(actionLog);
            }
        }

        return flag;
    }


    /**
     * 获取ip的方法
     *
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

}

