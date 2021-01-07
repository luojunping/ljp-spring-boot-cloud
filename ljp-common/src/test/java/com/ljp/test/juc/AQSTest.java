package com.ljp.test.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "=start...");
			try {
				TimeUnit.SECONDS.sleep(2L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "=end...");
			lock.unlock();
		}, "t1");
		Thread t2 = new Thread(() -> {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "=start...");
			try {
				TimeUnit.SECONDS.sleep(2L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "=end...");
			lock.unlock();
		}, "t2");
		t1.start();
		t2.start();
	}

}
