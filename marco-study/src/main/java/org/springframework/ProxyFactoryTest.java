package org.springframework;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jspecify.annotations.Nullable;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.OrderService;

import java.lang.reflect.Method;

/**
 * Description: ProxyFactory代理
 * Author: Marco.Pan
 * Version: 1.0
 * Date: 2026年04月20日 16:47
 */
public class ProxyFactoryTest {
	public static void main(String[] args) {
		OrderService target = new OrderService();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
//		proxyFactory.addAdvice(new MethodBeforeAdvice() {
//			@Override
//			public void before(Method method, @Nullable Object[] args, @Nullable Object target) throws Throwable {
//				System.out.println("Before Advice");
//			}
//		});
//		proxyFactory.addAdvice(new AfterReturningAdvice() {
//			@Override
//			public void afterReturning(@Nullable Object returnValue, Method method, @Nullable Object[] args, @Nullable Object target) throws Throwable {
//				System.out.println("After Returning");
//			}
//		});
//		proxyFactory.addAdvice(new MethodInterceptor() {
//			@Override
//			public @Nullable Object invoke(MethodInvocation invocation) throws Throwable {
//				System.out.println("before proceed");
//				Object result = invocation.proceed();
//				System.out.println("after proceed");
//				return result;
//			}
//		});
		proxyFactory.addAdvisor(new PointcutAdvisor() {
			@Override
			public Pointcut getPointcut() {
				return new StaticMethodMatcherPointcut() {
					@Override
					public boolean matches(Method method, Class<?> targetClass) {
						return "test".equalsIgnoreCase(method.getName());
					}
				};
			}

			@Override
			public Advice getAdvice() {
//				return new MethodInterceptor() {
//					@Override
//					public @Nullable Object invoke(MethodInvocation invocation) throws Throwable {
//						System.out.println("before proceed");
//						Object result = invocation.proceed();
//						System.out.println("after proceed");
//						return result;
//					}
//				};

				return new MethodBeforeAdvice() {
					@Override
					public void before(Method method, @Nullable Object[] args, @Nullable Object target) throws Throwable {
						System.out.println("Before Advice");
					}
				};
			}

		});

		OrderService proxy = (OrderService)proxyFactory.getProxy();
		proxy.test();
	}
}