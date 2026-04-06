package org.springframework.study;

import org.springframework.beans.OrderService;
import org.springframework.beans.SpringConfig;
import org.springframework.beans.UserService;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MySpringStudy {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(UserService.class);
		//beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, new OrderService());
		//beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(1, new OrderService());
		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
		context.registerBeanDefinition("userService", beanDefinition);

		UserService userService = (UserService) context.getBean("userService");
		userService.test();
	}
}
