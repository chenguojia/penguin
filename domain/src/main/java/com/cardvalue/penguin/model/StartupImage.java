package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by guojia.chen on 2015-12-30 15:43.
 *
 * @Description:
 */
@Entity
@Table(name="startup_image")
@NamedNativeQuery(name="findAvailStartupImage", query="select id, image_url from startup_image where begin_date<=curdate() and end_date>=curdate()")
public class StartupImage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column(name="begin_date")
    private Date beginDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="image_url")
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
