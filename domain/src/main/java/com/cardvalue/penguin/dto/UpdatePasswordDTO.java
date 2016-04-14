package com.cardvalue.penguin.dto;

/**
 * Created by guojia.chen on 2015-12-31 13:25.
 *
 * @Description:
 */
public class UpdatePasswordDTO {
    private String merchantId;//后台设置
    private String oldPassword;
    private String newPassword;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}