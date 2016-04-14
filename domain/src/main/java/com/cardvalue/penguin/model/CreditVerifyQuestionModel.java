package com.cardvalue.penguin.model;

/**
 * Created by Mr tao on 2015/6/19.
 */
public class CreditVerifyQuestionModel {
    private String status;//当前POS问题验证的状态，验证成功还是验证失败
    private String leftTryTimes;//授信系统返回的还剩余验证次数

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLeftTryTimes() {
        return leftTryTimes;
    }

    public void setLeftTryTimes(String leftTryTimes) {
        this.leftTryTimes = leftTryTimes;
    }
}
