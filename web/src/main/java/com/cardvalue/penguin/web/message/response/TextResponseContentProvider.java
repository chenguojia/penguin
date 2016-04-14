package com.cardvalue.penguin.web.message.response;

import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.model.MessageContent;
import com.cardvalue.penguin.model.TextMessageContent;
import com.cardvalue.penguin.web.message.ResponseContentProvider;

public class TextResponseContentProvider implements ResponseContentProvider {

	@Override
	public void fillContent(WeChatMessage respMessage, MessageContent messageContent,String content) {
		TextMessageContent textContent = (TextMessageContent)messageContent;
		respMessage.setContent(textContent.getContent());
	}

}
