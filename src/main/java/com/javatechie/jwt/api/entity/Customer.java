package com.javatechie.jwt.api.entity;




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Custjwt", uniqueConstraints = { @UniqueConstraint(columnNames = "emailId") })
public class Customer  {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "custidSeq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	int customerId;
	String firstName;
	String lastName;

	String emailId;
	String contactNo;

	// @Enumerated(EnumType.STRING)
	private String gender;
	@Column(name = "pwd")
	String password;
	String confirmPassword;
	private LocalDate registerationDate;

	@OneToOne
	@JoinColumn(name = "addressFk") // name of join column is addresFk
	Address address;

	@OneToMany(targetEntity = Account.class, mappedBy = "customer")
	private List<Account> accoutns = new ArrayList();

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", contactNo=" + contactNo + ", gender=" + gender + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", registerationDate=" + registerationDate + ", address="
				+ address + ", accoutns=" + accoutns + "]";
	}

}
