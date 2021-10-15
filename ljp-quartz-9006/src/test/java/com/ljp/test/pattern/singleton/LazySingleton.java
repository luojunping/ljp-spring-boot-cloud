package com.ljp.test.pattern.singleton;

/**
 * 懒汉式单例模式
 */
public class LazySingleton {

	private static LazySingleton singleton = null;

	private LazySingleton() {

	}

	public static LazySingleton create() {
		if (singleton == null) {
			singleton = new LazySingleton();
		}
		return singleton;
	}

	public void say() {
		System.out.println("i am LazySingleton...");
	}

}
