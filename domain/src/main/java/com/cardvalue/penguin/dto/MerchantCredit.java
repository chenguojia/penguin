package com.cardvalue.penguin.dto;

import com.cardvalue.penguin.util.Utility;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="merchant_credit")
public class MerchantCredit implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="branch_code")
	private String branchCode;
	
	@Column(name="region_code")
	private String regionCode;
	
	private String mid;
	
	@Column(name="credit_line_in_90_days")
	private Double creditLine;
	
	@Column(name="merchant_name")
	private String merchantName;
	
	@Column
	private String address;
	
	@Column(name="mcc_code")
	private String mccCode;
	
	private String province;
	
	private String prefecture;
	
	private String county;
	
	private String subdistrict;
	
	private String area;
	
	//机构
	@Column(name="processor_id")
	private String processorId;
	
	@Column(name="expire_date")
	private Date expireDate;
	
	public MerchantCredit(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public double getCreditLine() {
		return creditLine;
	}
	
	public String getCreditLineLabel() {
		return Utility.formatAmount(creditLine);
	}

	public void setCreditLine(double creditLine) {
		this.creditLine = creditLine;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMccCode() {
		return mccCode;
	}

	public void setMccCode(String mccCode) {
		this.mccCode = mccCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

	public String getProcessorId() {
		return processorId;
	}

	public void setProcessorId(String processorId) {
		this.processorId = processorId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	public String getRefreshMonth(){
		return DateFormatUtils.format(DateUtils.addMonths(expireDate, -1), "yyyy/MM");
	}
	
}
