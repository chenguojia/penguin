package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.UserAdmin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by guojia.chen on 2015-12-30 13:33.
 *
 * @Description:
 */
@Repository(value = "userAdminRepository")
public interface UserAdminRepository extends CrudRepository<UserAdmin,Integer> {
    public UserAdmin findByUserId(Integer userId);
}
