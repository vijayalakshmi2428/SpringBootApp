package com.bank.customer.payload;


import com.bank.customer.enums.EnumGenderPattern;
import com.bank.customer.enums.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

	private Long customerId;

	@NotEmpty(message = "CustomerName required")
	@Size(min = 10, max = 100, message = "CustomerName must have minimum 10 chars and max 100 chars")
	private String customerName;

	@NotNull(message = "Age required")
	@Min(value = 18, message = "Age must be > 18 Years")
	private int age;

	@NotEmpty(message = "Email required")
	@Email(message = "Enter valid email")
	private String email;
	
	@NotNull(message = "Age required")
	@Min(value = 18, message = "Age must be > 18 Years")
	
	@NotEmpty(message = "MobileNumber required")
	@Pattern(regexp = "^\\d{10}$", message = "Must be a 10 digit mobile number")
	private String mobileNumber;
	
	@NotNull(message = "Salary required")
	@Positive
	private Double salary;
	
	@NotNull(message = "Gender required")
//	@EnumGenderPattern(regexp  = "MALE|FEMALE", message = "Gender is either MALE or FEMALE")
	private Gender gender;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
			this.gender = gender;
	}

	

	
	
	
}
