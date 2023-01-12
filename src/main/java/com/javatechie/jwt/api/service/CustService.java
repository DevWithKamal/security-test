package com.javatechie.jwt.api.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.jwt.api.dto.request.AccountRequestdto;
import com.javatechie.jwt.api.dto.request.CustomerRequestDto;
import com.javatechie.jwt.api.entity.Account;
import com.javatechie.jwt.api.entity.Address;
import com.javatechie.jwt.api.entity.Customer;
import com.javatechie.jwt.api.repository.AccRepo;
import com.javatechie.jwt.api.repository.AddRepo;
import com.javatechie.jwt.api.repository.CustRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustService {

	@Autowired
	CustRepo cr;
	
	@Autowired
	AddRepo ar;
	
	@Autowired
	 AccRepo acr;
	public void saveCust(CustomerRequestDto crDto)
	{
		
		Address add=Address.builder().addressLine1(crDto.getAddressLine1())
				.addressLine2(crDto.getAddressLine2())
				.city(crDto.getCity())
				.state(crDto.getState())
				.pincode(crDto.getPincode())
				.build();
	
		Address addCreated=ar.save(add);
	
		
		Customer cust=Customer.builder().firstName(crDto.getFirstName()).lastName(crDto.getLastName()).emailId(crDto.getEmailId())
				.contactNo(crDto.getContactNo()).address(addCreated).gender("Male").password(crDto.getPassword()).registerationDate(LocalDate.now()).build();
		System.out.println("cust entity is now from builder : "+ cust);
		log.info("Cust enttity saved",cust);;
		Customer custCreated=cr.save(cust);
		
	}
	
	public void saveAccount(AccountRequestdto accReq)
	{
//Optional<Customer> optionalCust= cr.findById(Integer.parseInt(accReq.getCustomerid()));
		Optional<Customer> optionalCust= cr.findById(Integer.parseInt(accReq.getCustomerid()));
		
		if(!optionalCust.isPresent())//If a value is present, returns true, otherwise false.
		{
			//it means customer is not ther in db
//			throw new ResourceNotFoundException("Customer is not present in database");
		}
		

		Customer cust=optionalCust.get();
		//Customer cust=new Customer();
	//	cust.setCustomerId(Integer.parseInt(accReq.getCustomerid()));
		//cust.setCustomerId(Integer.parseInt("4"));
		
		Account account=Account.builder()
				.accountType(accReq.getAccountType())
				.customer(cust).openingBalance((accReq.getOpeningBalance())).Description(accReq.getDescription())
				.openingDate(accReq.getOpeningDate()).expiryDate(LocalDate.now())//accReq.getExpiryDate()
				.customer(cust).openingBalance((accReq.getOpeningBalance())).Description(accReq.getDescription()).build();//(accReq.getOpeningBalance())
				
		acr.save(account);
	}

}
