package com.cardvalue.penguin.repository.jpa;


import com.cardvalue.penguin.dto.MerchantCredit;
import com.cardvalue.penguin.repository.MerchantCreditRepositoryCustom;
import com.cardvalue.penguin.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional(readOnly=true)
public class MerchantCreditRepositoryImpl
  implements MerchantCreditRepositoryCustom
{
  private static final Logger logger = LoggerFactory.getLogger(MerchantCreditRepositoryImpl.class);
  @PersistenceContext
  private EntityManager em;
  @Resource
  private UserRepository userRepo;
  
  public MerchantCredit findByMid(String number, String processorId)
  {
    logger.info("Find merchant credit with number:" + number + " and processorId:" + processorId);
    String ql = "SELECT * FROM merchant_credit mc WHERE mc.mid=:number";
    if ((processorId != null) && (!StringUtils.equals(processorId, "331"))) {
      ql = ql + " AND processor_id=:processorId";
    }
    Query query = this.em.createNativeQuery(ql, MerchantCredit.class);
    query.setParameter("number", number);
    if ((processorId != null) && (!StringUtils.equals(processorId, "331"))) {
      query.setParameter("processorId", processorId);
    }
    MerchantCredit credit = null;
    try
    {
      credit = (MerchantCredit)query.getSingleResult();
    }
    catch (Exception e)
    {
      logger.warn("Cannot find credit with mid:" + number +  ",exception:"  + e.toString());
    }
    return credit;
  }
}
