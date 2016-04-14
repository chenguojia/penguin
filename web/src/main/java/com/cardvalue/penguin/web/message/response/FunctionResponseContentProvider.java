package com.cardvalue.penguin.web.message.response;

import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.model.FunctionMessageContent;
import com.cardvalue.penguin.model.MessageContent;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.web.message.ResponseContentProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

public class FunctionResponseContentProvider implements ResponseContentProvider {

	private final static Logger logger = LoggerFactory.getLogger(FunctionResponseContentProvider.class);

	@Autowired
	private ApplicationContext appContext;

	@Override
	public void fillContent(WeChatMessage respMessage, MessageContent messageContent,String content) {
		FunctionMessageContent functionContent = (FunctionMessageContent) messageContent;
		try {
			Object bean = appContext.getBean(functionContent.getBeanName());
			Method method = ReflectionUtils.findMethod(bean.getClass(), functionContent.getMethodName(), String.class, String.class);
			Object result = ReflectionUtils.invokeMethod(method, bean, respMessage.getToUserName(),content);
			respMessage.setContent((String)result);
			respMessage.setMsgType(Constants.WE_MESSAGE_TYPE_TEXT);
		} catch (Exception e) {
			logger.error("Error occurs when calling function response content provider", e);
		}
	}

}
