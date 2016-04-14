package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.WelecomeSet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guojia.chen on 2015-11-10 10:11.
 *
 * @Description:
 */
@Repository
public interface WelecomeSetRepository extends CrudRepository<WelecomeSet,Integer> {

    public List<WelecomeSet> findWelecomeSetByStatus(String status);

}

