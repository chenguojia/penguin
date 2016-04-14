package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.dto.WeGroup;
import com.cardvalue.penguin.model.Parameter;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.ParamRepository;
import com.cardvalue.penguin.repository.UserRepository;
import com.cardvalue.penguin.service.AdminService;
import com.cardvalue.penguin.service.WeChatService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by guojia.chen on 2015-12-30 13:49.
 *
 * @Description:
 */
@Service
public class AdminServiceImpl implements AdminService {


    private final static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Resource
    private WeChatService weService;

    @Resource
    private ParamRepository paramRepo;

    @Resource
    private UserRepository userRepo;

    public void weGroupMove(int userId) {

        WeUser user = userRepo.findOne(userId);
        Result<?> result = weService.listGroups();
        if (StringUtils.equals(result.getCode(), Constants.RESULT_CODE_SUCCESS)) {
            List<WeGroup> groups = (List<WeGroup>) result.getPayload();
            int type = user.getType();
            Parameter typeParam = paramRepo.findByGroupAndValue(Constants.PARAM_GROUP_USER_TYPE, String.valueOf(type));
            WeGroup group = findGroup(typeParam.getName(), groups);
            if (group != null) {
                Result<?> moveGroupResponse = weService.moveUserToGroup(user.getOpenId(), group.getId());
                if (moveGroupResponse != null && StringUtils.equals(moveGroupResponse.getCode(), Constants.RESULT_CODE_SUCCESS)) {
                    logger.info("Move user:" + user.getId() + " to group:" + group.getId() + " successful");
                } else {
                    logger.info("Move user:" + user.getId() + " to group:" + group.getId() + " failed");
                }
            }
        } else {
            logger.warn("list we group failed");
        }
    }

    private WeGroup findGroup(String name, List<WeGroup> groups) {
        /**
         * 需求：现微后台将'运营专员'、'内部员工'移动到'银商客户经理'中
         * 实现：判断当前登录人类型，是否是'运营专员'或'内部员工'，如果是则已将其移动到'银商客户经理'分组中
         */
        if (name.equals("运营专员") || name.equals("内部员工")) {
            for (WeGroup group : groups) {
                if (StringUtils.equals("银商客户经理", group.getName())) {
                    return group;
                }
            }
        } else {
            for (WeGroup group : groups) {
                if (StringUtils.equals(name, group.getName())) {
                    return group;
                }
            }
        }
        return null;
    }
}
