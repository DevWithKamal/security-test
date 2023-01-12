package com.javatechie.jwt.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.javatechie.jwt.api.entity.Address;



public interface AddRepo extends JpaRepository<Address, Integer> {
	
	//Address  findByAddressId(int id);
	
	
	

}