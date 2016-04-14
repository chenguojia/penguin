package com.cardvalue.penguin.service;

import com.cardvalue.penguin.model.NewMerchantUserModel;
import com.cardvalue.penguin.util.RestfulResult;

import javax.servlet.http.HttpSession;

/**
 * Created by guojia.chen on 2016-01-12 14:03.
 *
 * @Description: 用于各种校验
 *
 */
public interface CheckService {


    /**
     * 校验手机是否已经授权
     * @return
     * @throws Exception
     */
    public String checkMobileAuth(String mobile);

    public RestfulResult checkbizRegisterNo(String bizRegisterNo,String industryCId);

    public RestfulResult queryBakns(String type,String bankName);

    public RestfulResult getMoneyConfrim(NewMerchantUserModel newMerchantUserModel,HttpSession session);

}
