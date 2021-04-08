package com.ljp.test.thread;

import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			for (; ; ) {
				try {
					Thread.currentThread().wait(2000L);
					// TimeUnit.SECONDS.sleep(2);
					System.out.println(System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "test");
		thread.setDaemon(false);
		thread.start();
		TimeUnit.SECONDS.sleep(6);
	}

}
