package com.ljp.test.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(10);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
//			try {
//				TimeUnit.SECONDS.sleep(1L);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			executorService.execute(new MyThread(countDownLatch));
		}
		countDownLatch.await();
		System.out.println("----------------------------------");
	}

	@Test
	public void testOne() {
		String a = "hello";
		String b = "hello";
		String c = "hello";
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(b == c);
	}

	@Test
	public void testTwo() {
		final String a = "hello";
		new Thread(() -> {
			String b = "hello";
			String c = "hello";
			System.out.println(a == b);
			System.out.println(a == c);
			System.out.println(b == c);
		}).start();
	}

}
