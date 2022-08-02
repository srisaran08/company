package com.plantnursery.plantnursery.services;

import java.util.List;


import com.plantnursery.plantnursery.Order.exception.DuplicateOrderIdException;
import com.plantnursery.plantnursery.Order.exception.InvalidOrderDataException;
import com.plantnursery.plantnursery.Order.exception.NoSuchOrderException;
import com.plantnursery.plantnursery.entities.Order;


public interface IOrderService {

public int deleteOrd(int orderId) throws NoSuchOrderException;

public List<Order> readAllOrd();

public Order readOrd(int orderId) throws NoSuchOrderException;

public int createOrd(Order order) throws  InvalidOrderDataException,DuplicateOrderIdException;

public int updateOrd(Order order);

public Order viewOrder(int orderId);
}