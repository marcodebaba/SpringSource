package org.springframework.beans;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Description: 类描述
 * Author: Marco.Pan
 * Version: 1.0
 * Date: 2026年04月20日 15:24
 */
//@Aspect
//@Component
public class MyAspect {
	@Pointcut("execution(public void org.springframework.beans.UserService.test())")
	public void method1() {

	}

	@Before("method1()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before");
	}
}