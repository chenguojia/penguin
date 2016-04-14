package com.cardvalue.penguin.repository.jpa;

import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.UserRepositoryCustom;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by guojia.chen on 2015-12-30 13:43.
 *
 * @Description:
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final static Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

//    @Override
    public WeUser createUser(int type, String username, String password, int referrerId, int source, String openId, boolean enabled, String processorId) {
        WeUser user = new WeUser();
        if(StringUtils.isBlank(username)){
            Query getUsernameQuery = em.createNamedQuery("getUsername")
                    .setParameter("type", "1").setLockMode(LockModeType.PESSIMISTIC_READ);
            username = (String)getUsernameQuery.getSingleResult();
        }
        user.setUsername(username);
        if(StringUtils.isBlank(password)){
            password = RandomStringUtils.randomNumeric(6);
        }
        user.setPassword(password);
        user.setType(type);
        user.setEnabled(enabled);
        user.setReferrerId(referrerId);
        user.setSource(source);//用户添加来源
        user.setOpenId(openId);
        user.setProcessorId(processorId);
        em.persist(user);
        logger.info("create user[username:" + username + "]");
        return user;
    }

}
