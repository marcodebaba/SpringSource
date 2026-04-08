package org.springframework.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final OrderService orderService;

	@Autowired
	public UserService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void test() {
		System.out.println(orderService);
	}
}
