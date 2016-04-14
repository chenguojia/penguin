package com.cardvalue.penguin.web;

import com.cardvalue.penguin.util.HttpUtils;
import com.cardvalue.penguin.util.RestfulResult;
import com.cardvalue.penguin.util.UUIDGenerator;
import org.apache.commons.httpclient.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-16 15:51.
 *
 * @Description: 该类主要解决前端ajax跨域时，有一些方法浏览器不兼容的情况
 */

@Controller
@RequestMapping("/cross/domain")
public class CrossDomainController {

    private static final Logger logger = LoggerFactory.getLogger(CrossDomainController.class);

    CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(HttpUtils.buildConnectionManager()).build();
    @RequestMapping(value = "/deletePic")
    @ResponseBody
    public RestfulResult deletePic(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        RestfulResult result = new RestfulResult("-1", "系统出错啦!", null);
        String delUrl = request.getParameter("url");
        try {
            String resp = HttpUtils.executeCrmHttpRequest(delUrl,null,"DELETE",null);
            if(resp != null && resp.contains("error")){
                result.setResultCode("1");
                result.setResultMsg("删除成功!");
            }
        } catch (Exception e) {
            logger.info("删除照片出错了：url="+delUrl);
            logger.info("删除照片出错了："+e);
        }

        return result;
    }



    @RequestMapping(value = "/uploadfile",method = RequestMethod.POST)
    @ResponseBody
    public Map uploadFile(HttpSession session,String url ,String data,String fileName){

        ObjectMapper objectMapper = new ObjectMapper();
//        String filename= URLEncoder.encode(fileName, "utf-8");
        Map map = new HashMap();
        Map mapRes = new HashMap();
        map.put("data",data);
        String urlRes = url + UUIDGenerator.getUUID();
        try {
            session.setAttribute("upload", "1");
            String resp = HttpUtils.executeCrmHttpRequest(urlRes, null, "POST", data);
            mapRes.put("resp", resp);
            session.setAttribute("upload", "0");
            logger.info("resp:"+resp);
        } catch (Exception e) {
            mapRes.put("code","-1");
            logger.info("upload file failed :" +e);
        }
        return mapRes;
    }
}
