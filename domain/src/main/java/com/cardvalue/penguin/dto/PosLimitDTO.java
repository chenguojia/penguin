package com.cardvalue.penguin.dto;

/**
 * Created by guojia.chen on 2015-12-31 13:26.
 *
 * @Description:
 */
public class PosLimitDTO {

    private String creditId;//授信id，后台赋值

    private String mids;

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getMids() {
        return mids;
    }

    public void setMids(String mids) {
        this.mids = mids;
    }

}
