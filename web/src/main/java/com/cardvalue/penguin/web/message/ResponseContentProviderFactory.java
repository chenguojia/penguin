package com.cardvalue.penguin.web.message;

import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.web.message.response.FunctionResponseContentProvider;
import com.cardvalue.penguin.web.message.response.NewsResponseContentProvider;
import com.cardvalue.penguin.web.message.response.TextResponseContentProvider;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ResponseContentProviderFactory {

	@Resource
	private AutowireCapableBeanFactory autowireBeanFactory;
	
	public ResponseContentProvider getProvider(String type) {
		ResponseContentProvider provider = null;
		if (StringUtils.equals(Constants.WE_MESSAGE_TYPE_NEWS, type)) {
			provider = new NewsResponseContentProvider();
		} else if (StringUtils.equals(Constants.WE_MESSAGE_TYPE_FUNCTION, type)) {
			provider = new FunctionResponseContentProvider();
		} else {
			provider = new TextResponseContentProvider();
		}
		autowireBeanFactory.autowireBean(provider);
		return provider;
	}

}
