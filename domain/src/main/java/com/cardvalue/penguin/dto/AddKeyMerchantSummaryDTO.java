package com.cardvalue.penguin.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by guojia.chen on 2015-12-30 14:17.
 *
 * @Description:
 */
@Entity
public class AddKeyMerchantSummaryDTO {

    @Id
    private int id;

    private String branch;

    @Column(name="merchant_count")
    private int merchantCount;

    @Column(name="active_suceess_count")
    private int activeSuccessMerchantCount;

    @Column(name="active_failed_count")
    private int activeFailedMerchantCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getMerchantCount() {
        return merchantCount;
    }

    public void setMerchantCount(int merchantCount) {
        this.merchantCount = merchantCount;
    }

    public int getActiveSuccessMerchantCount() {
        return activeSuccessMerchantCount;
    }

    public void setActiveSuccessMerchantCount(int activeSuccessMerchantCount) {
        this.activeSuccessMerchantCount = activeSuccessMerchantCount;
    }

    public int getActiveFailedMerchantCount() {
        return activeFailedMerchantCount;
    }

    public void setActiveFailedMerchantCount(int activeFailedMerchantCount) {
        this.activeFailedMerchantCount = activeFailedMerchantCount;
    }

}
