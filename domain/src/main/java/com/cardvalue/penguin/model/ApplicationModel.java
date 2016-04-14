package com.cardvalue.penguin.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by guojia.chen on 2015-12-29 16:37.
 *
 * @Description: 提交申请描述字段
 */
public class ApplicationModel {

    private String creditReportStatus;//征信报告是否验证：0-未验证，1-已验证
    private String isJxlValid;
    private String isCreditNeedMove;//是否需要迁移

    private String status;
    private String statusDetail;
    private String appStatus;
    private String leadStatus;
    private String createdAt;
    private String updatedAt;
    private String objectId;
    private String cashadvanceId;//保理id，根据保理id查询对账单信息
    private String cashadvanceStatus;
    private String isComputingAmount;//是否正在计算额度 1，是；0，否。
    private Double amountRequested;//授信额度
    private Integer requestAmount;//授信额度,为了做转化使用
    private String isAmountLocked;//是否最终额度
    private String creditId;//授信id
    private String isEnabled;//授信id
    private String isDocumentLocked;//是否允许修改申请中的资料
    private List<Map> progress;
    private List<Map> coupons;//优惠券信息
    private String verifyVideoStatus;//
    private String isWithdrawConfirm;// 银行卡是否绑定
    private String type;//银行卡类型，对公、对私


    private String directDebitBankName;//  还款银行名称
    private String directDebitBankCode;//  还款银行编号
    private String directDebitAcctName;//  还款账户名
    private String directDebitAcctNo;//    还款账号
    private String directDebitAcctId;//    还款账号身份证
    private String directDebitAcctPhone;// 预留手机号
    private String secondaryBankAccountType;//   放款账户类型，对公、对私
    private String secondaryBankAcctName;//      放款开户名称
    private String secondaryBankABA;//           放款银行行号
    private String secondaryBankName;//          放款银行名称
    private String secondaryBankDDA;//           放款银行账号
    @JsonProperty(value = "BankAcctName")
    private String bankAcctName;//

    private String ipAddress;//ip地址
    private String blackBox;//童盾(或者客户端) sessionId
    private String mobilePhoneVerifyCode;//手机验证码
    private String isSubmitApplication;//是否已经点击提交

    private String familyInfoCompleted;//
    private String identificationCompleted;//
    private String storeInfoCompleted;//
    private String leaseInfoCompleted;//
//    private String directDebitAcctName;//

    public String getStoreInfoCompleted() {
        return storeInfoCompleted;
    }

    public void setStoreInfoCompleted(String storeInfoCompleted) {
        this.storeInfoCompleted = storeInfoCompleted;
    }

    public String getLeaseInfoCompleted() {
        return leaseInfoCompleted;
    }

    public void setLeaseInfoCompleted(String leaseInfoCompleted) {
        this.leaseInfoCompleted = leaseInfoCompleted;
    }

    public String getIdentificationCompleted() {
        return identificationCompleted;
    }

    public void setIdentificationCompleted(String identificationCompleted) {
        this.identificationCompleted = identificationCompleted;
    }

    public String getFamilyInfoCompleted() {
        return familyInfoCompleted;
    }

    public void setFamilyInfoCompleted(String familyInfoCompleted) {
        this.familyInfoCompleted = familyInfoCompleted;
    }

    public String getIsSubmitApplication() {
        return isSubmitApplication;
    }

    public void setIsSubmitApplication(String isSubmitApplication) {
        this.isSubmitApplication = isSubmitApplication;
    }

    public String getBankAcctName() {
        return bankAcctName;
    }

    public void setBankAcctName(String bankAcctName) {
        this.bankAcctName = bankAcctName;
    }

