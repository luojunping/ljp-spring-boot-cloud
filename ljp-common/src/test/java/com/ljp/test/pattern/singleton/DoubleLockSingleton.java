package com.ljp.test.pattern.singleton;

/**
 * 双层锁懒汉式单例模式
 */
public class DoubleLockSingleton {

	private static DoubleLockSingleton singleton = null;

	private DoubleLockSingleton() {

	}

	public static DoubleLockSingleton create() {
		if (singleton == null) {
			synchronized (DoubleLockSingleton.class) {
				if (singleton == null) {
					singleton = new DoubleLockSingleton();
				}
			}
		}
		return singleton;
	}

	public void say() {
		System.out.println("i am DoubleLockSingleton...");
	}

}
