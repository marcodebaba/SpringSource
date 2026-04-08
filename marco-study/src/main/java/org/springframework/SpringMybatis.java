package org.springframework;

import org.springframework.beans.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO: 类描述
 *
 * @author marco.pan
 * @version 1.0
 * @ date 2026年04月07日 17:31
 */
public class SpringMybatis {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(MyConfig.class);
		context.refresh();

		UserService userService = (UserService) context.getBean("userService");
		userService.test();
	}
}