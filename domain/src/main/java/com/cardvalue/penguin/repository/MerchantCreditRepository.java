package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.dto.MerchantCredit;
import org.springframework.data.repository.CrudRepository;

public interface MerchantCreditRepository extends CrudRepository<MerchantCredit, Long>, MerchantCreditRepositoryCustom{
	
    
}
