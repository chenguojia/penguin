package com.cardvalue.penguin.service;

import com.cardvalue.penguin.dto.UserRegisterDTO;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.util.Result;
import org.springframework.dao.DataAccessException;

import javax.servlet.http.HttpSession;

/**
 * Created by guojia.chen on 2015-12-30 11:52.
 *
 * @Description:
 */
public interface UserService {

    public WeUser findByUsername(String username) throws DataAccessException;

    public WeUser bind(String username, String openId) throws DataAccessException;

    public void afterLogin(WeUser user, HttpSession session) throws DataAccessException;

    public WeUser findByOpenId(String openId) throws DataAccessException;

    /**
     * 注册创建用户
     * @param dto
     * @return
     */
    public Result<?> createUser(UserRegisterDTO dto,HttpSession session) throws Exception;
}
