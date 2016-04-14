package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.dto.*;
import com.cardvalue.penguin.model.ActionLog;
import com.cardvalue.penguin.repository.ActionLogRepository;
import com.cardvalue.penguin.repository.UserRepository;
import com.cardvalue.penguin.service.UserService;
import com.cardvalue.penguin.service.WeChatService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.HttpUtils;
import com.cardvalue.penguin.util.Result;
import com.cardvalue.penguin.util.XMLConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by guojia.chen on 2015-12-29 16:23.
 *
 * @Description:
 */
@Service
public class WeChatServiceImpl implements WeChatService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WeChatServiceImpl.class);

    @Autowired
    private XMLConverter xmlConverter;

    @Value("${wechat.username}")
    private String weChatUsername;

    @Value("${wechat.url}")
    private String weChatUrl;

    @Value("${wechat.send.url}")
    private String weChatSendUrl;

    @Value("${wechat.send.template.url}")
    private String weChatSendTemplateUrl;

    @Value("${wechat.entry.message}")
    private String entryMessage;

    @Value("${wechat.entry.text.keyword}")
    private String entryTextKeyWord;

    @Value("${wechat.entry.click.keyword}")
    private String entryClickKeyword;

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String secret;

    @Value("${wechat.accesstoken.url}")
    private String weChatAccessTokenUrl;

    @Value(" ${wechat.gettoken.url} ")
    private String weChatGetTokenUrl;

    @Value(" ${wechat.getticket.url} ")
    private String weChatGetTicketUrl;

    @Value(" ${we.menu.create.url} ")
    private String weChatCreateMenuUrl;

    @Value(" ${we.group.list.url} ")
    private String weChatGroupListUrl;

    @Value(" ${we.group.create.url} ")
    private String weChatGroupCreateUrl;

    @Value(" ${we.group.move.url} ")
    private String weChatGroupMoveUrl;

    @Value(" ${we.group.update.url} ")
    private String weChatGroupUpdateUrl;

    @Value("${wechat.app.name}")
    private String appName;

    @Value("${wechat.appid}")
    private String weAppId;
    @Resource
    private ActionLogRepository actionLogRepository;

    @Resource
    private UserRepository userRepository;

    @Value("${ws.local.ip}")
    private String wsLocalIp;

    @Resource
    private UserService userService;

    private static String accessToken;

    private static Date accessTokenExpireDate;

    private static String jsapiTicket;

    private static Date jsapiTicketExpireDate;


    //    @Override
    public String getOpenIdByAccessToken(String code) {
        String openId = null;
        Map<String, String> map = new HashMap<String, String>();
        map.put("appid", appId);
        map.put("secret", secret);
        map.put("code", code);
        try {
            String responseBody = HttpUtils.executeHttpRequest(weChatAccessTokenUrl, map, HttpGet.METHOD_NAME);
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jParser = jsonFactory.createJsonParser(responseBody);
            while (jParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jParser.getCurrentName();
                logger.debug("json token : {}, text : {}", fieldName, jParser.getText());
                if ("openid".equals(fieldName)) {
                    jParser.nextToken();
                    openId = jParser.getText();
                    logger.info("open id: {}", openId);
                }
            }
        } catch (Exception e) {
            logger.error("error : ", e);
        }
        return openId;
    }

    public Result<?> listGroups() {

        String accessToken = getAccessToken();
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.WE_PARAM_NAME_ACCESS_TOKEN, accessToken);
        Result<List<WeGroup>> result = new Result<List<WeGroup>>();
        result.setCode(Constants.RESULT_CODE_FAILED);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeHttpRequest(weChatGroupListUrl, params, HttpGet.METHOD_NAME);
            try {
                WeGroupListResponse response = mapper.readValue(responseBody, WeGroupListResponse.class);
                result.setCode(Constants.RESULT_CODE_SUCCESS);
                result.setPayload(response.getGroups());
            } catch (JsonMappingException e) {
                logger.info("", e);
                WeCommonResponse resp = mapper.readValue(responseBody, WeCommonResponse.class);
                result.setMessage(resp.getErrmsg());
            }
        } catch (Exception e) {
            logger.error("error : ", e);
            result.setMessage(e.toString());
        }
        return result;
    }

    public synchronized String getAccessToken() {
        logger.info("Get access token [accessTokenExpireDate:" + accessTokenExpireDate + "]");
        logger.info("Get access token [currentDate:" + Calendar.getInstance().getTime() + "]");
        boolean tokenExpired = accessTokenExpireDate == null || Calendar.getInstance().getTime().after(accessTokenExpireDate);
        if (tokenExpired) {
            Map<String, String> params = new HashMap<String, String>();
            params.put(Constants.WE_PARAM_NAME_APPID, appId);
            params.put(Constants.WE_PARAM_NAME_SECRET, secret);
            params.put(Constants.WE_PARAM_NAME_GRANT_TYPE, Constants.WE_PARAM_VALUE_GRANT_TYPE);
            try {
                String responseBody = HttpUtils.executeHttpRequest(weChatGetTokenUrl, params, HttpGet.METHOD_NAME);
                ObjectMapper mapper = new ObjectMapper();
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                Calendar current = Calendar.getInstance();
                accessToken = map.get(Constants.WE_RESPONSE_KEY_ACCESS_TOKEN);
                current.add(Calendar.SECOND, Integer.parseInt(map.get(Constants.WE_RESPONSE_KEY_EXPIRES_IN)));
                accessTokenExpireDate = current.getTime();
            } catch (Exception e) {
                logger.error("error : ", e);
            }
        }
        return accessToken;
    }

    public Result<?> moveUserToGroup(String openId, int groupId) {

        String accessToken = getAccessToken();
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.WE_PARAM_NAME_ACCESS_TOKEN, accessToken);
        Result<Object> result = new Result<Object>();
        result.setCode(Constants.RESULT_CODE_FAILED);
        try {
            ObjectMapper mapper = new ObjectMapper();
            WeGroupMoveRequest request = new WeGroupMoveRequest();
            request.setGroupId(groupId);
            request.setOpenId(openId);
            String responseBody = HttpUtils.executeHttpRequest(weChatGroupMoveUrl, params, HttpPost.METHOD_NAME, mapper.writeValueAsString(request));
            WeCommonResponse resp = mapper.readValue(responseBody, WeCommonResponse.class);
            if (resp.getErrcode() == 0) {
                result.setCode(Constants.RESULT_CODE_SUCCESS);
            } else {
                result.setMessage(resp.getErrmsg());
            }
        } catch (Exception e) {
            logger.error("error : ", e);
            result.setMessage(e.toString());
        }
        return result;
    }

    @Override
    public void createMenu(WeMenu menu) {
        String accessToken = getAccessToken();
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.WE_PARAM_NAME_ACCESS_TOKEN, accessToken);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String menuJsonString = mapper.writeValueAsString(menu);
            logger.info("menu json string : {}", menuJsonString);
            String responseBody = HttpUtils.executeHttpRequest(weChatCreateMenuUrl, params, HttpPost.METHOD_NAME, menuJsonString);
            Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String,String>>(){});
            if(!map.get("errcode").equals("0")){
                logger.error("create menu failed");
            }
        } catch (Exception e) {
            logger.error("error : ", e);
        }
    }

    @Override
    public void pushMessage(String openId, String content){

//		if (wsLocalIp.equals("192.168.0.209")) {	//正式环境才发送
        TextMessage message = new TextMessage();
        message.setTouser(openId);
        message.getText().setContent(content);
        ObjectMapper mapper = new ObjectMapper();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String accessToken = getAccessToken();
        HttpPost httpPost = new HttpPost(weChatSendUrl + "access_token=" + accessToken);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        try{
            String customMessage = mapper.writeValueAsString(message);
            logger.info("push custom message [openid:" + openId + "][message:" + customMessage + "]");
            httpPost.setEntity(new StringEntity(customMessage, "utf-8"));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            StringBuilder sb = new StringBuilder();
            if(entity.isStreaming()){
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
                String line = reader.readLine();
                while(line != null){
                    sb.append(line);
                    line = reader.readLine();
                }
            }
            EntityUtils.consume(response.getEntity());

            //记录发送短信日志ACTION_LOG，发送openId、发送信息内容、发送时间、短息发送状态
            ActionLog actionLog = new ActionLog();
            actionLog.setCreateDate(new Date());
            actionLog.setAction(Constants.MOBILE_SEND_WEIXIN);
            actionLog.setMemo("发送openId:"+openId+";发送信息内容:"+content);
            actionLogRepository.save(actionLog);

            logger.info("push custom message and get result:" + sb.toString());
            response.close();
        }catch(Exception e){
            logger.error("error occurs while sending custom message", e);
        }finally{
            if(httpclient != null){
                try {
                    httpclient.close();
                } catch (IOException e) {
                    logger.error("error occurs while close http client", e);
                }
            }
        }
//	}
    }

    public synchronized String getTicket() {
        logger.info("Get access token [jsapiTicketExpireDate:" + jsapiTicketExpireDate + "]");
        logger.info("Get access token [currentDate:" + Calendar.getInstance().getTime() + "]");
        boolean jsapiTicketExpired = jsapiTicketExpireDate == null || Calendar.getInstance().getTime().after(jsapiTicketExpireDate);
        if (jsapiTicketExpired) {
            Map<String, String> params = new HashMap<String, String>();
            params.put(Constants.WE_PARAM_NAME_ACCESS_TOKEN, this.getAccessToken());
            params.put(Constants.WE_PARAM_NAME_TYPE, "jsapi");
            try {
                String responseBody = HttpUtils.executeHttpRequest(weChatGetTicketUrl, params, HttpGet.METHOD_NAME);
                ObjectMapper mapper = new ObjectMapper();
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {});
                jsapiTicket = map.get(Constants.WE_PARAM_NAME_TICKET);
                Calendar current = Calendar.getInstance();
                current.add(Calendar.SECOND, Integer.parseInt(map.get(Constants.WE_RESPONSE_KEY_EXPIRES_IN)));
                jsapiTicketExpireDate = current.getTime();
            } catch (Exception e) {
                logger.error("error : ", e);
            }
        }
        return jsapiTicket;
    }

}
