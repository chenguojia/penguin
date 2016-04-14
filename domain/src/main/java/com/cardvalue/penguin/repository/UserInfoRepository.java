package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by guojia.chen on 2015-12-30 14:11.
 *
 * @Description:
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {

    public UserInfo findByUserId(Integer userId);
}
