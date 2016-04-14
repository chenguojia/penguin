package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guojia.chen on 2015-12-30 15:42.
 *
 * @Description:
 */
@Entity
@Table(name="user_startup_image")
@NamedNativeQuery(name="findUserStartupImageCount", query="select count(*) from user_startup_image where user_id=:userId and image_id=:imageId")
public class UserStartupImage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(optional=false,cascade={CascadeType.ALL})
    @JoinColumn(name="user_id", unique=false)
    private WeUser user;

    @OneToOne(optional=false,cascade={CascadeType.ALL})
    @JoinColumn(name="image_id", unique=false)
    private StartupImage startupImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WeUser getUser() {
        return user;
    }

    public void setUser(WeUser user) {
        this.user = user;
    }

    public StartupImage getStartupImage() {
        return startupImage;
    }

    public void setStartupImage(StartupImage startupImage) {
        this.startupImage = startupImage;
    }

}
