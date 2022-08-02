package com.plantnursery.plantnursery.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.plantnursery.plantnursery.entities.Order;






@Repository
public class IOrderRepositoryImpl implements IOrderRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Order> readAllOrd() {
		// TODO Auto-generated method stub
		TypedQuery<Order> emptqury=em.createQuery("select c from Order c",Order.class);
		return emptqury.getResultList();
	}

	@Override
	public int deleteOrd(int orderId) {
		// TODO Auto-generated method stub
		Order c= em.find(Order.class,orderId);
		if(c!=null) {
		em.remove(c);
		}
		return c.getBookingOrderId();
	}

	@Override
	public Order readOrd(int orderId) {
		return em.find(Order.class,orderId);
	}


	@Override
	public int createOrd(Order order) {
		em.persist(order);
		return order.getBookingOrderId();
	}
	
	@Override
	public int updateOrd(Order order) {
		em.merge(order);
		return order.getBookingOrderId();
	}
	
}
