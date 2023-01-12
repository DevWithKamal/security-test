package com.javatechie.jwt.api.entity;





import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="accountjwt")
@Component
public class Account  {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "accidSeq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	
	private int accountnumber;
	@ManyToOne
	@JsonIgnore
	private Customer customer;
	//@Enumerated(EnumType.STRING)
	private String accountType;
	private double openingBalance;
	private LocalDate   openingDate;//=LocalDate.now();//openingDate
	private String Description;
	
	
	private LocalDate   expiryDate;	
	
	
	
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountnumber + ", customer=" +" accountType=" + accountType
				+ ", openingBalance=" + openingBalance + ", openingDate=" + openingDate + ", description=" + Description
				+ "]";
	}
	
	
}