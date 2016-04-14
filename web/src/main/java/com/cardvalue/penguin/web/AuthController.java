package com.cardvalue.penguin.web;

/**
 * Created by guojia.chen on 2015-12-30 16:14.
 *
 * @Description:
 */

import com.cardvalue.penguin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Resource
    private UserService userService;

    /**
     * Simply selects the home view to render by returning its name.
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public ModelAndView login(String message) throws UnsupportedEncodingException {
        //logger.info("Show login page...");
        //return "auth/login";

        if(message!=null && !message.equals("") && message.equals("xiaoqie")){
            message = "请下载<小企额>进行登录";
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("auth/login");
        if(message != null && !message.equals(""))
            mv.addObject("message", message);
        else
            mv.addObject("message", null);
        return mv;
    }

    /**
     * Simply selects the home view to render by returning its name.
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/auth/m-login", method = RequestMethod.GET)
    public ModelAndView mLogin(String message) throws UnsupportedEncodingException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("auth/m-login");
        if(message != null && !message.equals(""))
            mv.addObject("message", message);
        else
            mv.addObject("message", null);
        return mv;
    }


    /**
     * 新用户入口
     * @return
     */
    @RequestMapping(value = "/auth/newUserEntry", method = RequestMethod.GET)
    public ModelAndView newUserEntry(String code) {
        logger.info("Show update new user entry");
        ModelAndView mv = new ModelAndView();
        mv.addObject("code", code);
        mv.setViewName("auth/new-user-entry");
        return mv;
    }

}

