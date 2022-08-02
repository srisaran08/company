package com.plantnursery.plantnursery.Order.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.plantnursery.plantnursery.PlantnurseryApplication;
import com.plantnursery.plantnursery.Order.exception.DuplicateOrderIdException;
import com.plantnursery.plantnursery.Order.exception.InvalidOrderDataException;
import com.plantnursery.plantnursery.Order.exception.NoSuchOrderException;
import com.plantnursery.plantnursery.repository.IOrderRepository;
import com.plantnursery.plantnursery.entities.Order;
import com.plantnursery.plantnursery.entities.Seed;
import com.plantnursery.plantnursery.seed.exception.DuplicateSeedIdException;
import com.plantnursery.plantnursery.seed.exception.NoSuchSeedException;
import com.plantnursery.plantnursery.services.IOrderService;
import com.plantnursery.plantnursery.entities.Order;
import com.plantnursery.plantnursery.Order.exception.DuplicateOrderIdException;
import com.plantnursery.plantnursery.Order.exception.InvalidOrderDataException;
import com.plantnursery.plantnursery.Order.exception.NoSuchOrderException;

@SpringBootTest
 class IOrderServiceTest {
	@Autowired
	private IOrderService iOrderService;
	final Logger logger = LoggerFactory.getLogger(PlantnurseryApplication.class);
	
	@MockBean
	private IOrderRepository iOrderRepository;
	Order c= new Order(12,null,"upi",25,500.000, null);
	@Test
	 void testCreateSeed() {
		//	List<Order> order = new ArrayList<>();
		Order c= new Order(0, null,"upi",25,500.000, null);
			
			when(iOrderRepository.createOrd(c)).thenReturn(iOrderRepository.createOrd(c));
			assertEquals(c,iOrderRepository.createOrd(c));
		}
	
	@Test
	 void deleteOrdTest() throws NoSuchOrderException {
		Order c= new Order(0, null,"upi",25,500.000, null);
		iOrderService.deleteOrd(30);
		verify(iOrderRepository,times(1)).deleteOrd(30);
	}

	@Test
	void testUpdateOrd() {
		Order c=new Order(0, null,"upi",25,500.000, null);
		iOrderService.updateOrd(c);
		verify(iOrderRepository,times(1)).updateOrd(c);
		}
   
	
	@Test
	void testDuplicateSeedIDShouldThrowDuplicateEmpIdException() throws NoSuchSeedException {
		//List<Order> order = new ArrayList<>();
		assertThrows(DuplicateSeedIdException.class, ()->{
			Order order = new Order(0, null,"upi",25,500.000, null);
			iOrderService.createOrd(order);
		});
		}

	@Test
	void testCreateOrderShouldThrowInvalidOrderDataOrderException() {
		//List<Order> order = new ArrayList<>();
		assertThrows(InvalidOrderDataException.class, ()->{
			Order order = new Order(0, null,"upi",25,500.000, null);
			iOrderService.createOrd(order);
		});
	}
	
	@Test
	void testFindOrderByIdShouldThrowNoSuchOrderException() {
		assertThrows(NoSuchOrderException.class, ()->{
			iOrderService.readOrd(400);
		});
	}
	

	@Test
	void testViewOrder() throws NoSuchOrderException {
		//List<Order> order = new ArrayList<>();
		Order order = new Order(0, null,"upi",25,500.000, null);
		Order result = iOrderService.readOrd(25);
		logger.info("bookingOrder Id "+result.getBookingOrderId());
		//assertEquals(customer.getCustomerName(), result.getCustomerName());
		assertEquals(order.getBookingOrderId(), result.getBookingOrderId());
		assertEquals(order.getOrderDate(), result.getOrderDate());
		assertEquals(order.getTransactionMode(), result.getTransactionMode());
		assertEquals(order.getQuantity(), result.getQuantity());
		assertEquals(order.getTotalCost(), result.getTotalCost());
	
	}

}