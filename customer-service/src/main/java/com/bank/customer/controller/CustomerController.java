package com.bank.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customer.payload.CustomerDto;
import com.bank.customer.service.CustomerService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/bank/customers")
public class CustomerController {
	
	Logger logger= LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/createCustomer")
	public ResponseEntity<CustomerDto> createUser(@Valid @RequestBody CustomerDto customerDto) {
		
		logger.info("saving customer into db");
		
		return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<CustomerDto>> getAllUsers() {
		
		logger.info("finding All Customers....");
		
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/findCustomer/{id}")
	public ResponseEntity<CustomerDto> getUserById(@PathVariable(name = "id") long id) {
		
		logger.info("finding Customer by id "+id);
		
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<CustomerDto> updateCustome(@Valid @RequestBody CustomerDto customerDto, 
			@PathVariable(name="id") long id) {
		
		logger.info("updating Custome by id "+id);
		
		CustomerDto customerResponse = customerService.updateCustomer(customerDto, id);
		
		return new ResponseEntity<>(customerResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id")long id) {
		
		logger.info("deleting user by id "+id);
		
		customerService.deleteCustomerById(id);
		
		return new ResponseEntity<>("Customer '"+id+"' deleted successfully.", HttpStatus.OK);
	}
	
	
	
}
