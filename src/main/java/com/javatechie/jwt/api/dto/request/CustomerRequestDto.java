package com.javatechie.jwt.api.dto.request;







import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDto {
	
	@NotBlank(message = "First name should not be blank")
	@NotNull(message="First name should not be null")
	@Size(min = 2,max = 60,message = "Name should be between 2 to 60")
	public String firstName;
	
	@NotBlank(message = "Last name should not be blank")
	@NotNull(message="Last name should not be null")
	private String lastName;
	
	@NotBlank(message = "emailId name should not be blank")
	@NotNull(message="emailId name should not be null")
	@Email(message ="not valid email formatrrrrrrrrrrrrrr ")
	private String emailId;
	
	@NotBlank(message = "contactNo name should not be blank")
	@NotNull(message="contactNo name should not be null")
	private String contactNo;
	
	private String gender;
	
	
	@NotBlank(message = "password name should not be blank")
	@NotNull(message="password name should not be null")
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 characters")
	//@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=])(?=\\S+$).{8,}$")
	private String  password;
	@NotBlank(message = "confirmPassword name should not be blank")
	@NotNull(message="confirmPassword name should not be null")
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 characters")
	private String confirmPassword;
	@NotBlank(message = "addressLine1 name should not be blank")
	@NotNull(message="addressLine1 name should not be null")
	private String addressLine1;
	@NotBlank(message = "First name should not be blank")
	@NotNull(message="First name should not be null")
	private String addressLine2;
	@NotBlank(message = "First name should not be blank")
	@NotNull(message="First name should not be null")
	private String city;
	@NotBlank(message = "First name should not be blank")
	@NotNull(message="First name should not be null")
	private String State;
	@NotBlank(message = "First name should not be blank")
	@NotNull(message="First name should not be null")
	private String pincode;
	@Override
	public String toString() {
		return "CustomerRequestDto [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", contactNo=" + contactNo + ", gender=" + gender + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city="
				+ city + ", State=" + State + ", pincode=" + pincode + "]";
	}
		
	
	
	
	}



