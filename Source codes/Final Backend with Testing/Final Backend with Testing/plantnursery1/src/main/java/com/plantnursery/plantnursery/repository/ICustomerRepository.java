package com.plantnursery.plantnursery.repository;

import java.util.List;

import com.plantnursery.plantnursery.entities.Customer;






public interface ICustomerRepository {
	public List<Customer> readAllCustomer();
	public int deleteCustomer(int customerId);
	public Customer readCustomer(int customerId);
	public int createCustomer(Customer customer);
	public int updateCustomer(Customer customer);
	public int login(String username,String password);
}
