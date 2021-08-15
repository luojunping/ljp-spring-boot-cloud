package com.ljp.test.number;

import org.junit.jupiter.api.Test;

public class NumberTest {

	@Test
	public void testOne() {
		Integer a = Integer.valueOf(999999);
		int b = 999999;
		System.out.println("a.equals(b) = " + a.equals(b));
		System.out.println("a == b = " + (a == b));
		float c = 1.0F - 09.F;
		float d = 0.9F - 0.8F;
		if (c == d) {
			System.out.println("c == d");
		}
		if ((c - d) <= Float.MIN_VALUE) {
			// System.out.println("c == d");
		}
		if ((c - d) == Float.MIN_VALUE) {
			System.out.println("c == d");
		}
		System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
		Float e = Float.valueOf(c);
		Float f = Float.valueOf(d);
		System.out.println("e.equals(f) = " + e.equals(f));
		byte aa = 2;
		byte bb = 6;
	}

}
