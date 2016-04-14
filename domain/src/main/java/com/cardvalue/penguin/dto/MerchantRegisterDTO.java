package com.cardvalue.penguin.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;

/**
 * Created by guojia.chen on 2015-12-30 14:16.
 *
 * @Description:
 */
public class MerchantRegisterDTO {

    private String mid;

    private String contactName;

    private String contactMobile;

    private String merchantName;

    private String checkCode;

    private int referrerId;

    private String openId;

    private long linkId;

    private String address;

    private boolean requireCheck;

    @NotNull
    private int contactPosition;

    private String agreeClause;//同意条款

    private String processorId;//用户关联银行类型

    /**
     * 授信需要用到的参数
     */
    private String loanAmount;//申请额度

    private String paybackPeriod;//还款周期

    /**
     * 以下属性为新版注册需要用到的属性
     */
    private String name;

    private Integer provinceId;

    private Integer regionId;

    private String mobile;

    private String email;

    private String password;

    private String passwordAgain;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public int getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(int referrerId) {
        this.referrerId = referrerId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setRegionId(int cityId) {
        this.regionId = cityId;
    }

    public int getContactPosition() {
        return contactPosition;
    }

    public void setContactPosition(int contactPosition) {
        this.contactPosition = contactPosition;
    }

    public long getLinkId() {
        return linkId;
    }

    public void setLinkId(long linkId) {
        this.linkId = linkId;
    }

    public String toString() {
        return new ToStringBuilder(this).
                append("mid", mid).
                append("merchant name", merchantName).
                append("contact name", contactName).
                append("contact mobile", contactMobile).
                append("referrer id", referrerId).
                toString();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getPaybackPeriod() {
        return paybackPeriod;
    }

    public void setPaybackPeriod(String paybackPeriod) {
        this.paybackPeriod = paybackPeriod;
    }

    public String getAgreeClause() {
        return agreeClause;
    }

    public void setAgreeClause(String agreeClause) {
        this.agreeClause = agreeClause;
    }

    public String getProcessorId() {
        return processorId;
    }

    public void setProcessorId(String processorId) {
        this.processorId = processorId;
    }

    public boolean isRequireCheck() {
        return requireCheck;
    }

    public void setRequireCheck(boolean requireCheck) {
        this.requireCheck = requireCheck;
    }

}
