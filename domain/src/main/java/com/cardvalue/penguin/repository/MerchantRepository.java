package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.Merchant;
import com.cardvalue.penguin.model.WeUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by guojia.chen on 2015-12-30 15:00.
 *
 * @Description:
 */
@Repository("merchantRepository")
public interface MerchantRepository extends CrudRepository<Merchant, Integer>, MerchantRepositoryCustom{
    public Merchant findByUser(WeUser user);

    public Merchant findByContactMobile(String contactMobile);

    @Query(value="SELECT * FROM merchant m "
            + "LEFT JOIN USER u1 ON m.user_id=u1.id "
            + "LEFT JOIN USER u2 ON u1.referrer_id=u2.id WHERE u2.id=:referrerId", nativeQuery=true)
    public List<Merchant> findByReferrerId(@Param("referrerId") int referrerId);

    public List<Merchant> findByMid(String mid);

    @Query(value="SELECT count(*) FROM merchant m where m.active_status=2", nativeQuery=true)
    public BigInteger getTotalActiveMerchantCount();

    @Query(value="SELECT max(adjust_active_sequence) FROM merchant m", nativeQuery=true)
    public Integer getMaxAdjustActiveSequence();

    @Query(value="SELECT count(*) FROM merchant m left join user u on m.user_id=u.id where m.active_status=2 and u.referrer_id=:userId", nativeQuery=true)
    public BigInteger getUserActiveMerchantCount(@Param("userId") int userId);

    @Query(value="SELECT * FROM merchant m where m.active_status=1 and DATE(create_date)=:dateStr", nativeQuery=true)
    public List<Merchant> getUnactivatedMerchants(@Param("dateStr") String dateStr);
}
