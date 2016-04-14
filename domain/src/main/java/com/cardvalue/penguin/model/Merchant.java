package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by guojia.chen on 2015-12-30 13:21.
 *
 * @Description:
 */
@Entity
@Table
@NamedQueries({ @NamedQuery(name="countMerchantByMidOrMobile", query="select count(m) from Merchant m where m.mid=:mid or m.contactMobile=:mobile")})
public class Merchant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String mid;

    @Column
    private String name;

    @Column(name="contact_name")
    private String contactName;

    @Column(name="contact_mobile")
    private String contactMobile;

    @Column(name="contact_position")
    private int contactPosition;

    @Transient
    private String contactPositionLabel;

    @ManyToOne(optional = true)
    @JoinColumn(name="user_id")
    private WeUser user;

    @Column(name="branch_code")
    private String branchCode;

    @Column(name="region_code")
    private String regionCode;

    @Column(name="active_status")
    private int activeStatus;

    @Column(name="active_status_label")
    private String activeStatusLabel;

    @Column(name="active_status_memo")
    private String activeStatusMemo;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="update_date")
    private Date updateDate;

    @Column(name="active_sequence")
    private long activeSequence;

    //为了营销手段进行调整后的激活序列号
    @Column(name="adjust_active_sequence")
    private long adjustActiveSequence;

    @Column(name="authorization_flag")
    private boolean authorizationFlag;

    @Column
    private String address;

    private String verifier;

    private String branch;

    private String prefecture;

    @Column(name="other_mid")
    private String otherMid;

    @Column
    private String appid;//速融返回接口

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public WeUser getUser() {
        return user;
    }

    public void setUser(WeUser user) {
        this.user = user;
    }

    public int getContactPosition() {
        return contactPosition;
    }

    public void setContactPosition(int contactPosition) {
        this.contactPosition = contactPosition;
    }

    public String getContactPositionLabel() {
        return contactPositionLabel;
    }

    public void setContactPositionLabel(String contactPositionLabel) {
        this.contactPositionLabel = contactPositionLabel;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int status) {
        this.activeStatus = status;
    }

    public String getActiveStatusMemo() {
        return activeStatusMemo;
    }

    public void setActiveStatusMemo(String statusLabel) {
        this.activeStatusMemo = statusLabel;
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

    public long getActiveSequence() {
        return activeSequence;
    }

    public void setActiveSequence(long activeSequence) {
        this.activeSequence = activeSequence;
    }

    public String getActiveStatusLabel() {
        return activeStatusLabel;
    }

    public void setActiveStatusLabel(String activeStatusLabel) {
        this.activeStatusLabel = activeStatusLabel;
    }

    public boolean isAuthorizationFlag() {
        return authorizationFlag;
    }

    public void setAuthorizationFlag(boolean authorizationFlag) {
        this.authorizationFlag = authorizationFlag;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public long getAdjustActiveSequence() {
        return adjustActiveSequence;
    }

    public void setAdjustActiveSequence(long adjustActiveSequence) {
        this.adjustActiveSequence = adjustActiveSequence;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getOtherMid() {
        return otherMid;
    }

    public void setOtherMid(String otherMid) {
        this.otherMid = otherMid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public Merchant(String mid, String contactName, String contactMobile) {
        super();
        this.mid = mid;
        this.contactName = contactName;
        this.contactMobile = contactMobile;
    }

    public Merchant() {
        super();
    }

}
