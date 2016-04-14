package com.cardvalue.penguin.web.message.handler;



import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.web.message.MessageHandler;

import java.io.IOException;

public class ImageMessageHandler extends MessageHandler {

	@Override
	public String handle(WeChatMessage message) throws IOException {
		String respXml = matchImage(message);
		return respXml;
	}
}
