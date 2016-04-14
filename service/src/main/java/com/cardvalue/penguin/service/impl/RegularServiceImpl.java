package com.cardvalue.penguin.service.impl;


import com.cardvalue.penguin.service.RegularService;
import com.cardvalue.penguin.util.HttpUtils;
import org.apache.http.client.methods.HttpGet;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadPoolExecutor;


@Service
public class RegularServiceImpl implements RegularService {



	/**
	 * 等待IOS上线后，访问浏览器，微信中配置的新地址将生效
	 *
	 * 需求：3月14日早上18:00访问微信配置的新路径，此时开始微信版小企额2.0生效
	 * http://www.cvbaoli.com/penguin/we/penguin/menu/create
	 */
	@Scheduled(cron = "0 41 11 7 3 ?")
	public void excavateRankingNotification() {
		//判断此微信的OPENID是否已经绑定过
		String url = "http://www.cvbaoli.com/penguin/we/penguin/menu/create";
//		String url = "http://192.168.3.77:8080/webak/we/penguin/menu/create";
		try {
			String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
