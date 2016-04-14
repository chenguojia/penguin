package com.cardvalue.penguin.dto;



import java.util.List;

public class BaiduCoordinatorConvertResponseDTO {

	private int status;
	
	private List<Coordinator> result;
	
	public BaiduCoordinatorConvertResponseDTO(){}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Coordinator> getResult() {
		return result;
	}

	public void setResult(List<Coordinator> result) {
		this.result = result;
	}

}
