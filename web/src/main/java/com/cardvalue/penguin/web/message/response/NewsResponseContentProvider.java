package com.cardvalue.penguin.web.message.response;



import com.cardvalue.penguin.dto.NewsItem;
import com.cardvalue.penguin.dto.NewsMessageContent;
import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.model.MessageContent;
import com.cardvalue.penguin.repository.MessageContentRepository;
import com.cardvalue.penguin.web.message.ResponseContentProvider;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class NewsResponseContentProvider implements ResponseContentProvider {

	@Resource
	private MessageContentRepository messageContentRepo;
	
	@Override
	public void fillContent(WeChatMessage respMessage, MessageContent messageContent,String content) {
		NewsMessageContent newsContent = (NewsMessageContent)messageContent;
		List<NewsItem> items = new ArrayList<NewsItem>();
		List<NewsMessageContent> articles = messageContentRepo.getChildNews(newsContent.getId());
		articles.add(0, newsContent);
		for(NewsMessageContent article : articles){
			NewsItem item = new NewsItem();
			item.setTitle(article.getTitle());
			item.setDescription(article.getDescription());
			item.setPicUrl(article.getPictureUrl());
			item.setUrl(article.getUrl());
			items.add(item);
		}
		respMessage.setArticles(items);
		respMessage.setArticleCount(String.valueOf(items.size()));
	}

}
