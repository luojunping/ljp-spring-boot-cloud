package com.ljp.test.gof.proxy;

import com.ljp.test.gof.common.RedTea;
import com.ljp.test.gof.common.Tea;

import java.lang.reflect.Proxy;

public class TeaTest {

	public static void main(String[] args) {
		Tea tea = new RedTea();
		tea.kindOfTea();
		System.out.println("-----------------------------");
		tea = new TeaStaticProxy();
		tea.kindOfTea();
		System.out.println("-----------------------------");
		tea = new RedTea();
		tea = (Tea) Proxy.newProxyInstance(TeaTest.class.getClassLoader(), new Class[]{Tea.class}, new TeaInvocationHandler(tea));
		tea.kindOfTea();
	}

}
