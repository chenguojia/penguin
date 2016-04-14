package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.WeUser;

/**
 * Created by guojia.chen on 2015-12-30 13:42.
 *
 * @Description:
 */
public interface UserRepositoryCustom {

    /**
     * 创建用户
     * @param type 用户类型
     * @param username 用户名
     * @param password 密码
     * @param referrerId 推荐人
     * @param source 用户创建方式:  系统创建 / 其他用户创建 / 扫描 二维码 / 用户自添加
     * @param openId
     * @param enabled 是否启用账户
     * @param processorId 用户编码
     * @return
     */
    public WeUser createUser(int type, String username, String password, int referrerId, int source, String openId, boolean enabled, String processorId);

}