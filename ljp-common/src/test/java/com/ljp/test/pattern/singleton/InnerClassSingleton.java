package com.ljp.test.pattern.singleton;

/**
 * 内部类式单例模式
 */
public class InnerClassSingleton {

	private InnerClassSingleton() {

	}

	public static InnerClassSingleton create() {
		return InnerClassSingletonHolder.singleton;
	}

	public void say() {
		System.out.println("i am InnerClassSingleton...");
	}

	private static class InnerClassSingletonHolder {

		private static final InnerClassSingleton singleton = new InnerClassSingleton();

	}

}
