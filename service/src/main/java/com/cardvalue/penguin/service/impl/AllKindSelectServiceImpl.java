package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.service.AllKindSelectService;
import com.cardvalue.penguin.util.HttpUtils;
import org.apache.http.client.methods.HttpGet;
import org.codehaus.jackson.map.DeserializationConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-13 18:49.
 *
 * @Description:
 */
@Service
public class AllKindSelectServiceImpl implements AllKindSelectService {


    private final static Logger logger = LoggerFactory.getLogger(AllKindSelectServiceImpl.class);
    @Value("${ws.crm.restful.merchant.url}")
    private String wsCrmRestfulMerchantUrl;



    public List<Map<String, String>> getPlanFundTerm() {

        HashMap<String, Object> testMap = new HashMap<String, Object>();
        String url = wsCrmRestfulMerchantUrl +"/planFundTerm";
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        String responseBody = "";
        try {
            responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
            org.codehaus.jackson.map.ObjectMapper mapper = new org.codehaus.jackson.map.ObjectMapper();
/*
            List<Map<String, String>> list = new ObjectMapper().readValue(responseBody, new TypeReference<List<Map<String, String>>>() {
            });*/
            if (responseBody.indexOf("error") == -1 && !responseBody.equals("")) {
                //表示已经绑定过
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                list = mapper.readValue(responseBody, ArrayList.class) ; //将json解析成HashMap
            }
        } catch (Exception e) {
            logger.info("查询拟融资期限出错："+e);
        }
        return list;
    }
}
