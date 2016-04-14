package com.cardvalue.penguin.web.message.handler;


import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.UserRepository;
import com.cardvalue.penguin.web.message.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class UnsubscribeMessageHandler extends MessageHandler {

	private final static Logger logger = LoggerFactory.getLogger(UnsubscribeMessageHandler.class);
	
	@Resource
	private UserRepository userRepo;
	
	@Override
	public String handle(WeChatMessage message) {
		logger.info("Start handle unsubscribe...");
		String openId = message.getFromUserName();
		WeUser user = userRepo.findByOpenId(openId);
		if(user != null){
			user.setOpenId(null);
			userRepo.save(user);
		}
		logger.info("Complete handle unsubscribe.");
		return null;
	}

}
