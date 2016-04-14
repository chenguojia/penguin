package com.cardvalue.penguin.model;

/**
 * Created by guojia.chen on 2015-12-29 16:39.
 *
 * @Description:
 */
public class CreditsTaskModel {

    private String totalCreditLine;
    private String waitSeconds;
    private String resCode;
    private String resMsg;
    private String creditStatus;
    private String invalidDate;//(过渡时间)字段
    private String lastUpdateTime;//
    private String paymentMethod;// 还款方式
    private String loanPeriod;//参考融资期限
    private String paymentMethodId;//还款方式

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(String invalidDate) {
        this.invalidDate = invalidDate;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    public String getTotalCreditLine() {
        return totalCreditLine;
    }

    public void setTotalCreditLine(String totalCreditLine) {
        this.totalCreditLine = totalCreditLine;
    }

    public String getWaitSeconds() {
        return waitSeconds;
    }

    public void setWaitSeconds(String waitSeconds) {
        this.waitSeconds = waitSeconds;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}
