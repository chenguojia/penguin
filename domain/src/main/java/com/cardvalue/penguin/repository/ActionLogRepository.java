package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.ActionLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guojia.chen on 2015-12-29 16:57.
 *
 * @Description: 记录日志 公用类
 */
@Repository
public interface ActionLogRepository extends CrudRepository<ActionLog, Long> {
    public List<ActionLog> findByActionAndOpenId(int action,String openId);
}