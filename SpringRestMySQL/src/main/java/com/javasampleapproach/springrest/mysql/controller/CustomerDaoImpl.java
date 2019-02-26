package com.javasampleapproach.springrest.mysql.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.javasampleapproach.springrest.mysql.model.Customer;
@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<CustomerListDTO> getAllCustomersList() {
		// TODO Auto-generated method stub
		CustomerResponseListDTO responseModel = new CustomerResponseListDTO();
		List<CustomerListDTO> userlist = new ArrayList<CustomerListDTO>();
		CustomerListDTO model = null;
		try {
			String hql= "SELECT * FROM customer WHERE delete_status=0 ";
			List<Object> customers = entityManager.createNativeQuery(hql).getResultList();
			if (customers.size() > 0) {
				Iterator itr = customers.iterator();
				while (itr.hasNext()) {
					Object[] obj = (Object[]) itr.next();
					model = new CustomerListDTO();
					model.setCustomerId(Integer.parseInt(String.valueOf(obj[0])));
					model.setName(String.valueOf(obj[1]));
					model.setEmail(String.valueOf(obj[2]));
					userlist.add(model);
				}
			}
		
		} catch (Exception e) {
			responseModel.setStatusCode(0);
			responseModel.setStatusMessage(e.getMessage());

		} 
		return userlist;
	}
	@Override
	public CustomerAddResponse addCustomer(Customer model) {
		// TODO Auto-generated method stub
		CustomerAddResponse res=new CustomerAddResponse();
		try {
			entityManager.persist(model);
			if(model.getId() !=0) {
				res.setStatusCode(1);
				res.setStatusMessage("Registartion Success...!");
			}else {
				res.setStatusCode(1);
				res.setStatusMessage("Registartion Failed...!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public List<CustomerListDTO> getCustomerListById(int cid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		CustomerResponseListDTO responseModel = new CustomerResponseListDTO();
		List<CustomerListDTO> userlist = new ArrayList<CustomerListDTO>();
		CustomerListDTO model = null;
		try {
			String hql= "SELECT * FROM customer WHERE c_id="+cid+" AND delete_status=0 ";
			List<Object> customers = entityManager.createNativeQuery(hql).getResultList();
			if (customers.size() > 0) {
				Iterator itr = customers.iterator();
				while (itr.hasNext()) {
					Object[] obj = (Object[]) itr.next();
					model = new CustomerListDTO();
					model.setCustomerId(Integer.parseInt(String.valueOf(obj[0])));
					model.setName(String.valueOf(obj[1]));
					model.setEmail(String.valueOf(obj[2]));
					userlist.add(model);
				}
			}
		
		} catch (Exception e) {
			responseModel.setStatusCode(0);
			responseModel.setStatusMessage(e.getMessage());

		} 
		return userlist;
	}
	@Override
	public CustomerAddResponse deleteCustomer(int id) {
		// TODO Auto-generated method stub
		CustomerAddResponse res=new CustomerAddResponse();
		try {
			String hql = "update customer set delete_status=1 WHERE c_id="+id+" ";
			int deletecustomer = entityManager.createNativeQuery(hql).executeUpdate();
			if(deletecustomer>0) {
				res.setStatusCode(1);
				res.setStatusMessage("Customer Deleted Succesfully....!");
			}else {
				res.setStatusCode(0);
				res.setStatusMessage("Customer Deleteion Faild....!");
			}
			//entityManager.re;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public CustomerAddResponse updateCustomer(Customer model) {
		// TODO Auto-generated method stub
		CustomerAddResponse res=new CustomerAddResponse();
		try {
			String hql = "update customer set customer_name='"+model.getName()+"',email='"+model.getEmail()+"',password='"+model.getPassword()+"' WHERE c_id="+model.getId()+" ";
			int updateustomer = entityManager.createNativeQuery(hql).executeUpdate();
			if(updateustomer>0) {
				res.setStatusCode(1);
				res.setStatusMessage("Updated Succesfully....!");
			}else {
				res.setStatusCode(1);
				res.setStatusMessage("Updatedtion Failed....!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
