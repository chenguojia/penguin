package com.cardvalue.penguin.repository;


import com.cardvalue.penguin.dto.MerchantCredit;

public interface MerchantCreditRepositoryCustom {
	
    public MerchantCredit findByMid(String number, String processorId);
    
}
