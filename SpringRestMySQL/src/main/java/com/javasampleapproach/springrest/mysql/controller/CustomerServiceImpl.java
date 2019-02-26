package com.javasampleapproach.springrest.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.springrest.mysql.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao dao;
	@Override
	public List<CustomerListDTO> getAllCustomersList() {
		// TODO Auto-generated method stub
		return dao.getAllCustomersList();
	}
	@Override
	public CustomerAddResponse addCustomer(Customer model) {
		// TODO Auto-generated method stub
		return dao.addCustomer(model);
	}
	@Override
	public List<CustomerListDTO> getCustomerListById(int cid) {
		// TODO Auto-generated method stub
		return dao.getCustomerListById(cid);
	}
	@Override
	public CustomerAddResponse deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(id);
	}
	@Override
	public CustomerAddResponse updateCustomer( Customer model) {
		// TODO Auto-generated method stub
		return dao.updateCustomer( model);
	}

}
