package org.springframework.beans;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private OrderService orderService;

	public UserService() {
		System.out.println(0);
	}

	public UserService(OrderService orderService) {
		this.orderService = orderService;
		System.out.println(1);
	}

	public UserService(OrderService orderService, OrderService orderService2) {
		this.orderService = orderService;
		System.out.println(2);
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void test() {
		System.out.println(orderService);
	}
}
