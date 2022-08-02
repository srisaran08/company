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

import com.plantnursery.plantnursery.entities.Order;
import com.plantnursery.plantnursery.services.IOrderService;
import com.plantnursery.plantnursery.services.IOrderServiceImpl;
import com.plantnursery.plantnursery.repository.IOrderRepository;
import com.plantnursery.plantnursery.repository.IOrderRepositoryImpl;
import com.plantnursery.plantnursery.Order.exception.DuplicateOrderIdException;
import com.plantnursery.plantnursery.Order.exception.InvalidOrderDataException;
import com.plantnursery.plantnursery.Order.exception.NoSuchOrderException;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	private IOrderService iOrderService;
	
	@GetMapping(path="/order",produces = "application/json")
	public ResponseEntity<List<Order>> getAllOrd() {
		List<Order> result = iOrderService.readAllOrd();
		if(result.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
	}
	
	 @GetMapping(path="/order/{orderId}",produces = "application/json")
		public ResponseEntity<Order> viewOrder(@PathVariable("orderId") int orderId) 
		{
		 	Order order = iOrderService.viewOrder(orderId);	
		 	if(order==null) {
				return new ResponseEntity("Sorry! Customers not found!", 
						HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		}
	
	@PostMapping(path="/order",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Order> createOrd(@RequestBody Order order)
			throws DuplicateOrderIdException, InvalidOrderDataException {
		String errormsg = "";
		System.out.println("add ord called");
		int id = iOrderService.createOrd(order);
		if (id >0)
		{
			return ResponseEntity.ok(order);
		}
		throw new DuplicateOrderIdException("id exist");

	}
	
	@PutMapping(path = "/order/{orderId}", consumes = "application/json")
	public ResponseEntity<Order> updateOrd(@PathVariable("orderId") int orderId, @RequestBody Order order) {
		int result = iOrderService.updateOrd(order);
		if (result != 0) {
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}

	}
	
	@DeleteMapping(path = "/order/{orderId}", produces = "application/json")
	public ResponseEntity<Order> deleteOrdById(@PathVariable("orderId") int orderId)
			throws NoSuchOrderException {
		Order result = iOrderService.readOrd(orderId);
		System.out.println("Order id is " + result.getBookingOrderId());
		ResponseEntity<Order> response = null;
		if (result.getBookingOrderId() > 0) {
			System.out.println("Inside if");
			iOrderService.deleteOrd(orderId);
			response = new ResponseEntity<Order>(result, HttpStatus.OK);
			//]ResponseEntity response = new ResponseEntity("employee deleted successfully", HttpStatus.ACCEPTED);
			return response;
		} else {
			System.out.println("Inside else exception");
			throw new NoSuchOrderException("Order with this ID Not Found");
		}
	}
	

}
