package com.ljp.test.gof.proxy;

import com.ljp.test.gof.common.RedTea;
import com.ljp.test.gof.common.Tea;

/**
 * 静态代理模式（static proxy pattern）
 */
public class TeaStaticProxy implements Tea {

	private final Tea tea;

	public TeaStaticProxy() {
		tea = new RedTea();
	}

	@Override
	public void kindOfTea() {
		System.out.println("这是一种饮品");
		tea.kindOfTea();
	}

}
