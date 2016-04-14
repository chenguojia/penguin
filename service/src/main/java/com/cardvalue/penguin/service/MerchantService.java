package com.cardvalue.penguin.service;

import com.cardvalue.penguin.dto.MerchantRegisterDTO;
import com.cardvalue.penguin.model.Sales;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.util.Result;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guojia.chen on 2015-12-31 14:11.
 *
 * @Description:
 */
public interface MerchantService {

    /**
     * 根据保理id 查询对账单明细
     * 小企额1.3对账单
     * @param baoliId 商户的保理id
     * @return
     */
    public List<HashMap<String, String>> bankStatementLists(String baoliId);

    /**
     * 认证新增商户
     * @param dto
     * @param s
     * @return
     */
    public Result<?> createMerchant(MerchantRegisterDTO dto, Sales s,WeUser user,HttpSession session);

    /**
     * 小企额2.0对账单
     * @param applicationId 商户id
     * @param skip 从多少条开始
     * @param limit 每次返回的条数(默认20条)
     * @return
     */
    public Map getStatementLists(String applicationId,String skip,String limit);

}
