package com.ljp.test;

import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class JavaParameters {

	public static void main(String[] args) {
		String appId = System.getProperty("app.id");
		System.out.println(appId);
		System.setProperty("apollo.meta", "http://config-service-url");
		for (String arg : args) {
			System.err.println(arg);
		}
		new Thread(() -> {
			System.out.println(System.getProperty("apollo.meta"));
		}).start();
		Properties properties = System.getProperties();
		properties.forEach((t, u) -> {
			System.out.println(t + "::" + u);
		});
	}

	@Test
	public void testOne() {
		Object object = new Object();
		new Thread(() -> {
			System.out.println("one");
			try {
				object.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("three");
		}, "t1").start();
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("two");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			object.notifyAll();
		}, "t2").start();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
