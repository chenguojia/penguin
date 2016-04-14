package com.cardvalue.penguin.web.message.function;

import org.springframework.stereotype.Component;

@Component("NewMerchantFunction")
public class NewMerchantFunction {
	public String sendMessage(String openId, String content){
		String infoStr = "如果您是商户，请您关注“小企额”公众号进行登录！";
		return infoStr;
	}
	
}
