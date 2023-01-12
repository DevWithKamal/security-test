package com.javatechie.jwt.api.dto.request;

import java.time.LocalDate;





import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {

	
	
	
	private int accountnumber;
	
	private String accountType;
	private double openingBalance;
	private LocalDate   openingDate;//=LocalDate.now();//openingDate
	private String Description;
	
	
	private LocalDate   expiryDate;	
	
}
