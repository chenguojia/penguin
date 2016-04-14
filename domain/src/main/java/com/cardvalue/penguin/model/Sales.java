package com.cardvalue.penguin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.Utility;

/**
 * Created by guojia.chen on 2015-12-30 11:54.
 *
 * @Description:
 */
@Entity
@Table
@NamedNativeQueries({
        @NamedNativeQuery(name="findSalesByMobile", query="SELECT count(*) FROM sales WHERE mobile=:mobile"),
        @NamedNativeQuery(name="findIntroducedAndLoggedSalesCount", query="select count(*) from sales s left join user u "
                + "on s.user_id=u.id where u.last_login is not null and u.referrer_id=:referrerId")
})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column(length=2)
    private int type;

    @Column(name="bank_card_number", length=18)
    private String bankCardNumber;

    @Column(length=20)
    private String bank;

    @Column(name="id_number", length=18)
    private String idNumber;

    @Column(length=14)
    private String mobile;

    @Column(name="user_id")
    private int userId;

    @Column(length=10)
    private String name;

    @Column(length=30)
    private String email;

    @Column(name="branch_code", length=4)
    private String branchCode;

    @Column(name="region_code", length=4)
    private String regionCode;

    public Sales(){}

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

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public String getBankCardNumberLabel() {
        if(StringUtils.length(bankCardNumber) > 5){
            return Utility.mask(bankCardNumber,Constants.DEFAULT_MASK_STAR, 4, bankCardNumber.length()-4);
        }else{
            return "";
        }
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getIdNumberLabel() {
        if(StringUtils.length(idNumber) == 18){
            return Utility.mask(idNumber, Constants.DEFAULT_MASK_STAR, 6, 14);
        }else if(StringUtils.length(idNumber) == 15){
            return Utility.mask(idNumber, Constants.DEFAULT_MASK_STAR, 6, 11);
        }else{
            return "";
        }
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMobileLabel() {
        if(StringUtils.length(mobile) == 11){
            return Utility.mask(mobile, Constants.DEFAULT_MASK_STAR, 3, 7);
        }else{
            return "";
        }
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}