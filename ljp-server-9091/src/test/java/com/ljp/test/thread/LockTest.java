package com.ljp.test.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	private static final Lock lock = new ReentrantLock();
	private static final Condition condition = lock.newCondition();

	public static void main(String[] args) {
		new Thread(() -> {
			lock.lock();
			try {
				System.out.println("hahaha");
				condition.await();
				System.out.println("hehehe");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}).start();
		try {
			TimeUnit.SECONDS.sleep(1L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(() -> {
			lock.lock();
			try {
				System.out.println("9876543210");
				condition.signal();
				TimeUnit.SECONDS.sleep(1L);
				System.out.println("0123456789");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}).start();
	}

	@Test
	public void testOne() {
		Thread t1 = new Thread(() -> {
			for (; ; ) {
				System.out.println("-------------------------");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t1");
		// t1.setDaemon(true);
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
