package com.plantnursery.plantnursery.repository;

import java.util.List;

import com.plantnursery.plantnursery.entities.Order;








public interface IOrderRepository {
	public List<Order> readAllOrd();
	public int deleteOrd(int orderId);
	public Order readOrd(int orderId);
	public int createOrd(Order order);
	public int updateOrd(Order order);
}
