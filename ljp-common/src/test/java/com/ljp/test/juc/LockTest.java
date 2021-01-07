package com.ljp.test.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + "=start...");
			// LockSupport.parkNanos(3 * 1000 * 1000 * 1000L);
			LockSupport.parkNanos(3000000000L);
			System.out.println(Thread.currentThread().getName() + "=end...");
		}, "t1");
		Thread t2 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + "=start...");
			LockSupport.park();
			System.out.println(Thread.currentThread().getName() + "=end...");
		}, "t2");
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		// LockSupport.unpark(t1);
		LockSupport.unpark(t2);
	}

}
