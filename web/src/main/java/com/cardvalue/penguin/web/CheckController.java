package com.cardvalue.penguin.web;

import com.cardvalue.penguin.model.NewMerchantUserModel;
import com.cardvalue.penguin.service.CheckService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.RestfulResult;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-12 11:53.
 *
 * @Description:
 *  该controller主要完成各种校验功能，将校验功能抽取出来
 */
@Controller
@RequestMapping(value = "/check")
public class CheckController {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CheckController.class);


    @Resource
    private CheckService checkService;
    /**
     * 校验手机是否已经授权
     * @return
     */
    @RequestMapping(value = "/mobile/authorization", method = RequestMethod.POST)
    @ResponseBody
    public String checkMobile(String mobile,HttpServletRequest request){
        String res = checkService.checkMobileAuth(mobile);
        return res;
    }


    /**
     * 根据注册编号获取法人信息
     * @param bizResigterNo
     * @return
     */
    @RequestMapping(value = "/checkbizRegisterNo", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult checkbizRegisterNo(String bizResigterNo,String industryCId){
        return  checkService.checkbizRegisterNo(bizResigterNo,industryCId);
    }


    @RequestMapping(value = "/queryBanks", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult queryBakns(String type,String bankName){
        RestfulResult result  = checkService.queryBakns(type,bankName);
        return result;
    }


    /**
     * 提现确认
     */
    @RequestMapping(value = "/getMoneyConfrim", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult getMoneyConfrim(HttpSession session){
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        RestfulResult result = new RestfulResult();
        if(newMerchantUserModel!=null){
            result  = checkService.getMoneyConfrim(newMerchantUserModel,session);
        }
        return result;
    }
}
