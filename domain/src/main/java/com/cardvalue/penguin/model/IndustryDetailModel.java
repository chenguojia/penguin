package com.cardvalue.penguin.model;

/**
 * Created by Mr tao on 2015/6/16.
 */
public class IndustryDetailModel {
    private String id;
    private String title;

    private String jybRestricted;
    private String zzbRestricted;
    private String kybRestricted;

    private String restricted;//是否禁用

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJybRestricted() {
        return jybRestricted;
    }

    public void setJybRestricted(String jybRestricted) {
        this.jybRestricted = jybRestricted;
    }

    public String getZzbRestricted() {
        return zzbRestricted;
    }

    public void setZzbRestricted(String zzbRestricted) {
        this.zzbRestricted = zzbRestricted;
    }

    public String getKybRestricted() {
        return kybRestricted;
    }

    public void setKybRestricted(String kybRestricted) {
        this.kybRestricted = kybRestricted;
    }

    public String getRestricted() {
        return restricted;
    }

    public void setRestricted(String restricted) {
        this.restricted = restricted;
    }
}
