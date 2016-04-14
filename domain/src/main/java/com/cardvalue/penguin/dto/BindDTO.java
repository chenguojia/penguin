package com.cardvalue.penguin.dto;

/**
 * Created by Mr tao on 2015/5/25.
 */
public class BindDTO {
    private String mobile; //手机号
    private String password; //密码
    private String checkCode;//验证码
    private String inviteCode;//邀请码

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
