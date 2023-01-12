package com.javatechie.jwt.api.entity;





import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="transact")
public class Transaction implements Serializable {
	
	
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "custidSeq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	private int transactionId;
	
	private String transactionType;
	
	private LocalDate transactionDate;
	
	private double amount;
	
	private String description;
	
	private int fromAccount;
	
	private int toAccount;

}
