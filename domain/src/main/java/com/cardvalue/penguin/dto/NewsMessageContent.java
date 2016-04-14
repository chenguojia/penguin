package com.cardvalue.penguin.dto;

import com.cardvalue.penguin.model.MessageContent;

import javax.persistence.*;

@Entity
@Table(name="news_message_content")
public class NewsMessageContent implements MessageContent {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String title;
	
	private String description;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	private String url;
	
	@Column(name="parent_id")
	private Integer parentId;
	
	private Integer sort;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
