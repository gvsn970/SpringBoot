package com.javasampleapproach.springrest.mysql.controller;

import java.util.List;

public class CustomerResponseListDTO {

	private int statusCode;
	private String statusMessage;
	private List<CustomerListDTO> customersList;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public List<CustomerListDTO> getCustomersList() {
		return customersList;
	}
	public void setCustomersList(List<CustomerListDTO> customersList) {
		this.customersList = customersList;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerResponseListDTO [statusCode=");
		builder.append(statusCode);
		builder.append(", statusMessage=");
		builder.append(statusMessage);
		builder.append(", customersList=");
		builder.append(customersList);
		builder.append("]");
		return builder.toString();
	}
	
}
