package com.cardvalue.penguin.service;

import com.cardvalue.penguin.dto.*;
import com.cardvalue.penguin.model.ApplicationModel;
import com.cardvalue.penguin.model.CreditReportModel;
import com.cardvalue.penguin.model.NewMerchantUserModel;
import com.cardvalue.penguin.model.VerifyQuestionModel;
import com.cardvalue.penguin.util.RestfulResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by guojia.chen on 2015-12-29 16:18.
 *
 * @Description:
 */

public interface NewMerchantService {

    public NewMerchantUserModel enter(String code, HttpSession session, HttpServletRequest request);

    public List getVerifyQuestion(String creditId, String mid);

    public RestfulResult bind(BindDTO dto, HttpSession session, HttpServletRequest request);

    public RestfulResult forgetPassword(ForgetPasswordDTO dto, HttpSession session);

    public RestfulResult login(LoginDTO dto, HttpSession session, HttpServletRequest request);

    public RestfulResult logout(HttpSession session);

    public RestfulResult updatePassword(UpdatePasswordDTO dto);

    public NewMerchantUserModel getMerchantUserById(String merchantUserId);

    public RestfulResult accredit(String type, String merchantId, String applicationId, String mobilePhone, String ip, String openId, String deviceNumber, String gps, String agent);

    public ApplicationModel getApplicationById(String applicationId);

    public RestfulResult posLimit(PosLimitDTO dto, HttpSession session);

    public RestfulResult basicLimit(BasicLimitDTO dto, NewMerchantUserModel newMerchantUserModel, HttpSession session);

    public List queryApplications(String merchantId);

    public RestfulResult createApplication(String merchantId, HttpSession session);

    public List queryConfirmlists(String applicationId);

    public List queryUploadFileMain(String merchantId, boolean isPending);

    public List queryCoupons(String merchantId,String type,String status);

    //查询确认清单 1：申请信息，2：融资方案，3：融资保理通知书
    public Map financingPlan(String applicationId,String type);

    public List queryUploadFileChildModel(String merchantId, String groupName);

    public List queryUploadFileChildModel2(String merchantId);

    public List queryUploadFileChildModel3(String merchantId);

    public List queryUploadFileChildModel4(String merchantId);

    public RestfulResult updateMerchantUser(String merchantUserId, Map parameter, HttpSession session);

    public RestfulResult updateMerchantUserlatitudeAndLongitude(String openId, Map parameter);

    public RestfulResult updateApplication(String applicationId, Map parameter);

    public List getCashdvancesAppById(String appId);

    public RestfulResult addFile(String baoliId);

    public List queryProvinces();

    public List queryCitys(String provinceId);

    public List queryIndustrys();

    public List queryIndustryDetails(String industryId, String merchantId);

    public List queryIndustryPidDetails(String industryId, String merchantId);

    public RestfulResult getCredits(String creditId);

    public List queryPosCreditsMids(String creditId);

    public PosMidModel queryCheckFailMid(List<PosMidModel> list);

    public PosMidModel queryProcessingMid(List<PosMidModel> list);

    public PosMidModel queryMakingQuestionsMid(List<PosMidModel> list);

    public RestfulResult updateCreditCheckQuestions(String creditId, String mid, Map parameter);

    public RestfulResult juxinliLimit(JuxinliLimitDTO dto, NewMerchantUserModel newMerchantUserModel, HttpSession session);

    public Map crediAauthoriza(NewMerchantUserModel newMerchantUserModel, HttpSession session);


    public RestfulResult emailLimit(EmailLimitDTO dto, NewMerchantUserModel newMerchantUserModel, HttpSession session);

    public RestfulResult saveFeedbackComments(FeedbackTO feedbackTO, HttpSession session);

    Map creditReport(CreditReportModel reportModel, String applicationId, HttpSession session);

    public RestfulResult validateQuestionAnswer(String selectedAmt, String credits, String midVerification,HttpSession session);

    public Map addMerchant(HttpSession session);

    public List<Map> queryMuliteMerchant(HttpSession session);

    public Map invitedRecord(String merchantId);

    public void isFirstTimeLogin(HttpSession session);


}
