package com.cardvalue.penguin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="apply_process") 
public class ApplyProcess implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="step_num")
	private Integer stepNum;
	
	@Column(name="respon_text")
	private String responText;
	
	@Column(name="client_input_type")
	private String clientInputType;
	
	@Column(name="last_step")
	private Integer lastStep;
	
	@Column(name="process_type")
	private Integer processType;
	
	@Column(name="fill_field_method_name")
	private String fillFieldMethodName;
	
	@Column(name="check_regular_expression")
	private String checkRegularExpression;
	
	@Column(name="check_fail_message")
	private String checkFailMessage;
	
	@Transient
	private String affirmStatus = "0";//用户确认状态0未确认 1待确认 2已确认
	
	@Transient
	private Date lastOptStepDate;//最后一次响应服务器此步骤的时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStepNum() {
		return stepNum;
	}

	public void setStepNum(Integer stepNum) {
		this.stepNum = stepNum;
	}

	public String getResponText() {
		return responText;
	}

	public void setResponText(String responText) {
		this.responText = responText;
	}

	public String getClientInputType() {
		return clientInputType;
	}

	public void setClientInputType(String clientInputType) {
		this.clientInputType = clientInputType;
	}

	public Integer getLastStep() {
		return lastStep;
	}

	public void setLastStep(Integer lastStep) {
		this.lastStep = lastStep;
	}

	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}


	public String getFillFieldMethodName() {
		return fillFieldMethodName;
	}

	public void setFillFieldMethodName(String fillFieldMethodName) {
		this.fillFieldMethodName = fillFieldMethodName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCheckRegularExpression() {
		return checkRegularExpression;
	}

	public void setCheckRegularExpression(String checkRegularExpression) {
		this.checkRegularExpression = checkRegularExpression;
	}

	public String getCheckFailMessage() {
		return checkFailMessage;
	}

	public void setCheckFailMessage(String checkFailMessage) {
		this.checkFailMessage = checkFailMessage;
	}

	public String getAffirmStatus() {
		return affirmStatus;
	}

	public void setAffirmStatus(String affirmStatus) {
		this.affirmStatus = affirmStatus;
	}

	public Date getLastOptStepDate() {
		return lastOptStepDate;
	}

	public void setLastOptStepDate(Date lastOptStepDate) {
		this.lastOptStepDate = lastOptStepDate;
	}

}