package com.neobis.onlineshop.controller;


import com.neobis.onlineshop.entity.CustomerEntity;
import com.neobis.onlineshop.model.CustomerDto;
import com.neobis.onlineshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/all")  // issue with id=31
	public List<CustomerEntity> getCutomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping(path="/{id}")
	public CustomerEntity getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id); 
	}
	
	@GetMapping()
	public CustomerEntity getCustomerByEmail(@RequestParam(value="email") String email) {
		return customerService.findCustomerByEmail(email);
	}

	
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerEntity createCustomer(@RequestBody CustomerEntity customer) {
		return customerService.createUser(customer);
	}

	
	@PutMapping(path="/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerEntity updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable Long id) {
		return customerService.updateCustomer(id, customerDto);	
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody
    void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);		
	}
	
	
	
	

}
