package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mr tao on 2015/2/9.
 */
@Entity
@Table(name="we_new_activities")
public class WeNewActivities implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="user_type")
    private Integer userType;

    @Column(name="response_id")
    private Integer responseId;

    @Column(name="response_type")
    private String responseType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
