package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.dto.MessageContentDTO;
import com.cardvalue.penguin.dto.NewsMessageContent;
import com.cardvalue.penguin.model.MessageContent;

import java.util.List;

public interface MessageContentRepository {
	
	public MessageContent findMessageContent(String type, int id);
	
	public List<NewsMessageContent> getChildNews(int parentId);

	public String submitMessageContent(MessageContentDTO dto, String type);
	
}
