package com.cardvalue.penguin.web;

/**
 * Created by guojia.chen on 2016-02-03 9:51.
 *
 * @Description:
 */

import com.cardvalue.penguin.repository.ActionLogRepository;
import com.cardvalue.penguin.repository.SalesRepository;
import com.cardvalue.penguin.repository.UserRepository;
import com.cardvalue.penguin.service.WeChatService;
import com.cardvalue.penguin.util.Utility;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/public")
public class PublicController {


    @Resource
    private WeChatService weChatService;

    @Value("${wechat.app.name}")
    private String appName;

    @Value("${wechat.appid}")
    private String appId;

    @Value("${ws.local.ip}")
    private String wsLocalIp;

    private static final Logger logger = LoggerFactory.getLogger(PublicController.class);

    @RequestMapping(value = "/criteria", method = RequestMethod.GET)
    public String criteria() {
        return "/public/merchant-search";
    }

    @RequestMapping(value = "/showMessage", method = RequestMethod.GET)
    public ModelAndView showMessage(@RequestParam String message) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("message");
        mv.addObject("message", message);
        return mv;
    }

    @RequestMapping(value = "/showPicture", method = RequestMethod.GET)
    public ModelAndView showPicture(@RequestParam String pictureName) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("public/show-picture");
        mv.addObject("pictureName", pictureName);
        return mv;
    }

    @RequestMapping(value = "/public/page/{pageName}", method = RequestMethod.GET)
    public String showPage(@PathVariable("pageName") String pageName) {
        return "/public/page/" + pageName;
    }

    /**
     * 下载APP
     * @param session
     * @return
     */
    @RequestMapping(value = "/downloadApp", method = RequestMethod.GET)
    public ModelAndView downloadApp(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/public/download");
        return mv;
    }

    /**
     * 分享邀请码
     *
     * @param username    用户名
     * @param trueName    真实汉字姓名
     * @return
     */
    @RequestMapping(value = "/inviteCode", method = RequestMethod.GET)
    public ModelAndView inviteCode(String username,String trueName){
        trueName = StringUtils.isNotBlank(trueName) ? Utility.transcoding(trueName) : "";
        ModelAndView mv = new ModelAndView("/public/inviteCode");
        mv.addObject("username",username);
        mv.addObject("trueName", trueName);
        try {
//			String domain = wsLocalIp.equals("192.168.0.209") ? "220.248.19.21" : "www.cvbaoli.com";
            String domain = "www.cvbaoli.com";
            //开启微信js-jdk
            String noncestr = "cardvalue";
            long timestamp =  new Date().getTime() / 1000;
            String url = "http://"+ domain +"/" + this.appName + "/public/inviteCode?username=" + username + "&trueName=" + URLEncoder.encode(trueName, "UTF-8");
            String str = "jsapi_ticket="+ weChatService.getTicket() +"&noncestr="+ noncestr +"&timestamp="+ timestamp +"&url="+ url;
            String signature = DigestUtils.sha1Hex(str);//加密

            //返回前台
            mv.addObject("appId",appId);
            mv.addObject("noncestr",noncestr);
            mv.addObject("timestamp",timestamp);
            mv.addObject("url",url);
            mv.addObject("signature",signature);
            logger.info(String.format("appid is %s\n  noncestr is %s\n  timestamp is %s\n  url is %s\n  tempSignature is %s\n  str1 is %s\n",appId,noncestr,timestamp,url,signature,str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return mv;
    }


    /**
     * 分享邀请码
     *
     * @param username    用户名
     * @param trueName    真实汉字姓名
     * @return
     */
    @RequestMapping(value = "/inviteCode2", method = RequestMethod.GET)
    public ModelAndView inviteCode2(String username,String trueName){
        trueName = StringUtils.isNotBlank(trueName) ? Utility.transcoding(trueName) : "";
        ModelAndView mv = new ModelAndView("public/inviteCode2");
        mv.addObject("username",username);
        mv.addObject("trueName",trueName);

        try {
//			String domain = wsLocalIp.equals("192.168.0.209") ? "220.248.19.21" : "www.cvbaoli.com";
            String domain = "www.cvbaoli.com";
            //开启微信js-jdk
            String noncestr = "cardvalue";
            long timestamp =  new Date().getTime() / 1000;
            String url = "http://"+ domain +"/" + this.appName + "/public/inviteCode2?username=" + username + "&trueName=" + URLEncoder.encode(trueName, "UTF-8");
            String str = "jsapi_ticket="+ weChatService.getTicket() +"&noncestr="+ noncestr +"&timestamp="+ timestamp +"&url="+ url;
            String signature = DigestUtils.sha1Hex(str);//加密

            //返回前台
            mv.addObject("appId",appId);
            mv.addObject("noncestr",noncestr);
            mv.addObject("timestamp",timestamp);
            mv.addObject("url",url);
            mv.addObject("signature",signature);
            logger.info(String.format("appid is %s\n  noncestr is %s\n  timestamp is %s\n  url is %s\n  tempSignature is %s\n  str1 is %s\n",appId,noncestr,timestamp,url,signature,str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 分享邀请码
     * @param username
     * @return
     */
    @RequestMapping(value = "/inviteCodeRule", method = RequestMethod.GET)
    public ModelAndView inviteCodeRule(String username){
        ModelAndView mv = new ModelAndView("/public/inviteCodeRule");
        return mv;
    }


    /**
     * 征信报告
     * @param session
     * @param appId 1表示app，2表示微信
     * @return
     */
    @RequestMapping(value = "/getCreditReport", method = RequestMethod.GET)
    public ModelAndView getCreditReport(HttpSession session,@RequestParam(defaultValue = "1") String appId){
        ModelAndView mv = new ModelAndView("/public/getCreditReport");
        mv.addObject("appId", appId);
        return mv;
    }

    /**
     * 卡得万利服务协议
     * @return
     */
    @RequestMapping(value = "/showAgreement", method = RequestMethod.GET)
    public ModelAndView showAgreement(){
        ModelAndView mv = new ModelAndView("/public/agreement");
        return mv;
    }

}
