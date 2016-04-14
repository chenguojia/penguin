package com.cardvalue.penguin.model;

/**
 * Created by Mr tao on 2015/6/19.
 */
public class TransactionsModel {

    private String tranAmt;//交易金额
    private String tranDateTime;//交易时间
    private String tranStatus;//交易时间

    public String getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(String tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getTranDateTime() {
        return tranDateTime;
    }

    public void setTranDateTime(String tranDateTime) {
        this.tranDateTime = tranDateTime;
    }

    public String getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }
}
