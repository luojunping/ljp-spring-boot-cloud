package com.ljp.test.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogbackTest {

	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = null;
		Boolean flag = false;// a*b的结果是int类型，那么c会强制拆箱成int类型，抛出NPE异常
		Integer result = (flag ? a * b : c);
		// log.error("hello world : {}", LogbackTest.class.getName());
		try {
			Thread thread = new Thread(() -> {
				System.out.println(1 / 0);
			});
			thread.start();
		} catch (Exception e) {
			System.out.println("hello world : " + e.getLocalizedMessage());
			log.error("hello world : {}", e.getLocalizedMessage());
		}
		method(null);
	}

	public static void method(String param) {
		switch (param) { // 肯定不是进入这里
			case "sth":
				System.out.println("it's sth");
				break; // 也不是进入这里
			case "null":
				System.out.println("it's null");
				break; // 也不是进入这里
			default:
				System.out.println("default");
		}
	}

}
