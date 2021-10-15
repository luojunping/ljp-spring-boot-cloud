package com.ljp.test.pattern.singleton;

/**
 * 饿汉式单例模式
 */
public class EagerSingleton {

	private static final EagerSingleton singleton = new EagerSingleton();

	private EagerSingleton() {

	}

	public static EagerSingleton create() {
		return singleton;
	}

	public void say() {
		System.out.println("i am EagerSingleton...");
	}

}
