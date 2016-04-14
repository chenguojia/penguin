package com.cardvalue.penguin.web.message;

import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.web.message.handler.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MessageHandlers {
	
	@Resource
	private AutowireCapableBeanFactory autowireBeanFactory;
	
	public MessageHandler getMessageHandler(WeChatMessage message) throws Exception{
		String type = message.getMsgType();
		MessageHandler handler = null;
		if(StringUtils.equals(Constants.WE_MESSAGE_TYPE_TEXT, type)){
			handler = new TextMessageHandler();
		}else if(StringUtils.equals(Constants.WE_MESSAGE_TYPE_IMAGE, type)){
			handler = new ImageMessageHandler();
		}else if(StringUtils.equals(Constants.WE_MESSAGE_TYPE_EVENT, type)){
			String eventType = message.getEvent();
			if(StringUtils.equalsIgnoreCase(Constants.WE_EVENT_TYPE_SUBSCRIBE, eventType)){
				handler = new SubscribeMessageHandler();
			}else if(StringUtils.equalsIgnoreCase(Constants.WE_EVENT_TYPE_UNSUBSCRIBE, eventType)){
				handler = new UnsubscribeMessageHandler();
			}else if(StringUtils.equalsIgnoreCase(Constants.WE_EVENT_TYPE_SCAN, eventType)){
				handler = new ScanMessageHandler();
			}else if(StringUtils.equalsIgnoreCase(Constants.WE_EVENT_TYPE_CLICK, eventType)){
				handler = new ClickMessageHandler();
			}else if(StringUtils.equalsIgnoreCase(Constants.WE_EVENT_TYPE_LOCATION, eventType)){
				handler = new LocationMessageHandler();
			}else{
				throw new Exception("Unknown WE message type : " + type);
			}
		}else{
			throw new Exception("Unknown WE message type : " + type);
		}
		autowireBeanFactory.autowireBean(handler);
		return handler;
	}
	
}
