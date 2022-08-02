package com.plantnursery.plantnursery.services;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.plantnursery.plantnursery.customer.exceptions.DuplicateCustomerIdException;
import com.plantnursery.plantnursery.customer.exceptions.InvalidCustomerDataException;
import com.plantnursery.plantnursery.customer.exceptions.NoSuchCustomerException;
import com.plantnursery.plantnursery.entities.Customer;
import com.plantnursery.plantnursery.repository.ICustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository iCustomerRepository;


	@Override
	@Transactional
	public int deleteCustomer(int customerId) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		int cusId=iCustomerRepository.deleteCustomer(customerId);
		return cusId;
	}

	@Override
	public Customer readCustomer(int customerId) throws NoSuchCustomerException{
		Customer result = iCustomerRepository.readCustomer(customerId);
		if(result != null) {
		return result;
		}
		else {
			Customer emptyEmp=new Customer();
			emptyEmp.setCustomerId(0);
			return emptyEmp;
		}
	}

	@Override
	@Transactional
	public int createCustomer(Customer customer) throws DuplicateCustomerIdException, InvalidCustomerDataException {
		int id=0;
		System.out.println("create employee called");
		System.out.println("employeeid "+customer.getCustomerId());
		Customer emp=iCustomerRepository.readCustomer(customer.getCustomerId());
		//if emp is null and (that emp is not present in database
		//if emp is not null(emp is already present)
		if(emp!=null){
			System.out.println("Duplicate id");
			if(emp.getCustomerId()==customer.getCustomerId()) {
				throw new DuplicateCustomerIdException("Employee with "+customer.getCustomerId() +" already Exist");
			}
		}
		if(customer.getCustomerId()<=0) {
		throw new InvalidCustomerDataException("Employee ID is Invalid");
		}
		id=iCustomerRepository.createCustomer(customer);
		return id;
	}

	@Override
	@Transactional
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return iCustomerRepository.updateCustomer(customer);
	}

	@Override
	public List<Customer> readAllCustomer() {
		// TODO Auto-generated method stub
		return iCustomerRepository.readAllCustomer();
	}

	@Override
	public Customer viewCustomer(int customerId) {
		
		return iCustomerRepository.readCustomer(customerId);
	}

	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		
		return iCustomerRepository.login(username, password);
	}
}

	

	


	

