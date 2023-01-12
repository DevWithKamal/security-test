package com.javatechie.jwt.api.controller;





import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechi.jwt.api.dto.common.ApiResponse;
import com.javatechie.jwt.api.Exception.IcsdException;
import com.javatechie.jwt.api.dto.request.TransactionDepositDTO;
import com.javatechie.jwt.api.entity.Transaction;
import com.javatechie.jwt.api.repository.TransactRepo;
import com.javatechie.jwt.api.service.TransactServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/transact")
public class TransactController {
	
	
	@Autowired
	TransactServiceImpl ts;
	@Autowired
	TransactRepo tr;
	
	@PostMapping(value = "/add")
	//public ResponseEntity<ApiResponse> createCustomer(@RequestBody @Valid CustomerRequestDto customerRequest, BindingResult br) throws IcsdException
	public ResponseEntity<ApiResponse> depositeAmmount(@RequestBody  TransactionDepositDTO transactionDepositDTO,BindingResult br) throws IcsdException
	{
		log.info("inside create method of cusgtomer controller");
		if(br.hasErrors())
		{
			//throw new IcsdException("Ename is null");
		}
		System.out.println("Create Customer API called at "+new Date());
		System.out.println();//CustomerRequestDto [firstName=rohan, lastName=kumar, emailId=rb@rb.com, contactNo=987654321, gender=MALE, password=icsd, confirmPassword=icsd, addressLine1=delhi, addressLine2=sec 1123, city=delhi, State=delhis, pincode=132103]
		int transactId=ts.depositAmountInAccount(transactionDepositDTO).getTransactionId();
		//CustomerResponse customerResponse = new CustomerResponse(generatedCustomerId);
		
		//return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
		//CustomerRequestDto cer=new CustomerRequestDto("rohan", "kumar", "rb@rb.com", "987654321", Gender.MALE, "icsd", "icsd", "delhi", "sec 1123", "delhi","delhis","132103");
		ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "Customer Created Successfully",  transactId);
		return new ResponseEntity<ApiResponse> (apiResponse,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/withdraw")
	public ResponseEntity<ApiResponse> withDrawAmmount(@RequestBody  TransactionDepositDTO transactionDepositDTO) 
	{
		log.info("inside create method of cusgtomer controller");
//		if(br.hasErrors())
//		{
//			//throw new IcsdException("Ename is null");
//		}
		System.out.println("Create Customer API called at "+new Date());
		System.out.println();//CustomerRequestDto [firstName=rohan, lastName=kumar, emailId=rb@rb.com, contactNo=987654321, gender=MALE, password=icsd, confirmPassword=icsd, addressLine1=delhi, addressLine2=sec 1123, city=delhi, State=delhis, pincode=132103]
		int transactId=ts.withdrawAmountInAccount(transactionDepositDTO).getTransactionId();
		//CustomerResponse customerResponse = new CustomerResponse(generatedCustomerId);
		
		//return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
		//CustomerRequestDto cer=new CustomerRequestDto("rohan", "kumar", "rb@rb.com", "987654321", Gender.MALE, "icsd", "icsd", "delhi", "sec 1123", "delhi","delhis","132103");
		ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "Customer Created Successfully",  transactId);
		return new ResponseEntity<ApiResponse> (apiResponse,HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/fundTf")
	public ResponseEntity<ApiResponse> fundTransfer(@RequestBody  TransactionDepositDTO transactionDepositDTO) 
	{
		log.info("inside create method of cusgtomer controller");
//		if(br.hasErrors())
//		{
//			//throw new IcsdException("Ename is null");
//		}
		System.out.println("Create Customer API called at "+new Date());
		System.out.println();//CustomerRequestDto [firstName=rohan, lastName=kumar, emailId=rb@rb.com, contactNo=987654321, gender=MALE, password=icsd, confirmPassword=icsd, addressLine1=delhi, addressLine2=sec 1123, city=delhi, State=delhis, pincode=132103]
		int transactId=ts.fundTransferamountInAccount(transactionDepositDTO).getTransactionId();
		//CustomerResponse customerResponse = new CustomerResponse(generatedCustomerId);
		
		//return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
		//CustomerRequestDto cer=new CustomerRequestDto("rohan", "kumar", "rb@rb.com", "987654321", Gender.MALE, "icsd", "icsd", "delhi", "sec 1123", "delhi","delhis","132103");
		ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "Customer Created Successfully",  transactId);
		return new ResponseEntity<ApiResponse> (apiResponse,HttpStatus.OK);
		
	}
	@GetMapping("ftba")
	public List<Transaction> findTransactionByAcc()
	{
		return tr.findByFromAccount(3);
		
	}
	
//	@GetMapping("ftba1")
//	public List<Transaction> findTransactionByAcc1()
//	{
//		return tr.gettrdata(1);
//		
//	}

}

