package org.springframework;

import org.jspecify.annotations.Nullable;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.OrderService;
import org.springframework.context.annotation.*;

import java.lang.reflect.Method;

/**
 * Spring配置类
 * @ author marco.pan
 * @ version 1.0
 * @ date 2026年03月28日 23:07
 */
@Configuration
@ComponentScan("org.springframework.beans")
@EnableAspectJAutoProxy
//@Import(DefaultAdvisorAutoProxyCreator.class)
public class MyConfig {

//	@Bean
//	public ProxyFactoryBean proxyFactoryBean() {
//		ProxyFactoryBean factoryBean = new ProxyFactoryBean();
//		factoryBean.setTargetName("orderService");
//		factoryBean.addAdvice(new MethodBeforeAdvice() {
//			@Override
//			public void before(Method method, @Nullable Object[] args, @Nullable Object target) throws Throwable {
//				System.out.println("Before Advice");
//			}
//		});
//		return factoryBean;
//	}

//	@Bean
//	public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
//		BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
//		creator.setBeanNames("OrderSer*");
//		creator.setInterceptorNames("");
//
//		return creator;
//	}

	@Bean
	public DefaultPointcutAdvisor defaultPointcutAdvisor() {
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.addMethodName("test");

		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
		advisor.setPointcut(pointcut);
		advisor.setAdvice(new MethodBeforeAdvice() {
			@Override
			public void before(Method method, @Nullable Object[] args, @Nullable Object target) throws Throwable {
				System.out.println("Before Advice");
			}
		});

		return advisor;
	}

//	@Bean
//	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//		return new DefaultAdvisorAutoProxyCreator();
//	}
}
