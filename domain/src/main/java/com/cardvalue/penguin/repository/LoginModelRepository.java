package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.LoginModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by guojia.chen on 2016-01-25 21:05.
 *
 * @Description:
 */
public interface LoginModelRepository extends CrudRepository<LoginModel,Long> {

    public LoginModel findLoginModelByMobile(String mobile);
}
