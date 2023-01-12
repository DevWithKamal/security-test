package com.javatechie.jwt.api.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.jwt.api.entity.CustDocModel;



public interface CustDocRepo  extends JpaRepository<CustDocModel,Long>{

	Optional<CustDocModel> findById(String fileName);
	Optional<CustDocModel> findByCustId(String fileName);

}

