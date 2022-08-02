package com.plantnursery.plantnursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.plantnursery.plantnursery.customer.exceptions.DuplicateCustomerIdException;
import com.plantnursery.plantnursery.customer.exceptions.InvalidCustomerDataException;
import com.plantnursery.plantnursery.customer.exceptions.NoSuchCustomerException;
import com.plantnursery.plantnursery.entities.Address;
import com.plantnursery.plantnursery.entities.Customer;
import com.plantnursery.plantnursery.services.IAddressService;
import com.plantnursery.plantnursery.services.ICustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	private ICustomerService iCustomerService;
	
	@Autowired
	private IAddressService iAddressService;
	
	@GetMapping(path="/customer",produces = "application/json")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> result = iCustomerService.readAllCustomer();
		if(result.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Customer>>(result, HttpStatus.OK);
	}
	
	@GetMapping(path="/customer/{customerId}",produces = "application/json")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") int customerId) 
	{
		Customer customer = iCustomerService.viewCustomer(customerId);	
		if(customer==null) {
			return new ResponseEntity("Sorry! Customers not found!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	
	@GetMapping(path="/customer/{username}/{password}",produces = "application/json")
	public  int viewCustomer(@PathVariable("username") String username,@PathVariable("password") String password) 
	{
		return iCustomerService.login(username,password);	
	}
	
	@PostMapping(path="/customer",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
			throws DuplicateCustomerIdException, InvalidCustomerDataException {
		String errormsg = "";
		System.out.println("add customer called");
		int id = iCustomerService.createCustomer(customer);
		if (id >0)
		{
			return ResponseEntity.ok(customer);
		}
		throw new DuplicateCustomerIdException("id exist");

	}
	
	@PutMapping(path = "/customer/{customerId}", consumes = "application/json")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
		int result = iCustomerService.updateCustomer(customer);
		if (result != 0) {
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}

	}
	
	@DeleteMapping(path = "/customer/{customerId}", produces = "application/json")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("customerId") int customerId)
			throws NoSuchCustomerException {
		Customer result = iCustomerService.readCustomer(customerId);
		System.out.println("Customer id is " + result.getCustomerId());
		ResponseEntity<Customer> response = null;
		if (result.getCustomerId() > 0) {
			System.out.println("Inside if");
			iCustomerService.deleteCustomer(customerId);
			response = new ResponseEntity<Customer>(result, HttpStatus.OK);
			//]ResponseEntity response = new ResponseEntity("employee deleted successfully", HttpStatus.ACCEPTED);
			return response;
		} else {
			System.out.println("Inside else exception");
			throw new NoSuchCustomerException("Customer with this ID Not Found");
		}
	}
	
	@GetMapping("/address")
	public List<Address> getAddress()
	{
		return this.iAddressService.getAddress();   
	}
	
}
