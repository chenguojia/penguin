package com.cardvalue.penguin.dto;


import com.cardvalue.penguin.model.ApplyProcess;
import com.cardvalue.penguin.model.ApplyProcessInputArgumentModel;

public class ApplyProcessContext {
	
	private ApplyProcess applyProcess;//手机端申请的流程
	
	private ApplyProcessInputArgumentModel aplyProcessInputArgumentModel;//用户输入参数
	
	public ApplyProcessContext() {
		super();
	}

	public ApplyProcessContext(ApplyProcess applyProcess,
							   ApplyProcessInputArgumentModel aplyProcessInputArgumentModel) {
		super();
		this.applyProcess = applyProcess;
		this.aplyProcessInputArgumentModel = aplyProcessInputArgumentModel;
	}

	public ApplyProcess getApplyProcess() {
		return applyProcess;
	}

	public void setApplyProcess(ApplyProcess applyProcess) {
		this.applyProcess = applyProcess;
	}

	public ApplyProcessInputArgumentModel getAplyProcessInputArgumentModel() {
		return aplyProcessInputArgumentModel;
	}

	public void setAplyProcessInputArgumentModel(
			ApplyProcessInputArgumentModel aplyProcessInputArgumentModel) {
		this.aplyProcessInputArgumentModel = aplyProcessInputArgumentModel;
	}
}
