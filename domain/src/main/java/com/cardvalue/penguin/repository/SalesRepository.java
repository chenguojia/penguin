package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.Sales;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by guojia.chen on 2015-12-30 14:13.
 *
 * @Description:
 */
public interface SalesRepository extends CrudRepository<Sales, Integer>, SalesRepositoryCustom {

    public Sales findByUserId(int userId);
}
