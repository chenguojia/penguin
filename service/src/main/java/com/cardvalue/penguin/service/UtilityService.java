package com.cardvalue.penguin.service;

/**
 * Created by guojia.chen on 2015-12-29 16:52.
 *
 * @Description:
 */
public interface UtilityService {

    /**
     * 外部调用微信接口出错通知邮件
     *
     * @param businessObj 需要在邮件中现实详情的对象
     */
    public void sendMailForException(Object businessObj);

}
