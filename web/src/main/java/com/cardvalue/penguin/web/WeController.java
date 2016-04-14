package com.cardvalue.penguin.web;


import com.cardvalue.penguin.dto.MessageVerificationDTO;
import com.cardvalue.penguin.dto.WeButton;
import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.dto.WeMenu;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.UserRepository;
import com.cardvalue.penguin.service.WeChatService;
import com.cardvalue.penguin.util.UUIDGenerator;
import com.cardvalue.penguin.util.XMLConverter;
import com.cardvalue.penguin.web.message.MessageHandler;
import com.cardvalue.penguin.web.message.MessageHandlers;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping({"/we"})
public class WeController {
    private static final Logger logger = LoggerFactory.getLogger(WeController.class);
    @Value("${wechat.verification.token}")
    private String token;
    @Value("${wechat.appid}")
    private String weAppId;
    @Value("${wechat.base.url}")
    private String baseURL;
    @Value("${wechat.app.name}")
    private String appName;
    @Resource
    private MessageHandlers messageHandlers;
    @Resource
    private XMLConverter xmlConverter;
    @Resource
    private WeChatService weChatService;
    @Resource
    private UserRepository userRepo;

    @ResponseBody
    @RequestMapping(value = {"/io"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String verify(MessageVerificationDTO dto) {
        logger.info("start verification : {}", dto);
        boolean flag = false;

        String[] strs = {dto.getTimestamp(), dto.getNonce(), this.token};
        Arrays.sort(strs);

        String tempSignature = DigestUtils.sha1Hex(StringUtils.join(strs, null));
        logger.info("calculated signature : {}", tempSignature);

        flag = StringUtils.equals(tempSignature, dto.getSignature());
        logger.info("verify flag : {}", Boolean.valueOf(flag));
        if (flag) {
            return dto.getEchostr();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = {"/io"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String io(@RequestBody String xml) {
        String response = null;
        logger.info("receiving message : {}", xml);
        try {
            WeChatMessage message = (WeChatMessage) this.xmlConverter.convertFromXMLToObject(xml);
            MessageHandler handler = this.messageHandlers.getMessageHandler(message);
            response = handler.handle(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    //卡得萬利
    @RequestMapping(value = {"/menu/create"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public void createMenu() {
        String appURL = this.baseURL + this.appName;
        WeMenu menu = new WeMenu();

//        WeButton button1 = new WeButton();
////        button1.setName("融资入口");
////        button1.setType("view");
////        button1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fhome%2Fenter%3FredirectUrl%3D&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
//
////        button1.setName("融资入口");
////        button1.setType("view");
////        button1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fnew%2Fm%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
//
//        button1.setName("融资");
//
//        WeButton button1_1 = new WeButton();
//        button1_1.setName("我要融资");
//        button1_1.setType("view");
//        button1_1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fnew%2Fm%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
//        button1.getSubButtons().add(button1_1);
//
//        WeButton button1_2 = new WeButton();
//        button1_2.setName("线索提报");
//        button1_2.setType("view");
//        button1_2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fhome%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
//        button1.getSubButtons().add(button1_2);
        WeButton button1 = new WeButton();
        button1.setName("线索提报");
        button1.setType("view");
        button1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fhome%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);

        WeButton button2 = new WeButton();
        button2.setName("最新活动");
        button2.setType("view");
        //https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http://www.cvbaoli.com/this.appName(此处变量)/home/enter/redirectUrl/public/newestCampaign?response_type=code&scope=snsapi_base&appid= this.weAppId
         button2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fhome%2Fenter%3FredirectUrl%3D%2Fpublic%2FnewestCampaign&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
        //button2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fpublic%2FnewestCampaign&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
        //button2.setType("click");
        //button2.setKey("new_activities");
        //button2.setUrl("http://220.248.19.21/" + this.appName + "/resources/html/advertisement.html");

        WeButton button3 = new WeButton();
        button3.setName("服务");
        WeButton button3_1 = new WeButton();
        button3_1.setName("商业保理");
        button3_1.setType("view");
        button3_1.setUrl(appURL + "/merchant/page/factoring-introduce");
        button3.getSubButtons().add(button3_1);

        WeButton button3_2 = new WeButton();
        button3_2.setName("常见问题");
        button3_2.setType("view");
        button3_2.setUrl(appURL + "/merchant/page/question");
        button3.getSubButtons().add(button3_2);

        WeButton button3_3 = new WeButton();
        button3_3.setName("案例分享");
        button3_3.setType("click");
        button3_3.setKey("newmerchant");
        button3.getSubButtons().add(button3_3);

//        WeButton button3_3 = new WeButton();
//        button3_3.setName("案例分享");
//        button3_3.setType("view");
//        button3_3.setUrl(appURL + "/merchant/page/cases");
//        button3.getSubButtons().add(button3_3);

        WeButton button3_4 = new WeButton();
        button3_4.setName("关于我们");
        button3_4.setType("view");
        button3_4.setUrl(appURL + "/merchant/page/about-us");
        button3.getSubButtons().add(button3_4);

//        //后面加上
//        WeButton button3_5 = new WeButton();
//        button3_5.setName("客经入口");
//        button3_5.setType("view");
//        button3_5.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fhome%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
//        button3.getSubButtons().add(button3_5);

        menu.getButtons().add(button1);
        menu.getButtons().add(button2);
        menu.getButtons().add(button3);

        this.weChatService.createMenu(menu);
    /*String appURL = this.baseURL + this.appName;
    WeMenu menu = new WeMenu();
    WeButton button1 = new WeButton();
    button1.setName("商户");
    WeButton button1_1 = new WeButton();
    button1_1.setName("计算额度");
    button1_1.setType("view");
    button1_1.setUrl(appURL + "/merchant/calculator");
    button1.getSubButtons().add(button1_1);
    WeButton button1_2 = new WeButton();
    button1_2.setName("融资申请");
    button1_2.setType("view");
    button1_2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fhome%2Fenter%3FredirectUrl%3D%2Fm%2FnewApply&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
    

    button1.getSubButtons().add(button1_2);
    
    WeButton button2 = new WeButton();
    button2.setName("积分活动");
    button2.setType("view");
    button2.setUrl("http://220.248.19.21/" + this.appName + "/resources/html/advertisement.html");
    
    WeButton button3 = new WeButton();
    button3.setName("服务");
    WeButton button3_1 = new WeButton();
    button3_1.setName("商业保理");
    button3_1.setType("view");
    button3_1.setUrl(appURL + "/merchant/page/factoring-introduce");
    button3.getSubButtons().add(button3_1);
    
    WeButton button3_2 = new WeButton();
    button3_2.setName("常见问题");
    button3_2.setType("view");
    button3_2.setUrl(appURL + "/merchant/page/question");
    button3.getSubButtons().add(button3_2);
    
    WeButton button3_3 = new WeButton();
    button3_3.setName("案例分享");
    button3_3.setType("view");
    button3_3.setUrl(appURL + "/merchant/page/cases");
    button3.getSubButtons().add(button3_3);
    
    WeButton button3_4 = new WeButton();
    button3_4.setName("关于我们");
    button3_4.setType("view");
    button3_4.setUrl(appURL + "/merchant/page/about-us");
    button3.getSubButtons().add(button3_4);
    
    WeButton button3_5 = new WeButton();
    button3_5.setName("用户入口");
    button3_5.setType("view");
    button3_5.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fhome%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
    

    button3.getSubButtons().add(button3_5);
    
    menu.getButtons().add(button1);
    menu.getButtons().add(button2);
    menu.getButtons().add(button3);
    
    this.weChatService.createMenu(menu);*/
    }

    @RequestMapping(value = {"/kadou/menu/create"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public void createMenuForKadou() {
        String appURL = this.baseURL + this.appName;
        WeMenu menu = new WeMenu();
       WeButton button1 = new WeButton();

        button1.setName("融资");

        WeButton button1_1 = new WeButton();
        button1_1.setName("我要融资");
        button1_1.setType("view");
//        button1_1.setUrl(appURL + "/new/m/enter?code="+ UUIDGenerator.getUUID());
        button1_1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fnew%2Fm%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
//        button1_1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2F220.248.19.21%2F" + this.appName + "%2Fnew%2Fm%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
        button1.getSubButtons().add(button1_1);

        WeButton button1_2 = new WeButton();
        button1_2.setName("线索提报");
        button1_2.setType("view");
        button1_2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fhome%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
        button1.getSubButtons().add(button1_2);



       /* WeButton button1 = new WeButton();
        button1.setName("线索提报");
        button1.setType("view");
        button1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fhome%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
*/

       WeButton button2 = new WeButton();
    /* button2.setName("最新活动");
        button2.setType("view");
        button2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fhome%2Fenter%3FredirectUrl%3D%2Fpublic%2FnewestCampaign&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
*/

        button2.setName("下载APP");
        button2.setType("view");
        button2.setUrl(appURL + "/public/downloadApp");



        WeButton button3 = new WeButton();
        button3.setName("帮助");
        WeButton button3_1 = new WeButton();
//        button3_1.setName("商业保理");
        button3_1.setName("产品介绍");
        button3_1.setType("view");
//        button3_1.setUrl(appURL + "/merchant/page/factoring-introduce");
        button3_1.setUrl(appURL + "/merchant/page/introduce");
        button3.getSubButtons().add(button3_1);

        WeButton button3_2 = new WeButton();
        button3_2.setName("常见问题");
        button3_2.setType("view");
        button3_2.setUrl(appURL + "/merchant/page/question");
        button3.getSubButtons().add(button3_2);

        WeButton button3_3 = new WeButton();
        button3_3.setName("联系我们");
        button3_3.setType("view");
        button3_3.setUrl(appURL + "/merchant/page/contact-us");
//        button3_3.setName("案例分享");
//        button3_3.setType("click");
//        button3_3.setKey("newmerchant");
        button3.getSubButtons().add(button3_3);

        WeButton button3_5 = new WeButton();
        button3_5.setName("卡得万利");
        button3_5.setType("view");
//        button3_5.setUrl(appURL + "/merchant/page/company-introduction2");//
        button3_5.setUrl(appURL + "/new/m/enter?code="+ UUIDGenerator.getUUID());
        button3.getSubButtons().add(button3_5);
//        button3_4.setName("关于我们");
//        button3_4.setUrl(appURL + "/merchant/page/about-us");

        menu.getButtons().add(button1);
        menu.getButtons().add(button2);
        menu.getButtons().add(button3);

        this.weChatService.createMenu(menu);

    }

    @RequestMapping(value = {"/penguin/menu/create"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public void createMenuForPenguin() {
        String appURL = this.baseURL + this.appName;
        WeMenu menu = new WeMenu();
        WeButton button1 = new WeButton();

        button1.setName("融资入口");
        button1.setType("view");
//        button1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2Fwww.cvbaoli.com%2F" + this.appName + "%2Fnew%2Fm%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
        button1.setUrl(appURL + "/public/downloadApp");

        WeButton button2 = new WeButton();
        button2.setName("下载APP");
        button2.setType("view");
//        button2.setUrl(appURL + "/public/downloadApp");
        button2.setUrl("http://a.app.qq.com/o/simple.jsp?pkgname=com.cardvlaue.sys&g_f=991653");

        WeButton button3 = new WeButton();
        button3.setName("帮助");
        WeButton button3_1 = new WeButton();
        button3_1.setName("产品介绍");
        button3_1.setType("view");
        button3_1.setUrl(appURL + "/merchant/page/introduce");
        button3.getSubButtons().add(button3_1);

        WeButton button3_2 = new WeButton();
        button3_2.setName("常见问题");
        button3_2.setType("view");
        button3_2.setUrl(appURL + "/merchant/page/question2");
        button3.getSubButtons().add(button3_2);

        WeButton button3_4 = new WeButton();
        button3_4.setName("联系我们");
        button3_4.setType("view");
        button3_4.setUrl(appURL + "/merchant/page/contact-us");
        button3.getSubButtons().add(button3_4);

        WeButton button3_3 = new WeButton();
        button3_3.setName("卡得万利");
        button3_3.setType("view");
        button3_3.setUrl(appURL + "/merchant/page/company-introduction2");
//        button3_3.setKey("newmerchant");
        button3.getSubButtons().add(button3_3);

        menu.getButtons().add(button1);
        menu.getButtons().add(button2);
        menu.getButtons().add(button3);

        this.weChatService.createMenu(menu);
    }

    @RequestMapping(value = {"/user/{userId}"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public String sendCustomMessage(@PathVariable int userId, @RequestBody String message) {
        WeUser user = (WeUser) this.userRepo.findOne(Integer.valueOf(userId));
        if ((user != null) && (StringUtils.isNotEmpty(user.getOpenId()))) {
            this.weChatService.pushMessage(user.getOpenId(), message);
            return "successful";
        }
        return "failed";
    }
}
