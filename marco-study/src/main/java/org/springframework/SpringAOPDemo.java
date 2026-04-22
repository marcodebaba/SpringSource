package org.springframework;

import org.springframework.beans.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description: 类描述
 * Author: Marco.Pan
 * Version: 1.0
 * Date: 2026年04月22日 17:16
 */
public class SpringAOPDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		//OrderService orderService = (OrderService) context.getBean("proxyFactoryBean");
		OrderService orderService = (OrderService) context.getBean("orderService");

		orderService.test();
	}
}