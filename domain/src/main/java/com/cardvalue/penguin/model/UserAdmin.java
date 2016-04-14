package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by guojia.chen on 2015-12-30 13:19.
 *
 * @Description:
 */
@Entity
@Table(name = "user_admin")
public class UserAdmin {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "create_date")
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
