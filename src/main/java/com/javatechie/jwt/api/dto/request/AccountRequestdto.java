package com.javatechie.jwt.api.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestdto {
	
//	@NotBlank(message = "customerId should not be blank")
//	@NotNull(message="customerId should not be null")
	private String customerid;
//	@NotBlank(message = "accountType should not be blank")
//	@NotNull(message="accountType should not be null")
	//@Enumerated(EnumType.STRING)
	private String accountType;
//	@NotBlank(message = "Openingbalance should not be blank")
//	@NotNull(message="OpeningBalance should not be null")
	//@Size(min=100,max=100000, message="opening balance not be less then 100 and greater then 100000")
	//@Range(min=100, max=10000)
	private  double openingBalance;
	//private  double openingBalance;

	@NotBlank(message = "Description should not be blank")
	@NotNull(message="Description should not be null")
	@Size(min = 2,max = 60,message = "Description should be between 2 to 60")
	private String description;
	private LocalDate openingDate;
	
	private LocalDate expiryDate;
	

}