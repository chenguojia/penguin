package com.cardvalue.penguin.service;

import com.cardvalue.penguin.dto.WeMenu;
import com.cardvalue.penguin.util.Result;

/**
 * Created by guojia.chen on 2015-12-29 16:22.
 *
 * @Description:
 */
public interface WeChatService {

    public String getOpenIdByAccessToken(String code);

    Result<?> listGroups();

    public String getAccessToken();

    Result<?> moveUserToGroup(String openId, int groupId);

    public void createMenu(WeMenu menu);

    public void pushMessage(String openId, String content);

    public String getTicket();
}
