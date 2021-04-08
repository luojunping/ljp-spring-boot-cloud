package com.ljp.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyThread implements Runnable {

	private final CountDownLatch countDownLatch;

	public MyThread(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		countDownLatch.countDown();
		System.out.println(Thread.currentThread().getName() + "-------" + countDownLatch.getCount());
	}

}
