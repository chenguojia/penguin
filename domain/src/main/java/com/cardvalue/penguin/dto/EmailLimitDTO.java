package com.cardvalue.penguin.dto;


/**
 * Created by Mr tao on 2015/5/26.
 */
public class EmailLimitDTO {
    private String ownerEmail;
    private String emailVerifyCode;

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getEmailVerifyCode() {
        return emailVerifyCode;
    }

    public void setEmailVerifyCode(String emailVerifyCode) {
        this.emailVerifyCode = emailVerifyCode;
    }
}
