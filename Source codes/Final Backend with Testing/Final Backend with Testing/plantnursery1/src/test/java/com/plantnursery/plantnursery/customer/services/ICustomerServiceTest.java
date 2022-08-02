package com.plantnursery.plantnursery.customer.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.plantnursery.plantnursery.PlantnurseryApplication;
import com.plantnursery.plantnursery.entities.Order;
import com.plantnursery.plantnursery.entities.Customer;
import com.plantnursery.plantnursery.customer.exceptions.DuplicateCustomerIdException;
import com.plantnursery.plantnursery.customer.exceptions.InvalidCustomerDataException;
import com.plantnursery.plantnursery.customer.exceptions.NoSuchCustomerException;
import com.plantnursery.plantnursery.repository.ICustomerRepository;
import com.plantnursery.plantnursery.services.ICustomerService;

@SpringBootTest
class ICustomerServiceTest {

	@Autowired
	private ICustomerService iCustomerService;
	
	final Logger logger = LoggerFactory.getLogger(PlantnurseryApplication.class);
	
	@MockBean
	private ICustomerRepository iCustomerRepository;

	@Test
	 void testCreateCustomer() {
		List<Order> order = new ArrayList<>();
		Customer c= new Customer(30,"A67","455","Terza","ABC",null,order);
		when(iCustomerRepository.createCustomer(c)).thenReturn(iCustomerRepository.createCustomer(c));
		assertEquals(c,iCustomerRepository.createCustomer(c));
	}
	
	@Test
	 void deleteCustomerTest() throws NoSuchCustomerException {
		List<Order> order = new ArrayList<>();
		Customer c=new Customer(30,"A67","455","Terza","ABC",null,order);
		iCustomerService.deleteCustomer(30);
		verify(iCustomerRepository,times(1)).deleteCustomer(30);
	}

	@Test
	void testUpdateCustomer() {
		List<Order> order = new ArrayList<>();
		Customer c=new Customer(30,"A70","455","Terza","ABC",null,order);
		iCustomerService.updateCustomer(c);
		verify(iCustomerRepository,times(1)).updateCustomer(c);
		}
   
	
	@Test
	void testDuplicateCustomerIDShouldThrowDuplicateEmpIdException() throws NoSuchCustomerException {
		List<Order> order = new ArrayList<>();
		assertThrows(DuplicateCustomerIdException.class, ()->{
			Customer customer = new Customer(25,"A67","455","Terza","ABC",null,order);
			iCustomerService.createCustomer(customer);
		});
		
	}

	@Test
	void testCreateCustomerShouldThrowInvalidCustomerDataCustomerException() {
		List<Order> order = new ArrayList<>();
		assertThrows(InvalidCustomerDataException.class, ()->{
			Customer customer = new Customer(-1,"A67","455","Terza","ABC",null,order);
			iCustomerService.createCustomer(customer);
		});
	}
	
	@Test
	void testFindCustomerByIdShouldThrowNoSuchCustomerException() {
		assertThrows(NoSuchCustomerException.class, ()->{
			iCustomerService.readCustomer(400);
		});
	}
	

	@Test
	void testViewCustomer() throws NoSuchCustomerException {
		List<Order> order = new ArrayList<>();
		Customer customer = new Customer(25,"A67","455","Terza","ABC",null,order);
		Customer result = iCustomerService.readCustomer(25);
		logger.info("Customer name "+result.getCustomerName());
		assertEquals(customer.getCustomerName(), result.getCustomerName());
		assertEquals(customer.getCustomerId(), result.getCustomerId());
		assertEquals(customer.getCustomerEmail(), result.getCustomerEmail());
		assertEquals(customer.getUsername(), result.getUsername());
		assertEquals(customer.getPassword(),result.getPassword());
		assertEquals(customer.getAddress(), result.getAddress());
	}

}
