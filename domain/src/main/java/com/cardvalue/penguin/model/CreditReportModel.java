package com.cardvalue.penguin.model;

import java.io.Serializable;

/**
 * Created by guojia.chen on 2015-11-23 14:52.
 *
 * @Description:
 */
public class CreditReportModel implements Serializable {

    private String userName;
    private String passWord;
    private String verityCode;
    private String tradeCode;
    private String sessionId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getVerityCode() {
        return verityCode;
    }

    public void setVerityCode(String verityCode) {
        this.verityCode = verityCode;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
