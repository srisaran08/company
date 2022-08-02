package com.plantnursery.plantnursery.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.plantnursery.plantnursery.entities.Customer;




@Repository
public class ICustomerRepositoryImpl implements ICustomerRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Customer> readAllCustomer() {
		// TODO Auto-generated method stub
		TypedQuery<Customer> emptqury=em.createQuery("select c from Customer c",Customer.class);
		return emptqury.getResultList();
	}

	@Override
	public int deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		Customer c= em.find(Customer.class,customerId);
		if(c!=null) {
		em.remove(c);
		}
		return c.getCustomerId();
	}

	@Override
	public Customer readCustomer(int customerId) {
		return em.find(Customer.class,customerId);
	}


	@Override
	public int createCustomer(Customer customer) {
		em.persist(customer);
		return customer.getCustomerId();
	}
	
	@Override
	public int updateCustomer(Customer customer) {
		em.merge(customer);
		return customer.getCustomerId();
	}

	@Override
	public int login(String username, String password) {
		TypedQuery<Customer> emptqury=em.createQuery("select c from Customer c",Customer.class);
		List<Customer> c = emptqury.getResultList();
		int k=0;
		for(Customer f:c)
		{
		if(f.getUsername().contains(username))
		 {
			if(f.getPassword().contains(password))
			{
				k=1;
			}
		 }
		}
		return k;
	}
		
}