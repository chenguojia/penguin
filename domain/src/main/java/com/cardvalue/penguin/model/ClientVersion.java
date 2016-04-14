package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mr tao on 2015/3/12.
 */
@Entity
@Table(name="client_version")
public class ClientVersion implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String type;

    @Column
    private String version;

    @Column
    private String memo;

    @Column(name="create_date")
    private String createDate;

    @Column(name="is_force_update")
    private String isForceUpdate;

    @Column(name="version_code")
    private String versionCode;

    @Transient
    private WelecomeSet welecomeSet;


    @Column
    private String url;

    public WelecomeSet getWelecomeSet() {
        return welecomeSet;
    }

    public void setWelecomeSet(WelecomeSet welecomeSet) {
        this.welecomeSet = welecomeSet;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getIsForceUpdate() {
        return isForceUpdate;
    }

    public void setIsForceUpdate(String isForceUpdate) {
        this.isForceUpdate = isForceUpdate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
