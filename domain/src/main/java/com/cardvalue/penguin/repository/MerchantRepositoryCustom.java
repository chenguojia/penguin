package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.dto.AddKeyMerchantDetailDTO;
import com.cardvalue.penguin.dto.AddKeyMerchantSummaryDTO;
import com.cardvalue.penguin.dto.MerchantRegisterDTO;
import com.cardvalue.penguin.model.Sales;
import com.cardvalue.penguin.model.WeUser;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by guojia.chen on 2015-12-30 14:15.
 *
 * @Description:
 */
public interface MerchantRepositoryCustom {

    public int create(MerchantRegisterDTO dto, Sales sales);

    public void authorize(int merchantId);

    public List<AddKeyMerchantSummaryDTO> listAddKeyMerchantSummary();

    public List<AddKeyMerchantDetailDTO> listAddKeyMerchantDetail();

    /**
     * 只添加商户不添加用户
     * @param dto
     * @param sales
     * @param user
     * @param session
     * @return
     */
    public int create(MerchantRegisterDTO dto, Sales sales,WeUser user,HttpSession session);
}
