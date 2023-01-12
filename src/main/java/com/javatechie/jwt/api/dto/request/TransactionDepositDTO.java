package com.javatechie.jwt.api.dto.request;



import java.time.LocalDate;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDepositDTO {
	
	
private String transactionType;
	//@Transient
	private Date transactionDate;
	@NotBlank(message = "amount should not be blank")
	@NotNull(message="amount should not be null")
	@Size(min=1,max=100000, message="amount should not be less then 1 and greater then 100000")
	private double amount;
	@NotBlank(message = "Description should not be blank")
	@NotNull(message="Description should not be null")
	@Size(min = 2,max = 60,message = "Description should be between 2 to 60")
	private String description;
	
	
	
	
	private int fromAccount;
	
	private int toAccount;


}

