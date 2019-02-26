package com.javasampleapproach.springrest.mysql.controller;

import java.util.List;

import com.javasampleapproach.springrest.mysql.model.Customer;

public interface CustomerDao {

	List<CustomerListDTO> getAllCustomersList();
	CustomerAddResponse addCustomer(Customer model);
	List<CustomerListDTO> getCustomerListById(int cid);
	CustomerAddResponse deleteCustomer(int id);
	CustomerAddResponse updateCustomer( Customer model);
}
