package com.cardvalue.penguin.util;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by guojia.chen on 2015-12-30 13:51.
 *
 * @Description:
 */
public class Result<T> {

    private String code;

    private String message;

    @JsonProperty("result")
    private T payload;

    private Object returnObj;//返回存储对象

    private String returnStatus;//调用授信接口返回的状态码

    public Result(){
        this.code = Constants.RESULT_CODE_SUCCESS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T data) {
        this.payload = data;
    }

    public Object getReturnObj() {
        return returnObj;
    }

    public void setReturnObj(Object returnObj) {
        this.returnObj = returnObj;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

}