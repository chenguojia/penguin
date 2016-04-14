package com.cardvalue.penguin.web;

import com.cardvalue.penguin.model.ApplicationModel;
import com.cardvalue.penguin.model.NewMerchantUserModel;
import com.cardvalue.penguin.model.Parameter;
import com.cardvalue.penguin.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-22 16:28.
 *
 * @Description:
 */
@Controller
@RequestMapping(value = "/regular")
public class RegularController {


    /**
     * 银行卡绑定协议
     * 0
     * @param isApp
     * @return
     */
    @RequestMapping(value = "/bindBankCard")
    public ModelAndView bindBankCardRegular(@RequestParam(defaultValue = "0") String isApp){
        ModelAndView mv = new ModelAndView("/regular/bindCardRegular");
        mv.addObject("isApp",isApp);
        return mv;
    }
    @RequestMapping(value = "/bindBankCard/session")
    @ResponseBody
    public void bankBinding(HttpSession session,ApplicationModel applicationModel){
       session.setAttribute("sessionApplication",applicationModel);
    }

    /**
     * 银行卡绑定协议
     * 0
     * @param isApp
     * @return
     */
    @RequestMapping(value = "/creditRegular")
    public ModelAndView creditRegular(@RequestParam(defaultValue = "0") String isApp){
        ModelAndView mv = new ModelAndView("/regular/creditRegular");
        mv.addObject("isApp",isApp);
        return mv;
    }


    /**
     * 卡得万利服务协议
     * @return
     */
    @RequestMapping(value = "/showAgreement", method = RequestMethod.GET)
    public ModelAndView showAgreement(){
        ModelAndView mv = new ModelAndView("/regular/agreement");
        return mv;
    }

}
