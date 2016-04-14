package com.cardvalue.penguin.dto;

public class BaseMessage {

	private String touser;
	private String msgtype;

	public BaseMessage() {
		super();
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

}