package com.cardvalue.penguin.service;

import java.util.List;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-13 18:47.
 *
 * @Description: 各种下拉列表选项
 */

public interface AllKindSelectService {

    /**
     * 查询拟融资期限
     * @return
     */
    public List<Map<String, String>> getPlanFundTerm();
}
