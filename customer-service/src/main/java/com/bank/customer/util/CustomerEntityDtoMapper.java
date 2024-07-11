package com.bank.customer.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.customer.entity.Customer;
import com.bank.customer.payload.CustomerDto;

@Component
public class CustomerEntityDtoMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	public Customer mapToEntity(CustomerDto customerDto) {
		
		Customer customer = modelMapper.map(customerDto, Customer.class);

			return customer;

	}
		
	public CustomerDto mapToDto(Customer customer) {

			CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);

			return customerDto;
	}
}
