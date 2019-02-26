package com.javasampleapproach.springrest.mysql.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.javasampleapproach.springrest.mysql.model.Customer;

@Service
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	//List<Customer> findByAge(int age);

	//Customer save(String name, String email, int password);
}
