package com.cardvalue.penguin.model;

import org.codehaus.jackson.map.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojia.chen on 2015-12-29 16:55.
 *
 * @Description:
 */

@Entity
@Table(name="action_log")
public class ActionLog implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="open_id")
    private String openId;

    private int action;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="call_class_name")
    private String callClassName;

    @Column(name="call_method")
    private String callMethod;

    @Column(name="call_method_params")
    private String callMethodParams;

    @Column(name="call_method_result")
    private String callMethodResult;

    private String memo;

    @Column
    private String ip;

    @Column
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public ActionLog(int actionRestful, Date date, String name, String queryCouponByUserNames, HashMap hashMap, String s){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCallClassName() {
        return callClassName;
    }

    public void setCallClassName(String callClassName) {
        this.callClassName = callClassName;
    }

    public String getCallMethod() {
        return callMethod;
    }

    public void setCallMethod(String callMethod) {
        this.callMethod = callMethod;
    }

    public String getCallMethodParams() {
        return callMethodParams;
    }

    public void setCallMethodParams(String callMethodParams) {
        this.callMethodParams = callMethodParams;
    }

    public String getCallMethodResult() {
        return callMethodResult;
    }

    public void setCallMethodResult(String callMethodResult) {
        this.callMethodResult = callMethodResult;
    }

    public ActionLog(){

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ActionLog(int action, Date createDate, String callClassName, String callMethod, Map callMethodParams, String callMethodResult, String memo) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.action = action;
            this.createDate = createDate;
            this.callClassName = callClassName;
            this.callMethod = callMethod;
            this.callMethodParams = objectMapper.writeValueAsString(callMethodParams); //参数转为json格式储存
            this.callMethodResult = callMethodResult;
            this.memo = memo;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}