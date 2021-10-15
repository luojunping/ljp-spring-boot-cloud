package com.ljp.test.unsafe;

import org.junit.jupiter.api.Test;

public class StackOverflowErrorErrorTest {

	private int stackLength = 0;

	public static void main(String[] args) {
		StackOverflowErrorErrorTest sof = new StackOverflowErrorErrorTest();
		try {
			sof.stackLeak();
		} catch (Throwable t) {
			System.out.println(sof.stackLength);
			// t.printStackTrace();
		}
	}

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	@Test
	public void testOne() {
		String a = "hello";
		String b = "hello";
		System.out.println(a == b);
	}

}
