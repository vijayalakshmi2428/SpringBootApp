package com.bank.customer.service;

import java.util.List;

import com.bank.customer.payload.CustomerDto;


public interface CustomerService {

	CustomerDto createCustomer(CustomerDto customerDto);
	
	List<CustomerDto> getAllCustomers();
	
	CustomerDto updateCustomer(CustomerDto customerDto, Long customerId);
	
	CustomerDto getCustomerById(Long customerId);
	
	void deleteCustomerById(Long customerId);
}
