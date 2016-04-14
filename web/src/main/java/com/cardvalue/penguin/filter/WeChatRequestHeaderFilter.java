package com.cardvalue.penguin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by guojia.chen on 2015-12-30 16:55.
 *
 * @Description:
 */
public class WeChatRequestHeaderFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(WeChatRequestHeaderFilter.class);

    FilterConfig filterConfig = null;

    final static String PARAM_NAME_ENABLED = "ENABLED";
    final static String PARAM_NAME_ALLOWED_AGENT = "ALLOWED_AGENT";

//    @Override
    public void destroy() {}

//    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String enabledStr = filterConfig.getInitParameter(PARAM_NAME_ENABLED);
        boolean enabled = Boolean.parseBoolean(enabledStr);
        logger.trace("WeChatRequestHeaderFilter Eabled:" + enabled);
        if(enabled){
            String allowedAgent = filterConfig.getInitParameter(PARAM_NAME_ALLOWED_AGENT);
            logger.trace("WeChatRequestHeaderFilter AllowedAgent:" + allowedAgent);
            String userAgent = ((HttpServletRequest)request).getHeader("USER-AGENT");
            logger.trace("Request Agent:" + userAgent);
            if(!StringUtils.contains(userAgent, allowedAgent)){
                logger.info("User agent doesn't allowed");
//                response.setCharacterEncoding("utf-8");
                response.setContentType("plain/txt");
                response.getWriter().write("本系统只允许使用在微信内使用");
                return;
            }
        }
        chain.doFilter(request, response);
    }

//    @Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

}
