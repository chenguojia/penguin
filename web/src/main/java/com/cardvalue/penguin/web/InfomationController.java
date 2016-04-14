package com.cardvalue.penguin.web;

import com.cardvalue.penguin.model.ApplicationModel;
import com.cardvalue.penguin.model.CreditsTaskModel;
import com.cardvalue.penguin.model.NewMerchantUserModel;
import com.cardvalue.penguin.service.InfomationService;
import com.cardvalue.penguin.service.NewMerchantService;
import com.cardvalue.penguin.service.WeChatService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.RestfulResult;
import com.cardvalue.penguin.util.Utility;
import org.apache.commons.codec.digest.DigestUtils;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-20 15:48.
 *
 * @Description:
 */
@Controller
@RequestMapping(value = "/info")
public class InfomationController {

    private static final Logger logger = LoggerFactory.getLogger(InfomationController.class);
    @Resource
    private NewMerchantService newMerchantService;

    @Value("${wechat.app.name}")
    private String appName;

    @Value("${wechat.appid}")
    private String appId;

    @Resource
    private WeChatService weChatService;

    @Resource
    private InfomationService infomationService;

    @RequestMapping(value = "/queryInfomation")
    public ModelAndView queryInfo(@RequestParam(required = false)String type){
        //type : 0 用户消息，1 系统消息
        ModelAndView mv = new ModelAndView("/newm/info/queryInfo");
        Map map = infomationService.queryInfo(type, "0", "100");
        mv.addObject("infoMap",map);
        mv.addObject("type",type);
        return mv;
    }

    @RequestMapping(value = "/queryInfoDetail")
    public ModelAndView queryInfoDetail(String infoId,String type){
        //type : 0 用户消息，1 系统消息
        ModelAndView mv = new ModelAndView("/newm/info/infoDetail");
        Map map = infomationService.queryInfoDetail(infoId, type);
        mv.addObject("infoDetail",map);
        mv.addObject("type", type);
        return mv;
    }


    @RequestMapping(value = "/deleteInfo")
    @ResponseBody
    public Map deleteInfo(String infoId,String type){
        //type : 0 用户消息，1 系统消息
        String  code = infomationService.deleteInfo(infoId,type);
        Map map = new HashMap();
        map.put("code",code);
        return  map;//code : 1 删除成功， 0 删除失败
    }


    //银行卡绑定

    @RequestMapping(value = "/bankBinding",method = RequestMethod.POST)
    @ResponseBody
    public Map bankBinding(HttpServletRequest request,ApplicationModel applicationModel){
        Map map = new HashMap();
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) request.getSession().getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if(newMerchantUserModel!=null){
            request.getSession().setAttribute("mobilePhone",newMerchantUserModel.getMobilePhone());
            ApplicationModel applModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            applicationModel.setObjectId(applModel.getObjectId());
            map = infomationService.bindBank(request,applicationModel);
        }
        return  map;//code : 1 删除成功， 0 删除失败
    }

    @RequestMapping(value = "/dimension")
    public ModelAndView dimension(HttpSession session){
        ModelAndView mv = new ModelAndView("/newm/dimension");
        return  mv;//code : 1 删除成功， 0 删除失败
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
     * 查询授信
     * @param session
     * @return
     */
    @RequestMapping(value = "/getCredit",method = RequestMethod.POST)
    @ResponseBody
    public Map getCredit(HttpSession session){
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        ApplicationModel applicationModel = null;
        Map<String,Object>map = new HashMap<String, Object>();

        if(newMerchantUserModel!=null && newMerchantUserModel.getApplicationId()!=null){
            applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
        }
        //获取授信情况
        if(applicationModel!=null && applicationModel.getCreditId() !=null && !applicationModel.getCreditId().equals("")){
            RestfulResult result = newMerchantService.getCredits(applicationModel.getCreditId());

            if(result!=null){

                CreditsTaskModel creditsTaskModel = (CreditsTaskModel)result.getResultData();
                map.put("creditsTaskModel",creditsTaskModel);

                if((creditsTaskModel!=null && creditsTaskModel.getCreditStatus()!=null) && (creditsTaskModel.getCreditStatus().equals("N") || creditsTaskModel.getCreditStatus().equals("E"))){
                    //重新更新SESSION中的用户信息，重新获取isComputingAmount字段
                    session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantService.getMerchantUserById(newMerchantUserModel.getObjectId()));
                }
                if(creditsTaskModel!=null && creditsTaskModel.getInvalidDate()!=null){
                    map.put("invalidDate", creditsTaskModel.getInvalidDate());//参考融资期限
                }

                if(creditsTaskModel!=null && creditsTaskModel.getPaymentMethodId()!=null){
                    map.put("paymentMethodId", creditsTaskModel.getPaymentMethodId());//参考融资期限
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
                        difDay = Utility.getDateDiff(sdf.parse(creditsTaskModel.getInvalidDate() + " 00:00:00"), new Date(), "d");
                    } catch (ParseException e) {
                        logger.info("date parse failed :" + e);
                    }
                    map.put("difDay",difDay+"");
                    logger.info(result.getResultData()+"");
                }
            }
        }
        return map;
    }

    /**
     * 推荐专区
     */

    @RequestMapping(value = "/inviteRecord",method = RequestMethod.GET)
    public ModelAndView invitedRecord(HttpSession session){
        ModelAndView mv = new ModelAndView("/newm/invitedRecord");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        Map map = (Map)session.getAttribute("inviteHistory");
        if(map!=null && (map.get("amount")==null || map.get("amount").equals(""))){
            map.put("amount","0");
        }
        mv.addObject("map",map);
        mv.addObject("username",newMerchantUserModel.getMobilePhone());
        if(newMerchantUserModel.getProposerName()==null || newMerchantUserModel.getProposerName().equals("")){
            mv.addObject("trueName",newMerchantUserModel.getOwnerName());
        }else{
            mv.addObject("trueName",newMerchantUserModel.getProposerName());
        }

       return mv;
    }
}
