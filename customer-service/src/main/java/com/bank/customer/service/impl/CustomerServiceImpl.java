package com.bank.customer.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.customer.dao.CustomerRepository;
import com.bank.customer.entity.Customer;
import com.bank.customer.exception.CustomerNotFoundException;
import com.bank.customer.payload.CustomerDto;
import com.bank.customer.service.CustomerService;
import com.bank.customer.util.CustomerEntityDtoMapper;


@Service
public class CustomerServiceImpl implements CustomerService{
	
   
	Logger logger= LoggerFactory.getLogger(CustomerServiceImpl.class);
	
   @Autowired
   private CustomerRepository customerRepository;
   
   
   @Autowired
   private CustomerEntityDtoMapper customerEntityDtoMapper;
   
   @Autowired
	private ModelMapper modelMapper;
   

   @Override
	public CustomerDto createCustomer(CustomerDto customerDto) {


	    Customer customer = customerEntityDtoMapper.mapToEntity(customerDto);
	    Customer savedCustomer = customerRepository.save(customer);

	    logger.info("new customer saved successfully");
		
		// convert entity to DTO
		CustomerDto customerResponse = customerEntityDtoMapper.mapToDto(savedCustomer);

		return customerResponse;
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
       
		List<Customer> allCustomers = customerRepository.findAll();
		
		logger.info("fetched all customers from db");
		
		return allCustomers.stream().map(customer -> customerEntityDtoMapper.mapToDto(customer)).collect(Collectors.toList());
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto, Long customerId) {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer does not found "));	
		
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setAge(customerDto.getAge());
		customer.setEmail(customerDto.getEmail());
		customer.setGender(customerDto.getGender());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setSalary(customerDto.getSalary());
		
		
		Customer updatedCustomer = customerRepository.save(customer);
		logger.info(customerId+" customer updated successfully");
		return customerEntityDtoMapper.mapToDto(updatedCustomer);
	}

	@Override
	public CustomerDto getCustomerById(Long customerId) {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer does not found "));
		
		logger.info(customerId+" customer fetched successfully");
		
		return customerEntityDtoMapper.mapToDto(customer);
	}

	@Override
	public void deleteCustomerById(Long customerId) {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer does not found "));	
		
		logger.info(customerId+" customerId deleted successfully");
		
		customerRepository.delete(customer);
	}
	
	
	
	
	

	
}
