package com.cardvalue.penguin.service;

import com.cardvalue.penguin.model.ApplicationModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-20 16:24.
 *
 * @Description:
 */
public interface InfomationService {

    public Map queryInfo(String type,String skip,String limit);

    public Map queryInfoDetail(String infoId,String type);

    public String deleteInfo(String infoId,String type);

    public Map bindBank(HttpServletRequest request,ApplicationModel applicationModel);

}
