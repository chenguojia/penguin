package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by guojia.chen on 2015-12-30 14:03.
 *
 * @Description:
 */
public interface ParamRepository extends JpaRepository<Parameter, Integer> {

    @Query("from Parameter p where p.group=:group and p.status=1 order by order,id")
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    public List<Parameter> findByGroup(@Param("group") String group);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    public Parameter findByGroupAndValue(String group, String value);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    public Parameter findByGroupAndName(String group, String name);
}
