package com.ljp.test.gof.decorator;

import com.ljp.test.gof.common.Tea;

/**
 * 装饰模式（decorator pattern）
 */
public class TeaDecorator implements Tea {

	private final Tea tea;

	public TeaDecorator(Tea tea) {
		this.tea = tea;
	}

	@Override
	public void kindOfTea() {
		System.out.println("这是一种饮品");
		tea.kindOfTea();
	}

}
