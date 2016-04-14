package com.cardvalue.penguin.model;

/**
 * Created by Mr tao on 2015/6/2.
 */
public class CashadvancesModel {

    private String status;
    private String mid;
    private String businessName;
    private String amountRequested;
    private String serviceType;
    private String prodTitle;
    private String cashadvStatusChangeTime;
    private String updatedAt;
    private String createdAt;
    private String objectId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(String amountRequested) {
        this.amountRequested = amountRequested;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getProdTitle() {
        return prodTitle;
    }

    public void setProdTitle(String prodTitle) {
        this.prodTitle = prodTitle;
    }

    public String getCashadvStatusChangeTime() {
        return cashadvStatusChangeTime;
    }

    public void setCashadvStatusChangeTime(String cashadvStatusChangeTime) {
        this.cashadvStatusChangeTime = cashadvStatusChangeTime;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
