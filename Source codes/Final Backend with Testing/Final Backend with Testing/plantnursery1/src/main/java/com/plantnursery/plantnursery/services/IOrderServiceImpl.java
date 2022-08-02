package com.plantnursery.plantnursery.services;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.plantnursery.plantnursery.Order.exception.DuplicateOrderIdException;
import com.plantnursery.plantnursery.Order.exception.InvalidOrderDataException;
import com.plantnursery.plantnursery.Order.exception.NoSuchOrderException;
import com.plantnursery.plantnursery.entities.Order;
import com.plantnursery.plantnursery.repository.IOrderRepository;



@Service
public class IOrderServiceImpl implements IOrderService {


	@Autowired
	private IOrderRepository orderDao;

	@Override
	@Transactional
	public int deleteOrd(int orderId) throws NoSuchOrderException {
		// TODO Auto-generated method stub
		int ordId=orderDao.deleteOrd(orderId);
		return ordId;
	}

	@Override
	public Order readOrd(int customerId) throws NoSuchOrderException{
		int orderId = 0;
		Order result = orderDao.readOrd(orderId);
		if(result != null) {
		return result;
		}
		else {
			Order emptyOrde=new Order();
			emptyOrde.setBookingOrderId(0);
			return emptyOrde;
		}
	}

	@Override
	@Transactional
	public int createOrd(Order order) throws DuplicateOrderIdException, InvalidOrderDataException {
		int id=0;
		System.out.println("create ord called");
		System.out.println("ordid "+order.getBookingOrderId());
		Order ord=orderDao.readOrd(order.getBookingOrderId());
		//if ord is null and (that ord is not present in database
		//if ord is not null(ord is already present)
		if(ord!=null){
			System.out.println("Duplicate id");
			if(ord.getBookingOrderId()==order.getBookingOrderId()) {
				throw new DuplicateOrderIdException("Ord with "+order.getBookingOrderId() +" already Exist");
			}
		}
		if(order.getBookingOrderId()<=0) {
		throw new InvalidOrderDataException("Ord ID is Invalid");
		}
		id=orderDao.createOrd(order);
		return id;
	}

	@Override
	@Transactional
	public int updateOrd(Order order) {
		// TODO Auto-generated method stub
		return orderDao.updateOrd(order);
	}

	@Override
	public List<Order> readAllOrd() {
		// TODO Auto-generated method stub
		return orderDao.readAllOrd();
	}

	@Override
	public Order viewOrder(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.readOrd(orderId);
	}
}
