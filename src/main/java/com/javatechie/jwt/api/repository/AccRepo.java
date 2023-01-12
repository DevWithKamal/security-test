package com.javatechie.jwt.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javatechie.jwt.api.dto.request.AccountResponseDto;
import com.javatechie.jwt.api.entity.Account;




 
public interface AccRepo extends JpaRepository<Account,Integer> {
	
	List<Account> getAccountByCustomerCustomerId(int cid);
	//List<Account> findByCustomerCustomerId(int cid);
	
	List<Account> findByCustomerCustomerId(int custid);
	
	
	//@Query(value = "from Account  where customer.customerId=:cid")
//	@Query(value = "select a from Account a where a.customer.customerId =:cid")
//	  List<Account> getAcc(@Param("cid") int cid );
//	
	
	@Query(value = " select *  from accountjwt  where CUSTOMER_CUSTOMER_ID = '1'",nativeQuery=true)
	  List<Account> getAcc(@Param("cid") int cid );
	
//private int accountnumber;  
//	
//	private String accountType;
//	private double openingBalance;
//	private LocalDate   openingDate;//=LocalDate.now();//openingDate
//	private String Description;
//	
//	
//	private LocalDate   expiryDate;	
	
}

