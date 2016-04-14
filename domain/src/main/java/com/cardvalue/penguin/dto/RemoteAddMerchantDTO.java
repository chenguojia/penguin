package com.cardvalue.penguin.dto;

import com.cardvalue.penguin.util.Constants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RemoteAddMerchantDTO {

	@NotNull(message="请输入商户联系人姓名")
	@Size(min=2, max=6, message="请输入正确商户联系人姓名")
	private String contactName;
	
	@NotNull(message="请输入手机号")
	@Pattern(regexp= Constants.VALID_PATTERN_MOBILE, message="请输入正确的手机号")
	private String contactMobile;
	
	@NotNull(message="请输入联系人身份")
	private int contactPosition;
	
	private String mid;

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(int contactPosition) {
		this.contactPosition = contactPosition;
	}
	
}
