package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.service.CouponService;
import com.cardvalue.penguin.util.HttpUtils;
import org.apache.http.client.methods.HttpPut;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-22 13:10.
 *
 * @Description:
 */
@Service
public class CouponServiceImpl implements CouponService {


    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CouponServiceImpl.class);
    @Value("${ws.crm.restful.merchant.url}")
    private String merchantFromCrmUrl;


    @Override
    public Map exchangeCoupons(HttpSession session, String ownerName, String cardNo,String couponId) {

        Map<String,String> paraMap = new HashMap<String,String>();
        Map resMap = new HashMap();
        paraMap.put("ownerName",ownerName);
        paraMap.put("cardNo",cardNo);

        String url = merchantFromCrmUrl + "/merchants/" + session.getAttribute("objectId")+"/coupons/"+couponId;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url,null, HttpPut.METHOD_NAME,mapper.writeValueAsString(paraMap));
            if(responseBody!=null && responseBody.length()>0){
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                resMap = mapper.readValue(responseBody, HashMap.class);
            }
            if(resMap!=null && resMap.get("error")!=null){
                resMap.put("message",resMap.get("error"));
            }else{
                resMap.put("message","提现成功，提现金额会在三个工作日到账!");
            }
            logger.info("exchange coupons responseBody...." +responseBody);
        } catch (Exception e) {
            logger.info("exchange coupons with error...." +e);
        }
        return resMap;
    }
}
