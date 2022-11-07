package com.skj.gtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skj.gtest.entity.Order;
import com.skj.gtest.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order addOrder(Order order) {

		Order savedOrder = orderRepository.save(order);
		return savedOrder;
	}


}
