package com.cardvalue.penguin.dto;

/**
 * Created by guojia.chen on 2015-12-31 9:45.
 *
 * @Description:
 */
public class LoginDTO {
    private String mobile; //手机号
    private String password; //密码
    private Boolean type;//授权标识：1-同意注册条款、5-同意所有条款

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

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}
