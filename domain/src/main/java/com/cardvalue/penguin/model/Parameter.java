package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guojia.chen on 2015-12-30 14:01.
 *
 * @Description:
 */
@Entity
@Table
@Cacheable
@NamedNativeQueries({@NamedNativeQuery(name="findBranchLabelByCode", query="SELECT label FROM master_branch WHERE code=:code"),
        @NamedNativeQuery(name="findRegionLabelByCode", query="SELECT label FROM master_region WHERE code=:code")})
public class Parameter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column(name="enum", length=50)
    private String group;

    @Column(name="parent")
    private int parent=0;

    @Column
    private String name;

    @Column
    private String value;

    @Column
    private int status;

    @Column(name="param_order")
    private int order;

    @Column(length=300)
    private String memo;

    public Parameter(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}