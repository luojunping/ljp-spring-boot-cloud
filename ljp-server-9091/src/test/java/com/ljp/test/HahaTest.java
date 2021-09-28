package com.ljp.test;

import java.util.concurrent.TimeUnit;

public class HahaTest {

	public static void main(String[] args) {
		HahaTest hahaTest = new HahaTest();
		new Thread(hahaTest::sayHello).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(hahaTest::sayWorld).start();
	}

	public synchronized void sayHello() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hello hello hello");
	}

	public synchronized void sayWorld() {
		System.out.println("world world world");
	}

}
