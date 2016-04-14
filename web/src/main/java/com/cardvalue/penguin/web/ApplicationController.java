package com.cardvalue.penguin.web;

import com.cardvalue.penguin.model.NewMerchantUserModel;
import com.cardvalue.penguin.service.ApplicationService;
import com.cardvalue.penguin.service.NewMerchantService;
import com.cardvalue.penguin.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-25 18:55.
 *
 * @Description:
 */
@Controller
@RequestMapping("/application")
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
    @Resource
    private ApplicationService applicationService;

    @Resource
    private NewMerchantService newMerchantService;

    @RequestMapping(value = "/confirm",method = RequestMethod.POST)
    @ResponseBody
    public Map confirm(HttpSession session,String sure){
        Map<String,String> map = new HashMap<String, String>();
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if(newMerchantUserModel!=null && newMerchantUserModel.getApplicationId()!=null){
            map = applicationService.confirm(newMerchantUserModel.getApplicationId(),sure);
        }else{
            logger.info("提交确认时newMerchantUserModel为null或newMerchantUserModel.getApplicationId()为null：newMerchantUserModel = "+newMerchantUserModel );
        }
        return map;
    }
}
