package com.plantnursery.plantnursery.services;

import java.util.List;


import com.plantnursery.plantnursery.customer.exceptions.DuplicateCustomerIdException;
import com.plantnursery.plantnursery.customer.exceptions.InvalidCustomerDataException;
import com.plantnursery.plantnursery.customer.exceptions.NoSuchCustomerException;
import com.plantnursery.plantnursery.entities.Customer;

public interface ICustomerService {

	
	
	public int deleteCustomer(int customerId) throws NoSuchCustomerException;

	public List<Customer> readAllCustomer();
	
	public Customer readCustomer(int customerId) throws NoSuchCustomerException;

	public int createCustomer(Customer customer) throws  InvalidCustomerDataException,DuplicateCustomerIdException;

	public int updateCustomer(Customer customer);
	
	public Customer viewCustomer(int customerId);
	
	public int login(String username,String password);


	
}
