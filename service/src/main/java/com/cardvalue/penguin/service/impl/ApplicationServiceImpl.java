package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.service.ApplicationService;
import com.cardvalue.penguin.util.HttpUtils;
import com.cardvalue.penguin.util.Utility;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-25 19:00.
 *
 * @Description:
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Value("${ws.crm.restful.merchant.url}")
    private String merchantFromCrmUrl;

    @Resource
    private HttpServletRequest request;


    @Override
    public Map confirm(String applicationId,String sure) {

        Map<String,String> map = new HashMap<String,String>();
        Map<String,String> resMap = new HashMap<String,String>();
        //1 表示确认提交；0 表示返回修改，将isSubmitApplication的状态改成0
        if(sure!=null && sure.equals("1")){
            map.put("type","5");
            map.put("ipAddress", Utility.getRemoteIp(request));
            map.put("blackBox",request.getSession().getAttribute("blackBox")+"");
        }else if(sure!=null && sure.equals("0")){
            map.put("isSubmitApplication","0");
        }

        String url = merchantFromCrmUrl + "/applications/"+applicationId;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPut.METHOD_NAME, mapper.writeValueAsString(map));
            if(responseBody!=null && !responseBody.equals("")){
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                resMap =  mapper.readValue(responseBody, Map.class);
                if(resMap!=null && resMap.get("error")!=null){
                    resMap.put("code","-1");
                    resMap.put("message",resMap.get("error"));
                }else{
                    resMap.put("code","1");
                }
            }
        } catch (Exception e) {
            logger.info("application confirm ....确认提交出错:" + e);
        }
        return resMap;
    }
}
