package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="message_rule")
@Cacheable
public class MessageRule implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private Integer priority;
	
	@Column
	private String keyword;
	
	@Column(name="response_type")
	private String responseType;
	
	@Column(name="response_id")
	private String responseId;

	@Column(name="rule_type")
	private String ruleType;	//匹配方式.


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
}
