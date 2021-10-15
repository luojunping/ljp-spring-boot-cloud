package com.ljp.test.gof.decorator;

import com.ljp.test.gof.common.RedTea;
import com.ljp.test.gof.common.Tea;

public class TeaTest {

	public static void main(String[] args) {
		Tea tea = new RedTea();
		tea.kindOfTea();
		System.out.println("-----------------------------");
		tea = new TeaDecorator(tea);
		tea.kindOfTea();
	}

}
