package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.model.ApplicationModel;
import com.cardvalue.penguin.service.InfomationService;
import com.cardvalue.penguin.service.NewMerchantService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.HttpUtils;
import com.cardvalue.penguin.util.Utility;
import org.apache.http.client.methods.HttpDelete;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-20 16:28.
 *
 * @Description:
 */
@Service
public class InfomationServiceImpl implements InfomationService{


    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(InfomationServiceImpl.class);

    @Value("${ws.crm.restful.merchant.url}")
    private String merchantFromCrmUrl;

    @Resource
    private NewMerchantService newMerchantService;

    @Override
    public Map queryInfo(String type, String skip, String limit) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap = new HashMap<String, String>();
        if(skip==null || skip.equals("")){
            skip = "0";
        }
        if(limit==null || limit.equals("")){
            limit = "100";
        }
        paramMap.put("skip", skip);
        paramMap.put("limit", limit);
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<Map<String, String>> resList = new ArrayList<Map<String, String>>();
        Map map = new HashMap();
        try {
            if(type==null || type.equals("")){
                for(int i= 0;i<=1;i++){
                    type = i+"";
                    paramMap.put("where", "{\"type\":\""+type+"\"}");
                    String url = merchantFromCrmUrl + "/messages";
                    String responseBody = HttpUtils.executeCrmHttpRequest(url, paramMap, HttpGet.METHOD_NAME, null);
                    if(responseBody!=null && !responseBody.equals("")){
                        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                        list = responseBody.equals("{}") ? null : (List<Map<String, String>>) mapper.readValue(responseBody, List.class);
                        if(type.equals("1")){
                            map.put("infoSystem",list);
                        }else if(type.equals("0")){
                            map.put("infoUser",list);
                        }
                    }
                }
            }else{
                paramMap.put("where", "{\"type\":\""+type+"\"}");
                String url = merchantFromCrmUrl + "/messages";
                String responseBody = HttpUtils.executeCrmHttpRequest(url, paramMap, HttpGet.METHOD_NAME, null);
                if(responseBody!=null && !responseBody.equals("")){
                    mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                    list = responseBody.equals("{}") ? null : (List<Map<String, String>>) mapper.readValue(responseBody, List.class);
                    if(type.equals("1")){
                        map.put("infoSystem",list);
                    }else if(type.equals("0")){
                        map.put("infoUser",list);
                    }
                }
            }
                logger.info("list:"+list);
        } catch (Exception e) {
            logger.info("查询消息  queryInfo...:" + e);
        }
        return map;
    }

    @Override
    public Map queryInfoDetail(String infoId, String type) {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap = new HashMap<String, String>();
        Map map = new HashMap();
        paramMap.put("where", "{\"type\":\""+type+"\"}");
        String url = merchantFromCrmUrl + "/messages/type/"+type+"/id/"+infoId;
        try {
            String responseBody = HttpUtils.executeCrmHttpRequest(url, paramMap, HttpGet.METHOD_NAME, null);
            if(responseBody!=null && !responseBody.equals("")){
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                map = mapper.readValue(responseBody, HashMap.class);
            }
        } catch (Exception e) {
            logger.info("queryInfoDetail... 查看消息明细:"+e);
        }

        return map;
    }

    @Override
    public String deleteInfo(String infoId, String type) {
        String code = "-1";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap = new HashMap<String, String>();
        Map map = new HashMap();
        paramMap.put("where", "{\"type\":\""+type+"\"}");
        String url = merchantFromCrmUrl + "/messages/type/"+type+"/id/"+infoId;
        try {
            String responseBody = HttpUtils.executeCrmHttpRequest(url, paramMap, HttpDelete.METHOD_NAME, mapper.writeValueAsString(paramMap));
            if(responseBody!=null && !responseBody.equals("")){
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                map = mapper.readValue(responseBody, HashMap.class);
                code = "1";
            }
            if(responseBody!=null && responseBody.contains("error")){
                code = "-1";
            }

        } catch (Exception e) {
            logger.info("查看消息明细:"+e);
        }
        return code;
    }

    /**
     * 银行卡绑定
     * @param request
     * @param applicationModel
     * @return
     */
    @Override
    public Map bindBank(HttpServletRequest request, ApplicationModel applicationModel) {
        applicationModel.setBlackBox(request.getSession().getAttribute("blackBox") + "");
        applicationModel.setIpAddress(Utility.getRemoteIp(request));
//        applicationModel.setType("5");
        ObjectMapper mapper = new ObjectMapper();

        Map map = new HashMap();
        Map resMap = new HashMap();
        String url = merchantFromCrmUrl + "/applications/"+applicationModel.getObjectId();

        Boolean result = newMerchantService.accredit(Constants.BIND_BANK_CARD, null, null, request.getSession().getAttribute("mobilePhone")+"", Utility.getRemoteIp(request),
                request.getSession().getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : request.getSession().getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString(),
                null, "", request.getHeader("user-agent")).getResultCode().
                equals(Constants.RESTFUL_RESULT_SUCCESS);

        if(result==true){
            logger.info("accredit success : 授权成功！");
            try {
                logger.info("更新申请，applicationModel：" + applicationModel);
                logger.info("更新申请，url："+url);
                String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPut.METHOD_NAME, mapper.writeValueAsString(applicationModel));
                if(responseBody!=null && !responseBody.equals("")){
                    mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                    map = mapper.readValue(responseBody, HashMap.class);
                    if(responseBody.contains("updatedAt") && map.get("updatedAt")!=null){
                        resMap.put("message","银行卡绑定成功！");
                        resMap.put("code",Constants.RESTFUL_RESULT_SUCCESS);
                    }else if(responseBody.contains("error") && map.get("error")!=null){
                        resMap.put("message",map.get("error"));
                        logger.info("binding bank Card error:" + map.get("error"));
                        resMap.put("code",Constants.RESTFUL_RESULT_FAILED);
                    }
                }
            } catch (Exception e) {
                logger.info("binding bank Card:"+e);
            }

        }else{
            resMap.put("message","授权成功！");
            logger.info("accredit failed : 授权成功！");
        }
        return resMap;
    }
}
