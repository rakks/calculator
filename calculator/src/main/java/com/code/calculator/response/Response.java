package com.code.calculator.response;


public class Response {

	private String status;
	private long result;
	private String description;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getResult() {
		return result;
	}
	public void setResult(long result) {
		this.result = result;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}