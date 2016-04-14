package com.cardvalue.penguin.web.message;


import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.model.MessageContent;

public interface ResponseContentProvider {
	
	public void fillContent(WeChatMessage respMessage, MessageContent messageContent, String content);
	
}
