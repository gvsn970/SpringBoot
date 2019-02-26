package com.javasampleapproach.springrest.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.Customer;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerService service;

	@RequestMapping(value="/customers/getlist", method = RequestMethod.GET, produces = "application/Json")
	public CustomerResponseListDTO getAllCustomers() {
		System.out.println("Get all Customers...");
		List<CustomerListDTO> list = null;
		CustomerResponseListDTO response = new CustomerResponseListDTO();
		try {

			list = service.getAllCustomersList();
			if (!list.isEmpty()) {
				response.setStatusCode(1);
				response.setStatusMessage("Customers List");
				response.setCustomersList(list);
			} else {
				response.setStatusCode(1);
				response.setStatusMessage("Customers List Not Found");
				response.setCustomersList(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	@RequestMapping(value="/customers/getuserlistbyid", method = RequestMethod.GET, produces = "application/Json")
	public CustomerResponseListDTO getCustomersById(@RequestParam("cid") int cid) {
		System.out.println("Get  Customer...");
		List<CustomerListDTO> list = null;
		CustomerResponseListDTO response = new CustomerResponseListDTO();
		try {

			list = service.getCustomerListById(cid);
			if (!list.isEmpty()) {
				response.setStatusCode(1);
				response.setStatusMessage("Customer List Found");
				response.setCustomersList(list);
			} else {
				response.setStatusCode(1);
				response.setStatusMessage("Customer List Not Found");
				response.setCustomersList(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/customers/create", method = RequestMethod.POST)
	public CustomerAddResponse postCustomer(@RequestBody CustomerRequestDTO customer) {
		CustomerAddResponse response=new CustomerAddResponse();
		try {
		
			Customer model=new Customer();
			model.setName(customer.getName());
			model.setEmail(customer.getEmail());
			model.setPassword(customer.getPassword());
			response=service.addCustomer(model);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value="/customers/delete", method = RequestMethod.POST)
	public CustomerAddResponse deleteCustomer(@RequestParam("id") int id) {
		CustomerAddResponse res=new CustomerAddResponse();
		try {
			res=service.deleteCustomer(id);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return res;
	}


	@RequestMapping(value="/customers/update", method = RequestMethod.POST)
	public CustomerAddResponse updateCustomer(@RequestParam("id") int id,@RequestParam("name") String name,
			@RequestParam("email") String email,@RequestParam("password") String password) {
		System.out.println("Update Customer with ID = " + id + "...");
		CustomerAddResponse res=new CustomerAddResponse();
		try {
			Customer model=new Customer();
			model.setId(id);
			model.setEmail(email);
			model.setName(name);
			model.setPassword(password);
			res=service.updateCustomer(model);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return res;
	}
	
/*	@DeleteMapping("/customers/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");

		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	}*/

}
