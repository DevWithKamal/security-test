package com.javatechie.jwt.api.service;



import java.time.LocalDate;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javatechie.jwt.api.dto.request.TransactionDepositDTO;
import com.javatechie.jwt.api.entity.Account;
import com.javatechie.jwt.api.entity.Transaction;
import com.javatechie.jwt.api.repository.AccRepo;
import com.javatechie.jwt.api.repository.CustRepo;
import com.javatechie.jwt.api.repository.TransactRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@RequiredArgsConstructor
public class TransactServiceImpl {
	
	private final AccRepo accountRepo;
	private final CustRepo customerRepo;
	
	private final TransactRepo transactRepo;
	

	
	public Transaction depositAmountInAccount(TransactionDepositDTO tdd)
	{
		
		//1-update openign balance 
		int accountNumber=tdd.getToAccount();
		
double acc;
		
		Optional<Account> optAcc=accountRepo.findById(accountNumber);
		
		acc = optAcc.get().getOpeningBalance();
		
		double newOpeningBalance=acc+tdd.getAmount();
		updateOpeningBalanceByAccountNumber(tdd.getToAccount(), newOpeningBalance);
//		
//		Account account=Account.builder()
//				.accountType(accReq.getAccountType())
//				.customer(cust).openingbalance(Double.parseDouble(accReq.getOpeningBalance())).Description(accReq.getDescription())
//				.openingDate(LocalDate.now()).build();
		
		Transaction taccount=Transaction.builder()
				.toAccount(tdd.getToAccount()).transactionType(tdd.getTransactionType()).fromAccount(tdd.getFromAccount()).amount(tdd.getAmount())
				.description(tdd.getDescription()).transactionDate(LocalDate.now()).build();
		
		transactRepo.save(taccount);
		
		
		return taccount;
		
		
		
		
		
		
		
	
		//Transaction obj= saveTransaction(trans);
//		System.out.println("transaction saved successfully");
		//return obj;
	}

	
	public Transaction withdrawAmountInAccount(TransactionDepositDTO tdd) {
		//1-update openign balance 
				int accountNumber=tdd.getToAccount();
				
		double acc;
				
				Optional<Account> optAcc=accountRepo.findById(accountNumber);
				
				acc = optAcc.get().getOpeningBalance();
				
				double newOpeningBalance=acc-tdd.getAmount();
				updateOpeningBalanceByAccountNumber(tdd.getToAccount(), newOpeningBalance);
//				
//				Account account=Account.builder()
//						.accountType(accReq.getAccountType())
//						.customer(cust).openingbalance(Double.parseDouble(accReq.getOpeningBalance())).Description(accReq.getDescription())
//						.openingDate(LocalDate.now()).build();
				
				Transaction taccount=Transaction.builder()
						.toAccount(tdd.getToAccount()).transactionType(tdd.getTransactionType()).fromAccount(tdd.getToAccount()).amount(tdd.getAmount())
						.description(tdd.getDescription()).transactionDate(LocalDate.now()).build();
				
				transactRepo.save(taccount);
				
				return taccount;
	}
	
	
	public Transaction fundTransferamountInAccount(TransactionDepositDTO tdd) {
		int accountToNumber=tdd.getToAccount();
		
		int accountFromNumber=tdd.getFromAccount();
		
		double accT;
		
		double accF;
		
		Optional<Account> optAccT=accountRepo.findById(accountToNumber);
		Optional<Account> optAccF=accountRepo.findById(accountFromNumber);
		
		accT = optAccT.get().getOpeningBalance();
		
		accF = optAccF.get().getOpeningBalance();
		
		double newOpeningBalanceF=accF-tdd.getAmount();
		updateOpeningBalanceByAccountNumber(tdd.getFromAccount(), newOpeningBalanceF);
		
	   double newOpeningBalanceT=accT+tdd.getAmount();
		
		updateOpeningBalanceByAccountNumber(tdd.getToAccount(), newOpeningBalanceT);
		

		Transaction taccount=Transaction.builder()
				.toAccount(tdd.getToAccount()).transactionType(tdd.getTransactionType()).fromAccount(tdd.getFromAccount()).amount(tdd.getAmount())
				.description(tdd.getDescription()).transactionDate(LocalDate.now()).build();
		
		transactRepo.save(taccount);
		
		return taccount;
	}

	
	//@SuppressWarnings("deprecation")
	public int updateOpeningBalanceByAccountNumber(int accountNumber,double newOpeningBalance)
	{	
		int res=0;
		
		
		
//		
	Optional<Account> acc=accountRepo.findById(accountNumber);
	Account acc1=acc.get();
	               acc1.setOpeningBalance(newOpeningBalance);
//		System.out.println("account's opening balance updated using hibernate  and acc is now = "+ acc +" newopenbalance is = "+ newOpeningBalance);
//		acc.setOpeningBalance(newOpeningBalance);
//		em.persist(acc);
//		
//		et.commit();
//		em.close();
//		emf.close();
		return res;
	}


	


	
}

