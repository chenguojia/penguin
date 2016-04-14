package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.WeUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by guojia.chen on 2015-12-30 13:45.
 *
 * @Description:
 */
public interface UserRepository extends CrudRepository<WeUser, Integer>, UserRepositoryCustom{

    public WeUser findByOpenId(String openId);

    public WeUser findByUsername(String username);

    public WeUser findById(int id);

    public WeUser findByUsernameAndPassword(String username,String password);

}
