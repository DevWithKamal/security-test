package com.javatechie.jwt.api.entity;


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


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_cust_doc")
@Entity
public class CustDocModel {
	
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "accidSeq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private Long id;

    private String name;
    private String type;
    private String imagePath;
    
    private String custId;
	
    
}

