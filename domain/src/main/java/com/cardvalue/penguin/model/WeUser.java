package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by guojia.chen on 2015-12-30 11:53.
 *
 * @Description:
 */
@Entity
@Table(name="user")
@NamedNativeQueries({
        @NamedNativeQuery(name="getUsername", query="SELECT CAST(max(username)+1 AS char) FROM user WHERE type=:type")
})
public class WeUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column(name="we_id")
    private String weId;

    @Column(length=2)
    private int type;

    @Column(name="open_id",length=28)
    private String openId;

    @Column(length=10)
    private String username;

    @Column
    private String password;

    @Column(name="last_login")
    private Date lastLogin;

    @Column
    private boolean enabled;

    @Column(length=37)
    private String token;

    @Column(name="referrer_id")
    private int referrerId;

    @Column
    private int source;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column(name="processor_id")
    private String processorId;

    @Transient
    private Sales sales;

    @Transient
    private Merchant merchant;

    @Transient
    private UserInfo userInfo;

    public WeUser() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getOpenId() {
        return openId;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public int getReferrerId() {
        return referrerId;
    }
    public void setReferrerId(int referrerId) {
        this.referrerId = referrerId;
    }
    public int getSource() {
        return source;
    }
    public void setSource(int source) {
        this.source = source;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public String getProcessorId() {
        return processorId;
    }
    public void setProcessorId(String processorId) {
        this.processorId = processorId;
    }
    public String getWeId() {
        return weId;
    }
    public void setWeId(String weId) {
        this.weId = weId;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
