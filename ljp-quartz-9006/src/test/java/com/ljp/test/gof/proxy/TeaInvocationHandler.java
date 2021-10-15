package com.ljp.test.gof.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TeaInvocationHandler implements InvocationHandler {

	private final Object target;

	public TeaInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("这是一种饮品");
		return method.invoke(target, args);
	}

}
