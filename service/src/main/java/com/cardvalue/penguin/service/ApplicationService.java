package com.cardvalue.penguin.service;

import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-25 19:00.
 *
 * @Description:
 */
public interface ApplicationService {


    /**
     * sure 1:确认提交 0：返回修改
     * @param merchantId
     * @param sure
     * @return
     */
    public Map confirm(String merchantId,String sure);
}
