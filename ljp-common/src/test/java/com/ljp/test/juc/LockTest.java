package com.ljp.test.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {

	public static void main(String[] args) {
//		Thread t1 = new Thread(() -> {
//			System.out.println(Thread.currentThread().getName() + "=start...");
//			// LockSupport.parkNanos(3 * 1000 * 1000 * 1000L);
//			LockSupport.parkNanos(3000000000L);
//			System.out.println(Thread.currentThread().getName() + "=end...");
//		}, "t1");
//		Thread t2 = new Thread(() -> {
//			System.out.println(Thread.currentThread().getName() + "=start...");
//			LockSupport.park();
//			System.out.println(Thread.currentThread().getName() + "=end...");
//		}, "t2");
//		t1.start();
//		try {
//			TimeUnit.SECONDS.sleep(1L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		t2.start();
//		// LockSupport.unpark(t1);
//		LockSupport.unpark(t2);
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		Lock readLock = readWriteLock.readLock();
		Lock writeLock = readWriteLock.writeLock();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				readLock.lock();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
				readLock.unlock();
			}, "r_t" + i).start();
		}
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				writeLock.lock();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
				writeLock.unlock();
			}, "w_t" + i).start();
		}
	}

	@Test
	public void testOne() {
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		Lock readLock = readWriteLock.readLock();
		Lock writeLock = readWriteLock.writeLock();
		for (int i = 0; i < 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Thread(() -> {
				readLock.lock();
				System.out.println(Thread.currentThread().getName());
				readLock.unlock();
			}, "r_t" + i).start();
		}
		for (int i = 0; i < 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Thread(() -> {
				writeLock.lock();
				System.out.println(Thread.currentThread().getName());
				writeLock.unlock();
			}, "w_t" + i).start();
		}
	}

}
