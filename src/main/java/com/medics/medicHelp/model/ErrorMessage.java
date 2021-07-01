package com.medics.medicHelp.model;

public class ErrorMessage {
	private String errorMessage;
	private String errorDetails;
	private String status;
	private int statusCode;
	
	public ErrorMessage() {
	}
	public ErrorMessage(String errorMessage, String errorDetails, String status, int statusCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
		this.status = status;
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
