package com.javatechie.jwt.api.repository;





import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.javatechie.jwt.api.entity.Transaction;


@Service
@ComponentScan
public interface TransactRepo extends JpaRepository<Transaction,Integer>{
//	
//	@Query("From Transaction where fromAccount in(select   accountNumber  From Account a where a.customer.customerId  = :custid ) ")
//	 public List<Transaction> gettrdata(int custid);
	
	List<Transaction> findByFromAccount(int cid);//in is use for list condition
	
	@Query("From Transaction where fromAccount in(select accountnumber From Account a where a.customer.customerId = :cid)")
	public List<Transaction> gettrdata(int cid);

}