    public String getMobilePhoneVerifyCode() {
        return mobilePhoneVerifyCode;
    }
    public void setMobilePhoneVerifyCode(String mobilePhoneVerifyCode) {
        this.mobilePhoneVerifyCode = mobilePhoneVerifyCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getBlackBox() {
        return blackBox;
    }

    public void setBlackBox(String blackBox) {
        this.blackBox = blackBox;
    }

    public String getIsJxlValid() {
        return isJxlValid;
    }

    public void setIsJxlValid(String isJxlValid) {
        this.isJxlValid = isJxlValid;
    }

    public String getDirectDebitBankName() {
        return directDebitBankName;
    }

    public void setDirectDebitBankName(String directDebitBankName) {
        this.directDebitBankName = directDebitBankName;
    }

    public String getDirectDebitBankCode() {
        return directDebitBankCode;
    }

    public void setDirectDebitBankCode(String directDebitBankCode) {
        this.directDebitBankCode = directDebitBankCode;
    }

    public String getDirectDebitAcctName() {
        return directDebitAcctName;
    }

    public void setDirectDebitAcctName(String directDebitAcctName) {
        this.directDebitAcctName = directDebitAcctName;
    }

    public String getDirectDebitAcctNo() {
        return directDebitAcctNo;
    }

    public void setDirectDebitAcctNo(String directDebitAcctNo) {
        this.directDebitAcctNo = directDebitAcctNo;
    }

    public String getDirectDebitAcctId() {
        return directDebitAcctId;
    }

    public void setDirectDebitAcctId(String directDebitAcctId) {
        this.directDebitAcctId = directDebitAcctId;
    }

    public String getDirectDebitAcctPhone() {
        return directDebitAcctPhone;
    }

    public void setDirectDebitAcctPhone(String directDebitAcctPhone) {
        this.directDebitAcctPhone = directDebitAcctPhone;
    }

    public String getSecondaryBankAccountType() {
        return secondaryBankAccountType;
    }

    public void setSecondaryBankAccountType(String secondaryBankAccountType) {
        this.secondaryBankAccountType = secondaryBankAccountType;
    }

    public String getSecondaryBankAcctName() {
        return secondaryBankAcctName;
    }

    public void setSecondaryBankAcctName(String secondaryBankAcctName) {
        this.secondaryBankAcctName = secondaryBankAcctName;
    }

    public String getSecondaryBankABA() {
        return secondaryBankABA;
    }

    public void setSecondaryBankABA(String secondaryBankABA) {
        this.secondaryBankABA = secondaryBankABA;
    }

    public String getSecondaryBankName() {
        return secondaryBankName;
    }

    public void setSecondaryBankName(String secondaryBankName) {
        this.secondaryBankName = secondaryBankName;
    }

    public String getSecondaryBankDDA() {
        return secondaryBankDDA;
    }

    public void setSecondaryBankDDA(String secondaryBankDDA) {
        this.secondaryBankDDA = secondaryBankDDA;
    }

    public Integer getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(Integer requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsWithdrawConfirm() {
        return isWithdrawConfirm;
    }

    public void setIsWithdrawConfirm(String isWithdrawConfirm) {
        this.isWithdrawConfirm = isWithdrawConfirm;
    }

    public String getCreditReportStatus() {
        return creditReportStatus;
    }

    public void setCreditReportStatus(String creditReportStatus) {
        this.creditReportStatus = creditReportStatus;
    }

    public String getIsCreditNeedMove() {
        return isCreditNeedMove;
    }

    public void setIsCreditNeedMove(String isCreditNeedMove) {
        this.isCreditNeedMove = isCreditNeedMove;
    }

    public String getVerifyVideoStatus() {
        return verifyVideoStatus;
    }

    public void setVerifyVideoStatus(String verifyVideoStatus) {
        this.verifyVideoStatus = verifyVideoStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCashadvanceId() {
        return cashadvanceId;
    }

    public void setCashadvanceId(String cashadvanceId) {
        this.cashadvanceId = cashadvanceId;
    }

    public Double getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(Double amountRequested) {
        this.amountRequested = amountRequested;
    }

    public String getIsAmountLocked() {
        return isAmountLocked;
    }

    public void setIsAmountLocked(String isAmountLocked) {
        this.isAmountLocked = isAmountLocked;
    }

    public String getCashadvanceStatus() {
        return cashadvanceStatus;
    }

    public void setCashadvanceStatus(String cashadvanceStatus) {
        this.cashadvanceStatus = cashadvanceStatus;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getIsComputingAmount() {
        return isComputingAmount;
    }

    public void setIsComputingAmount(String isComputingAmount) {
        this.isComputingAmount = isComputingAmount;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getIsDocumentLocked() {
        return isDocumentLocked;
    }

    public void setIsDocumentLocked(String isDocumentLocked) {
        this.isDocumentLocked = isDocumentLocked;
    }

    public List<Map> getProgress() {
        return progress;
    }

    public void setProgress(List<Map> progress) {
        this.progress = progress;
    }

    public List<Map> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Map> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "ApplicationModel{" +
                "creditReportStatus='" + creditReportStatus + '\'' +
                ", isJxlValid='" + isJxlValid + '\'' +
                ", isCreditNeedMove='" + isCreditNeedMove + '\'' +
                ", status='" + status + '\'' +
                ", statusDetail='" + statusDetail + '\'' +
                ", appStatus='" + appStatus + '\'' +
                ", leadStatus='" + leadStatus + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", objectId='" + objectId + '\'' +
                ", cashadvanceId='" + cashadvanceId + '\'' +
                ", cashadvanceStatus='" + cashadvanceStatus + '\'' +
                ", isComputingAmount='" + isComputingAmount + '\'' +
                ", amountRequested=" + amountRequested +
                ", requestAmount=" + requestAmount +
                ", isAmountLocked='" + isAmountLocked + '\'' +
                ", creditId='" + creditId + '\'' +
                ", isEnabled='" + isEnabled + '\'' +
                ", isDocumentLocked='" + isDocumentLocked + '\'' +
                ", progress=" + progress +
                ", coupons=" + coupons +
                ", verifyVideoStatus='" + verifyVideoStatus + '\'' +
                ", isWithdrawConfirm='" + isWithdrawConfirm + '\'' +
                ", type='" + type + '\'' +
                ", directDebitBankName='" + directDebitBankName + '\'' +
                ", directDebitBankCode='" + directDebitBankCode + '\'' +
                ", directDebitAcctName='" + directDebitAcctName + '\'' +
                ", directDebitAcctNo='" + directDebitAcctNo + '\'' +
                ", directDebitAcctId='" + directDebitAcctId + '\'' +
                ", directDebitAcctPhone='" + directDebitAcctPhone + '\'' +
                ", secondaryBankAccountType='" + secondaryBankAccountType + '\'' +
                ", secondaryBankAcctName='" + secondaryBankAcctName + '\'' +
                ", secondaryBankABA='" + secondaryBankABA + '\'' +
                ", secondaryBankName='" + secondaryBankName + '\'' +
                ", secondaryBankDDA='" + secondaryBankDDA + '\'' +
                ", bankAcctName='" + bankAcctName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", blackBox='" + blackBox + '\'' +
                ", mobilePhoneVerifyCode='" + mobilePhoneVerifyCode + '\'' +
                ", isSubmitApplication='" + isSubmitApplication + '\'' +
                '}';
    }
}
