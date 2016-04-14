package com.cardvalue.penguin.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include=Inclusion.NON_EMPTY)
public class WeButton {

	@JsonProperty("sub_button")
	private List<WeButton> subButtons = new ArrayList<WeButton>() ;
	
	private String type;
	
	private String name;
	
	private String key;
	
	private String url;

	public List<WeButton> getSubButtons() {
		return subButtons;
	}

	public void setSubButtons(List<WeButton> subButtons) {
		this.subButtons = subButtons;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
