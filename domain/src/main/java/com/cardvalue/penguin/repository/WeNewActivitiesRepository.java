package com.cardvalue.penguin.repository;


import com.cardvalue.penguin.model.WeNewActivities;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mr tao on 2015/2/9.
 */
public interface WeNewActivitiesRepository extends CrudRepository<WeNewActivities, Integer> {
    public WeNewActivities findByUserType(Integer userType);
}
