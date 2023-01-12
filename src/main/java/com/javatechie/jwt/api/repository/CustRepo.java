package com.javatechie.jwt.api.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.jwt.api.entity.Account;
import com.javatechie.jwt.api.entity.Address;
import com.javatechie.jwt.api.entity.Customer;

public interface CustRepo  extends JpaRepository<Customer,Integer>{

	
	Customer findByFirstName(String fnm);
	
	List<Account> findByCustomerId(int id);
	
	//Address findByUserName(String unm);
}
