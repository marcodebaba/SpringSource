package org.springframework;

import org.springframework.beans.OrderService;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * Description: CGLib动态代理
 * Author: Marco.Pan
 * Version: 1.0
 * Date: 2026年04月20日 16:20
 */
public class CGLibTest {
	public static void main(String[] args) {
		OrderService target = new OrderService();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallbacks(new Callback[]{(MethodInterceptor) (obj, method, args1, proxy) -> {
			System.out.println("before");
			method.invoke(target, args1);
			return null;
		}, NoOp.INSTANCE});
		enhancer.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method method) {
				return "test".equalsIgnoreCase(method.getName()) ? 0 : 1;
			}
		});

		OrderService proxy = (OrderService) enhancer.create();
		proxy.test();
	}
}