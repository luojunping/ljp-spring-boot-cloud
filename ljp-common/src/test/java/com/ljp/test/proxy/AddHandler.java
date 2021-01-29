package com.ljp.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AddHandler<T> implements InvocationHandler {

	private final T t;

	public AddHandler(T t) {
		this.t = t;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName() + " add start ...");
		Object object = method.invoke(t, args);
		System.out.println(method.getName() + " add end ...");
		return object;
	}
}
