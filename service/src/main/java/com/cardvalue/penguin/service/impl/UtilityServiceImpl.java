package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.service.UtilityService;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by guojia.chen on 2015-12-29 16:53.
 *
 * @Description:
 */
@Service
public class UtilityServiceImpl implements UtilityService {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UtilityServiceImpl.class);

    @Resource
    private JavaMailSender mailSender;

    @Value("${mail.from.email}")
    private String mailSenderEmail;

    @Value("${mail.from.personal}")
    private String mailSenderPersonal;

    @Value("${mail.to.maintainer}")
    private String mailToMaintainer;

    @Value("${ws.local.ip}")
    private String wsLocalIp;

    DateFormat df = new SimpleDateFormat("yyMMdd");

    /**
     * 外部调用微信接口出错通知邮件
     *
     * @param businessObj 需要在邮件中现实详情的对象
     */
    public void sendMailForException(Object businessObj) {
        if (businessObj != null) {
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setFrom(mailSenderEmail, mailSenderPersonal);
                helper.setTo(StringUtils.split(mailToMaintainer, ","));
                String envirName = "测试环境";
                if (wsLocalIp.equals("192.168.0.209")) envirName = "正式环境";
                String subject = "[" + envirName + "] 外部调用微信接口出错通知邮件(" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ")";
                String text = "错误详情为：" + new ObjectMapper().writeValueAsString(businessObj);
                logger.info(subject + "\n" + text);//打印日志
                helper.setSubject(subject);
                helper.setText(text);
                if (wsLocalIp.equals("192.168.0.209")) mailSender.send(message);//测试环境先不发邮件
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("发送错误通知邮件出错 : ", e);
            }
        }
    }
}
