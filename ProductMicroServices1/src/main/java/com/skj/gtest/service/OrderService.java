package com.skj.gtest.service;

import org.springframework.stereotype.Service;

import com.skj.gtest.entity.Order;
@Service
public interface OrderService {

	public Order addOrder(Order order);

}
