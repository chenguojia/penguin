package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guojia.chen on 2015-12-30 14:33.
 *
 * @Description:
 */
@Entity
@Table(name="cv_region_conf")
public class CvRegionConf implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer pid;

    @Column
    private String name;

    @Column(name="region_level")
    private Integer regionLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}