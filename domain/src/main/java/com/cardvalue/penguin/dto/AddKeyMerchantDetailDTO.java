package com.cardvalue.penguin.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by guojia.chen on 2015-12-30 14:18.
 *
 * @Description:
 */
@Entity
public class AddKeyMerchantDetailDTO {

    @Id
    private int id;

    @Column(name="branch")
    private String province;

    private String mid;

    @Column(name="merchant_name")
    private String merchantName;

    @Column(name="sales_username")
    private String salesUsername;

    @Column(name="sales_name")
    private String salesName;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="update_date")
    private Date updateDate;

    private String verifier;

    @Column(name="active_status_label")
    private String activeStatusLabel;

    @Column(name="active_status_memo")
    private String activeStatusMemo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getSalesUsername() {
        return salesUsername;
    }

    public void setSalesUsername(String salesUsername) {
        this.salesUsername = salesUsername;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public String getActiveStatusLabel() {
        return activeStatusLabel;
    }

    public void setActiveStatusLabel(String activeStatusLabel) {
        this.activeStatusLabel = activeStatusLabel;
    }

    public String getActiveStatusMemo() {
        return activeStatusMemo;
    }

    public void setActiveStatusMemo(String activeStatusMemo) {
        this.activeStatusMemo = activeStatusMemo;
    }

}
