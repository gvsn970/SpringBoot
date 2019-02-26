package com.javasampleapproach.springrest.mysql.controller;

public class CustomerAddResponse {

	private int statusCode;
	private String statusMessage;
	public synchronized int getStatusCode() {
		return statusCode;
	}
	public synchronized void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public synchronized String getStatusMessage() {
		return statusMessage;
	}
	public synchronized void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerAddResponse [statusCode=");
		builder.append(statusCode);
		builder.append(", statusMessage=");
		builder.append(statusMessage);
		builder.append("]");
		return builder.toString();
	}
	
}
