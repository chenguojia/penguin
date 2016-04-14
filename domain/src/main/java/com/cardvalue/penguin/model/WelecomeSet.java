package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by guojia.chen on 2015-11-10 9:52.
 *
 * @Description:
 */
@Entity
@Table(name="client_welcome_setting")
public class WelecomeSet implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "pic_name")
    private String picName;//图片名称

    @Column
    private String suffix;//图片后缀名
    @Column
    private String status;//图片状态
    @Column(name = "forward_url")
    private String forwordUrl;//点击后跳转的url
    @Column(name = "create_date")
    private Date date;//创建日期
    @Column(name = "forward_type")
    private String forwardType;//跳转类型
    @Column(name = "forward_paramas")
    private String forwardParamas;

    @Column(name = "page_title")
    private String pageTitle;//页面标题

    public String getPageTitle() {
        return pageTitle;
    }
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getForwordUrl() {
        return forwordUrl;
    }

    public void setForwordUrl(String forwordUrl) {
        this.forwordUrl = forwordUrl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getForwardType() {
        return forwardType;
    }

    public void setForwardType(String forwardType) {
        this.forwardType = forwardType;
    }

    public String getForwardParamas() {
        return forwardParamas;
    }

    public void setForwardParamas(String forwardParamas) {
        this.forwardParamas = forwardParamas;
    }
}
