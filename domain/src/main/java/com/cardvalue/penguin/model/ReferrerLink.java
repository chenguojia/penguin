package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tmp_merchant_referrer")
public class ReferrerLink {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="merchant_open_id")
	private String merchantOpenId;
	
	@Column(name="referrer_id")
	private int referrerId;
	
	private String mid;
	
	@Column(name="create_date")
	private Date createDate;
	
	private boolean valid;
	
	@Column(name="short_key")
	private String shortKey;
	
	@Column(name="contact_name")
	private String contactName;
	
	@Column(name="contact_mobile")
	private String contactMobile;
	
	@Column(name="contact_position")
	private int contactPosition;

	public String getMerchantOpenId() {
		return merchantOpenId;
	}

	public void setMerchantOpenId(String merchantOpenId) {
		this.merchantOpenId = merchantOpenId;
	}

	public int getReferrerId() {
		return referrerId;
	}

	public void setReferrerId(int referrerId) {
		this.referrerId = referrerId;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getShortKey() {
		return shortKey;
	}

	public void setShortKey(String shortKey) {
		this.shortKey = shortKey;
	}

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

	public int getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(int contactPosition) {
		this.contactPosition = contactPosition;
	}
	
}
