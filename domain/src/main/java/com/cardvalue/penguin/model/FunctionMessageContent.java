package com.cardvalue.penguin.model;

import javax.persistence.*;

@Entity
@Table(name="function_message_content")
public class FunctionMessageContent implements MessageContent{

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@Column(name="bean_name")
	private String beanName;
	
	@Column(name="method_name")
	private String methodName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
}
