package com.cardvalue.penguin.util;

import com.cardvalue.penguin.model.ActionLog;

/**
 * Created by guojia.chen on 2015-12-30 14:51.
 *
 * @Description:
 */
public interface LogService {

    public ActionLog insertActionLog(int action, Integer userId, String openId, String memo);
}
