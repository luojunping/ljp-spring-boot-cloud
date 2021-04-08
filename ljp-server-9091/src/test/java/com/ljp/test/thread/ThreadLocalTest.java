package com.ljp.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

	private static final ThreadLocal<String> TL = new ThreadLocal();

	public static void main(String[] args) {
		TL.set("admin");
		String a = TL.get();
		System.out.println("a = " + a);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.execute(() -> {
				String b = TL.get();
				System.out.println(Thread.currentThread().getName() + " b = " + b);
			});
		}
		String c = TL.get();
		System.out.println("c = " + c);
	}

}
