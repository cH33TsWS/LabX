package com.cp.labx.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ErrorResponse {
	private int errorCode;
	private String message;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)	
	private String status;
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
