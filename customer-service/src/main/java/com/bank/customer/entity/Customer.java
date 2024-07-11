package com.bank.customer.entity;

import com.bank.customer.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bank_customers")
public class Customer {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long customerId;

	@Column(length = 100, nullable = false)
	private String customerName;

	@Column
	private int age;

	@Column(nullable = false)
	private String email;
	
	@Column(length = 100, nullable = false)
	private String mobileNumber;
	
	@Column
	private Double salary;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
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
