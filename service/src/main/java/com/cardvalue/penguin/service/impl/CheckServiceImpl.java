package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.model.NewMerchantUserModel;
import com.cardvalue.penguin.service.CheckService;
import com.cardvalue.penguin.service.NewMerchantService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.HttpUtils;
import com.cardvalue.penguin.util.RestfulResult;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-12 14:04.
 *
 * @Description:
 */
@Service
public class CheckServiceImpl implements CheckService {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CheckServiceImpl.class);

    @Value("${ws.crm.restful.merchant.url}")
    private String merchantFromCrmUrl;

    @Resource
    private NewMerchantService newMerchantService;
    /**
     * 如果没有验证：返回 1
     * 否则：返回 0
     * @param mobile
     * @return
     */
    @Override
    public String checkMobileAuth(String mobile) {
        String url = merchantFromCrmUrl + "/checkMobilePhoneRegisterAuth/"+ mobile;
        String responseBody = "";
        ObjectMapper mapper = new ObjectMapper();
        HashMap res = new HashMap();
        String result = "0";
        try {
             responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
            mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            res = mapper.readValue(responseBody, HashMap.class); //将json解析成HashMap
            result = res.get("hasRegisterAuth")+"";
        } catch (Exception e) {
            logger.info("获取手机是否授权时报错:"+e);
        }
        return result;
    }

    @Override
    public RestfulResult checkbizRegisterNo(String bizRegisterNo,String industryCId) {
        String url = merchantFromCrmUrl + "/enterpriseInfo";
        RestfulResult result = new RestfulResult();
        String responseBody = "";
        ObjectMapper mapper = new ObjectMapper();
        HashMap res = new HashMap();
        Map<String,String> map = new HashMap<String, String>();
        map.put("industryCId",industryCId);

        map.put("where","{\"bizRegisterNo\":\""+bizRegisterNo+"\"}");

        String resu = "0";
        try {
            responseBody = HttpUtils.executeCrmHttpRequest(url, map, HttpGet.METHOD_NAME, null);
            mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            res = mapper.readValue(responseBody, HashMap.class); //将json解析成HashMap
            if(res!=null && res.get("error")!=null && !res.get("error").equals("")){
                result.setResultCode("-1");
                result.setResultMsg(res.get("error")+"");
            }else{
                result.setResultCode("1");
                resu = res.get("ownerName")+"";
                result.setResultMsg(resu);
            }

        } catch (Exception e) {
            logger.info("获取手机是否授权时报错:"+e);
            result.setResultCode("-1");
        }
        return result;
    }

    @Override
    public RestfulResult queryBakns(String type, String bankName) {
        String url = merchantFromCrmUrl + "/banks";
        RestfulResult result = new RestfulResult();
        String responseBody = "";
        ObjectMapper mapper = new ObjectMapper();
        HashMap res = new HashMap();
        Map<String,String> map = new HashMap<String, String>();
        map.put("where","{\"type\":\""+type+"\", \"bankName\":{\"$regex\":\""+bankName+"\"}}");
        try {
            responseBody = HttpUtils.executeCrmHttpRequest(url, map, HttpGet.METHOD_NAME, null);
            mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            res = mapper.readValue(responseBody, HashMap.class); //将json解析成HashMap
            result.setResultData(res.get("results"));
            result.setResultCode("1");
        } catch (Exception e) {
            logger.info("获取手机是否授权时报错:"+e);
            result.setResultCode("-1");
        }
        return result;
    }

    @Override
    public RestfulResult getMoneyConfrim(NewMerchantUserModel newMerchantUserModel,HttpSession session) {
        String url = merchantFromCrmUrl + "/applications/"+newMerchantUserModel.getApplicationId();
        RestfulResult result = new RestfulResult();
        String responseBody = "";
        ObjectMapper mapper = new ObjectMapper();
        HashMap res = new HashMap();
        Map<String,String> map = new HashMap<String, String>();
        map.put("isWithdrawConfirm","1");
        try {
            responseBody = HttpUtils.executeCrmHttpRequest(url, map, HttpPut.METHOD_NAME, mapper.writeValueAsString(map));
            mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            res = mapper.readValue(responseBody, HashMap.class); //将json解析成HashMap
            if(res!=null && res.get("updatedAt")!=null && !res.get("updatedAt").equals("")){
                result.setResultCode("1");
                NewMerchantUserModel newMerchantUserModel2 = newMerchantService.getMerchantUserById(newMerchantUserModel.getObjectId());
                if (newMerchantUserModel != null)
                    session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel2); //保存绑定或者登录成功的用户信息
            }else{
                result.setResultCode("-1");
                result.setResultMsg(res.get("error")+"");
            }

        } catch (Exception e) {
            logger.info("提现确认时服务器异常:"+e);
            result.setResultCode("-1");
        }
        return result;
    }
}
