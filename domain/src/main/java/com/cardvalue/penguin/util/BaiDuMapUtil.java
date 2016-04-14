package com.cardvalue.penguin.util;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guojia.chen on 2015-12-31 14:37.
 *
 * @Description:
 */
public class BaiDuMapUtil {

    public static final String appKey = "B826df082d0efc90620aeac58b4df2d0";//百度key


    /**
     * 根据地址获取单个准确的经纬度
     *
     * @param address
     * @return
     */
    public static Object getSingleLngAndLat(String address) {
        RestfulResult result = new RestfulResult("-1", "获取位置出错!", null);
        Map<String,Object> mapRes = new HashMap<String, Object>();
        try {
            String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address + "&output=json&ak=" + appKey;
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
            if (StringUtils.isNotBlank(responseBody)) {
                Map map = mapper.readValue(responseBody, new TypeReference<Map>() {});
                if (map.get("status").toString().equals("0")) {
                    Map<String,Object> data = (Map<String,Object>) map.get("result");
                    List returnData = new ArrayList();

                    //构建单个对象
                    Map currentAddress = new HashMap();
                    Map<String,Double> location = (Map) data.get("location");
                    if(location!=null){
                        currentAddress.put("name",address);
                        currentAddress.put("city","");
                        currentAddress.put("district","");
                        currentAddress.put("lngAndlat",location.get("lng").toString() + "," + location.get("lat").toString());
                        returnData.add(currentAddress);
                        result.setResultData(returnData);
                        mapRes.put("resultData",returnData);
                    }

                    if(returnData != null && returnData.size() > 0){
                        result.setResultMsg("获取单个地址成功!");
                        result.setResultCode("1");
                        mapRes.put("resultCode","1");
                        mapRes.put("code", 1);
                        mapRes.put("resultMsg", map.get("message"));
                    }else{
                        mapRes.put("code", "-1");
                        mapRes.put("resultMsg", map.get("message"));

                        mapRes.put("error", "获取位置出错!");
                        mapRes.put("resultCode", "-1");
                        mapRes.put("resultMsg","获取位置出错!");
                    }
                } else {
                    mapRes.put("resultCode","1");
                    mapRes.put("code", 1);
//                    result.setResultData(map.get("message"));
                    mapRes.put("resultData", map.get("message"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapRes;
    }

    /**
     * 根据地址模糊匹配多个地址经纬度
     *
     * @param address 输入的地址
     * @return
     */
    public static Object getMultiLngAndLat(String address) {
        RestfulResult result = new RestfulResult("-1", "获取位置出错!", null);
        Map<String,Object> mapRes = new HashMap<String, Object>();
        try {
            String url = "http://api.map.baidu.com/place/v2/suggestion?query=" + address + "&region=131&output=json&ak=" + appKey;
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
            if (StringUtils.isNotBlank(responseBody)) {
                Map map = mapper.readValue(responseBody, new TypeReference<Map>() {});
                if (map.get("status").toString().equals("0")) {
                    List<Map<String,Object>> datas = (List<Map<String,Object>>) map.get("result");
                    List returnData = new ArrayList();
                    for (Map<String, Object> data : datas) {
                        Map currentAddress = new HashMap();
                        Map<String,Double> location = (Map) data.get("location");
                        if(location!=null){
                            currentAddress.put("name",data.get("name"));
                            currentAddress.put("city",data.get("city"));
                            currentAddress.put("district", data.get("district"));
                            currentAddress.put("lngAndlat", location.get("lng").toString() + "," + location.get("lat").toString());
                            returnData.add(currentAddress);
                        }
                    }
                    result.setResultData(returnData);
                    mapRes.put("resultData",returnData);
                    if(returnData!=null && returnData.size()>0){
//                        result.setResultMsg(map.get("message") + "");
//                        result.setResultCode("1");
                        mapRes.put("resultCode", 1);
                        mapRes.put("code", 1);
                        mapRes.put("resultMsg",map.get("message"));
                    }else{
                        mapRes.put("code", "-1");
                        mapRes.put("resultMsg",map.get("message"));

                        mapRes.put("error", "获取位置出错!");
                        mapRes.put("resultCode", "-1");
                        mapRes.put("resultMsg","获取位置出错!");
                    }

                } else {
                    mapRes.put("code", 1);
                    mapRes.put("resultCode","1");
//                    result.setResultData(map.get("message"));
                    mapRes.put("resultData", map.get("message"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapRes;
    }

    public static void main(String[] args) {
//        RestfulResult result =  BaiDuMapUtil.getMultiLngAndLat("北张家浜路");
//        System.out.println("data is " + result.getResultData());
    }
}
