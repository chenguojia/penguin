package com.cardvalue.penguin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.CodingErrorAction;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    @Value("${X-CRM-Version}")
    private static String penguinVersion;//小企额版本号

    @Resource
    private static HttpServletRequest request;

    public static HttpClientConnectionManager buildConnectionManager(){
        PoolingHttpClientConnectionManager conManager = null;
        InputStream caInput = null;
        Certificate ca;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            //读取证书
            caInput = HttpUtils.class.getClassLoader().getResourceAsStream("weixin.qq.com.crt");
            ca = cf.generateCertificate(caInput);
            // System.out.println("ca=" + ((X509Certificate)ca).getSubjectDN());
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            trustStore.setCertificateEntry("ca", ca);

            SSLContextBuilder sslContextbuilder = new SSLContextBuilder();
            sslContextbuilder.useTLS();
            sslContextbuilder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                    .<ConnectionSocketFactory> create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https",new SSLConnectionSocketFactory(sslContextbuilder.build(),SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER))
                    .build();

            // ConnectionManager
            conManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            MessageConstraints messageConstraints = MessageConstraints.custom().setMaxHeaderCount(200).setMaxLineLength(2000).build();
            //ConnectionConfig
            ConnectionConfig connectionConfig = ConnectionConfig.custom()
                    .setMalformedInputAction(CodingErrorAction.IGNORE)
                    .setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8)
                    .setMessageConstraints(messageConstraints).build();
            conManager.setDefaultConnectionConfig(connectionConfig);
        } catch (Exception e) {
            logger.error("Error occurs whiling building https connection", e);
        } finally {
            try {
                caInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return conManager;
    }

    public static String executeHttpRequest(String url, Map<String, String> parameters, String method) throws Exception{
        return executeHttpRequest(url, parameters, method, null);
    }

    public static String executeHttpRequest(String url, Map<String, String> parameters, String method, String content) throws Exception{
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(HttpUtils.buildConnectionManager()).build();
        URIBuilder builder = new URIBuilder(url.trim());
        Iterator<String> iter = parameters.keySet().iterator();
        while(iter.hasNext()){
            String param = iter.next();
            String value = parameters.get(param);
            builder.addParameter(param, value);
        }
        URI uri = builder.build();
        logger.info("url : {}", uri.toString());
        HttpUriRequest httpRequest = createHttpRequest(method, uri.toString(), content);
        CloseableHttpResponse response = httpclient.execute(httpRequest);
        logger.info("status code : {}, reason : {} ", response.getStatusLine().getStatusCode(), response.getStatusLine().getReasonPhrase());
        HttpEntity entity = response.getEntity();
        BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "utf8"));
        String line = reader.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null){
            sb.append(line);
            line = reader.readLine();
        }
        String body = sb.toString();
        logger.info("response body : {}", body);
        EntityUtils.consume(response.getEntity());
        response.close();
        httpclient.close();
        return body;
    }

    public static HttpUriRequest createHttpRequest(String method, String uri, String content) throws UnsupportedEncodingException{
        HttpUriRequest request = null;
        if(StringUtils.equalsIgnoreCase(method, HttpPost.METHOD_NAME)){
            request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json;charset=UTF-8");
            ((HttpPost)request).setEntity(new StringEntity(content, "utf-8"));
        }else if(StringUtils.equalsIgnoreCase(method, HttpGet.METHOD_NAME)){
            request = new HttpGet(uri);
        }
        return request;
    }

    /**
     * 调用CRM特殊HeaderHTTP请求
     * @param url
     * @param getParameters GET请求时：参数格式为MAP即可
     * @param method
     * @param postJsonContent POST请求时：参数格式为JSON
     * @param headerArr header
     * @return
     * @throws Exception
     */
    public static String executeCrmHttpRequest(String url, Map<String, String> getParameters, String method,String postJsonContent,Map headerArr) throws Exception {
        logger.info("url================="+url);
        logger.info("postJsonContent================="+postJsonContent);
        logger.info("map================="+getParameters);
        return executeHttpRequest(url, getParameters, method, headerArr, postJsonContent);
    }

    /**
     * 调用CRM特殊HeaderHTTP请求
     * @param url
     * @param getParameters GET请求时：参数格式为MAP即可
     * @param method
     * @param postJsonContent POST请求时：参数格式为JSON
     * @return
     * @throws Exception
     */
    public static String executeCrmHttpRequest(String url, Map<String, String> getParameters, String method,String postJsonContent) throws Exception {
        Map headerArr = new HashMap();
        HttpSession session = Utility.session();
        if(session!=null && session.getAttribute("upload")!=null && session.getAttribute("upload").equals("1")){
            headerArr.put("Content-Type","text/base64");
        }
        headerArr.put("X-CRM-Application-Id","wechat");
        headerArr.put("X-CRM-Version",ConfigInfo.getValue("X-CRM-Version"));

        if (session != null && session.getAttribute("accessToken") != null) {
            headerArr.put("X-CRM-Access-Token", session.getAttribute("accessToken").toString());
        }
        if (session != null && session.getAttribute("user-agent") != null) {
            headerArr.put("user-agent", session.getAttribute("user-agent").toString());
        }
        if (session != null && session.getAttribute("objectId") != null) {
            headerArr.put("X-CRM-Merchant-Id", session.getAttribute("objectId").toString());
        }
//        session.setAttribute("objectId", newMerchantUserModel.getObjectId());//保存用户id
        return executeHttpRequest(url, getParameters, method, headerArr, postJsonContent);
    }

    /**
     * 调用CRM特殊HeaderHTTP请求,
     * @param url
     * @param getParameters GET请求时：参数格式为MAP即可
     * @param method
     * @param postJsonContent POST请求时：参数格式为JSON
     * @return
     * @throws Exception
     */
    public static String executeCrmHttpRequest2(String url, Map<String, String> getParameters, String method,String postJsonContent) throws Exception {
        logger.info("url================="+url);
        logger.info("postJsonContent================="+postJsonContent);
        logger.info("map================="+getParameters);
        Map headerArr = new HashMap();
        headerArr.put("X-CRM-Application-Id","manager");
        headerArr.put("Content-Type","application/json");
        HttpSession session = Utility.session();
        if (session != null && session.getAttribute("accessToken") != null) {
            headerArr.put("X-CRM-Access-Token",session.getAttribute("accessToken").toString());
        }

        if (session != null && session.getAttribute("version") != null) {
            headerArr.put("X-CRM-Version", session.getAttribute("version").toString());
        }
        if (session != null && session.getAttribute("user-agent") != null) {
            headerArr.put("user-agent",session.getAttribute("user-agent").toString());
        }

        if (session != null && session.getAttribute("uid") != null) {
            headerArr.put("X-CRM-User-Id", session.getAttribute("uid").toString());
        }
        if (session != null && session.getAttribute("objectId") != null) {
            headerArr.put("X-CRM-Merchant-Id", session.getAttribute("objectId").toString());
        }

        return executeHttpRequest(url, getParameters, method, headerArr, postJsonContent);
    }

    /**
     * header验证重写
     * @param url
     * @param parameters
     * @param method
     * @param content
     * @return
     * @throws Exception
     */
    public static String executeHttpRequest(String url, Map<String, String> parameters, String method, Map header,String content) throws Exception{
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(HttpUtils.buildConnectionManager()).build();
        URIBuilder builder = new URIBuilder(url.trim());
        if (parameters != null) {
            Iterator<String> iter = parameters.keySet().iterator();
            while(iter.hasNext()){
                String param = iter.next();
                String value = parameters.get(param);
                builder.addParameter(param, value);
            }
        }
        URI uri = builder.build();
        logger.info("url : {}", uri.toString());
        HttpUriRequest httpRequest = createHttpRequest(method, uri.toString(), content,header);
        CloseableHttpResponse response = httpclient.execute(httpRequest);
        logger.info("status code : {}, reason : {} ", response.getStatusLine().getStatusCode(), response.getStatusLine().getReasonPhrase());
        HttpEntity entity = response.getEntity();
        BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "utf8"));
        String line = reader.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null){
            sb.append(line);
            line = reader.readLine();
        }
        String body = sb.toString();
        logger.info("response body : {}", body);
        EntityUtils.consume(response.getEntity());
        response.close();
        httpclient.close();
        return body;
    }

    /**
     * header验证重写
     * @param method
     * @param uri
     * @param content
     * @param header
     * @return
     * @throws UnsupportedEncodingException
     */
    public static HttpUriRequest createHttpRequest(String method, String uri, String content,Map header) throws UnsupportedEncodingException{
        HttpUriRequest request = null;
        if(StringUtils.equalsIgnoreCase(method, HttpPost.METHOD_NAME)){
            request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json;charset=UTF-8");
            ((HttpPost)request).setEntity(new StringEntity(content, "utf-8"));
            logger.info(method + " parameter : {}", content);
        }else if(StringUtils.equalsIgnoreCase(method, HttpGet.METHOD_NAME)){
            request = new HttpGet(uri);
        } else if(StringUtils.equalsIgnoreCase(method, "PUT")){
            request = new HttpPut(uri);
            request.setHeader("Content-Type", "application/json;charset=UTF-8");
            ((HttpPut)request).setEntity(new StringEntity(content, "utf-8"));
            logger.info(method + " parameter : {}", content);
        } else if(StringUtils.equalsIgnoreCase(method, "DELETE")){
            request = new HttpDelete(uri);
            request.setHeader("Content-Type", "application/json;charset=UTF-8");
            logger.info(method + " parameter : {}", content);
        }

        //CRM需要setHeader验证
        request.setHeader("Content-Type", "application/json");
        Iterator<String> iter = header.keySet().iterator();
        while(iter.hasNext()){
            String key = iter.next();
            String value = (String) header.get(key);
            request.setHeader(key, value);
        }

        return request;
    }

}
