package com.cardvalue.penguin.service.impl;

import com.aladin.forweixin.AladinPortBindingStub;
import com.aladin.forweixin.WeixinData;
import com.cardvalue.penguin.dto.MerchantRegisterDTO;
import com.cardvalue.penguin.model.Sales;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.service.MerchantService;
import com.cardvalue.penguin.service.UtilityService;
import com.cardvalue.penguin.util.HttpUtils;
import com.cardvalue.penguin.util.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.*;

/**
 * Created by guojia.chen on 2015-12-31 14:12.
 *
 * @Description:
 */
@Service
public class MerchantServiceImpl implements MerchantService, InitializingBean {

    private final static Logger logger = LoggerFactory.getLogger(MerchantServiceImpl.class);

    private AladinPortBindingStub aladinWsStub;

    @Value("${ws.aladin.endpoint}")
    private String aladinWsEndpoint;

    @Value("${ws.settle.url}")
    private String billCheckUrl;

    @Value("${ws.jxl.url.crm}")
    private String getBillCheckUrl;

    @Resource
    private UtilityService utilityService;

//    @Override
    public void afterPropertiesSet() throws Exception {
        aladinWsStub = new AladinPortBindingStub(new URL(aladinWsEndpoint), null);
    }

    public List<HashMap<String, String>> bankStatementLists(String baoliId) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("cashadvId", baoliId);
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            if (baoliId != null && !baoliId.equals("")) {
                String url = billCheckUrl + "user/checkingUser";
                String responseBody = HttpUtils.executeHttpRequest(url, paramMap, HttpGet.METHOD_NAME);
                mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                list = (List<HashMap<String, String>>) mapper.readValue(responseBody, List.class);
            }
        } catch (Exception e) {
            logger.info("还款明细 bankStatementLists:" + e);
        }
        return list;
    }


    @Transactional
    public Result<?> createMerchant(MerchantRegisterDTO dto, Sales s,WeUser user,HttpSession session) {

        Result<?> result = new Result<Object>();

        /*//短信验证
        String checkCodeResult = null;
        if(dto.isRequireCheck()){
            checkCodeResult = utilityService.validateCheckCode(session, dto.getContactMobile(), dto.getCheckCode());
        }

        if(checkCodeResult == null){

            //表示手机短信验证通过

            logger.info("start creating merchant...");
            int flag = merchantRepo.create(dto, s,user,session);
            logger.info("create merchant account into db:" + flag);
            if(flag == 1){
                WeixinData request = new WeixinData();
                request.setBusinessName(dto.getMerchantName());
                request.setMid(dto.getMid());
                request.setMobile(dto.getContactMobile());
                request.setName(dto.getContactName());
                request.setUq(UUID.randomUUID().toString());
                try {
                    logger.info("start calling aladin ws to insert call list");
                    if(s != null){
                        request.setStringField19(s.getName());
                        Parameter param = paramRepo.findByGroupAndValue(Constants.PARAM_GROUP_CONTACT_POSITION, String.valueOf(dto.getContactPosition()));
                        request.setStringField37(param.getName());
                    }
                    SoapGetAppStatusRequest statusRequest = new SoapGetAppStatusRequest();
                    serviceUtils.setAutheticateInfo(statusRequest, Constants.USER_TYPE_UMS_SALES);
                    statusRequest.setMID(dto.getMid());
                    ArrResponse response = serviceUtils.getServiceStub().soapGetAppStatus(statusRequest);
                    if(response != null && StringUtils.equals(response.getData(), "live")){
                        request.setStringField26("活动商户");
                    }
                    String result2 = aladinWsStub.addWenxinDataToAladin(request);
                    logger.info("the calling result for aladin interface is " + result2);
                } catch (RemoteException e) {
                    logger.error("Error occurs while calling Aladin", e);
                } catch (Exception e) {
                    logger.error("Error occurs while calling Aladin", e);
                }
            }

            if(flag == 0){
                //mid已存在
                result.setCode(Constants.RESULT_CODE_FAILED);
                result.setMessage("认证失败，您提交的POS机编号或者手机号已被添加，如需咨询，请联系4008-803-803。");
            }else{
                //成功
                referrerLinkRepo.valid(dto.getLinkId());
                weService.pushMessage(dto.getOpenId(), "亲，您已经成功完成认证，银商客户经理会在两个工作日内为您审核认证。卡得万利商业保理是银联商务天天富互联网金融产品，可以为您提供无担保无抵押的融资服务，如需帮助请拔打40086081310。");
                result.setCode(Constants.RESULT_CODE_SUCCESS);
                result.setMessage("亲，您已经成功提交认证申请，我们的远程客户经理会协助商户完成认证审核，成功后会及时给您通知!");
            }
        }else{
            //表示验证码验证失败
            result.setCode(Constants.RESULT_CODE_FAILED);
            result.setMessage(checkCodeResult);
            return result;
        }*/


        return result;
    }

    public Map getStatementLists(String applicationId,String skip,String limit) {

        String url = getBillCheckUrl + "/applications/"+applicationId+"/cashList";
        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("skip",skip);
        paramMap.put("limit",limit);

        Map map = new HashMap();
        String responseBody = null;
        try {
            responseBody = HttpUtils.executeCrmHttpRequest(url, paramMap, HttpGet.METHOD_NAME, null);
            mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            map = (Map) mapper.readValue(responseBody, Map.class);
        } catch (Exception e) {

            logger.info("query the bill with error"+e);
            e.printStackTrace();

        }
           return map;
    }
}
