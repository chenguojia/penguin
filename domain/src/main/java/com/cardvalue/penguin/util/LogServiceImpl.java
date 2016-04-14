package com.cardvalue.penguin.util;

import com.cardvalue.penguin.model.ActionLog;
import com.cardvalue.penguin.repository.ActionLogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by guojia.chen on 2015-12-30 14:52.
 *
 * @Description:
 */
@Service
public class LogServiceImpl implements LogService{

    @Resource
    private ActionLogRepository actionLogRepository;

    @Override
    public ActionLog insertActionLog(int action, Integer userId, String openId, String memo) {
        ActionLog log = new ActionLog();
        log.setAction(action);
        log.setUserId(userId);
        log.setOpenId(openId);
        log.setMemo(memo);
        log.setCreateDate(new Date());
        log = actionLogRepository.save(log);
        return log;
    }

}
