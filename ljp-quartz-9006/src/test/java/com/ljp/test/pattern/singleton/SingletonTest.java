package com.ljp.test.pattern.singleton;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 20; i++) {
			executorService.execute(() -> {
				LazySingleton lazySingleton = LazySingleton.create();
				System.out.println("lazySingleton = " + lazySingleton);
				EagerSingleton eagerSingleton = EagerSingleton.create();
				System.out.println("eagerSingleton = " + eagerSingleton);
				DoubleLockSingleton doubleLockSingleton = DoubleLockSingleton.create();
				System.out.println("doubleLockSingleton = " + doubleLockSingleton);
				InnerClassSingleton innerClassSingleton = InnerClassSingleton.create();
				System.out.println("innerClassSingleton = " + innerClassSingleton);
				EnumSingle enumSingle = EnumSingle.SINGLE;
				System.out.println("enumSingle = " + enumSingle);
			});
		}
	}

	@Test
	public void testLazySingleton() {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 20; i++) {
			executorService.execute(() -> {
				LazySingleton lazySingleton = LazySingleton.create();
				System.out.println("lazySingleton = " + lazySingleton);
			});
		}
	}

	@Test
	public void testEagerSingleton() {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 20; i++) {
			executorService.execute(() -> {
				EagerSingleton eagerSingleton = EagerSingleton.create();
				System.out.println("eagerSingleton = " + eagerSingleton);
			});
		}
	}

	@Test
	public void testDoubleLockSingleton() {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 20; i++) {
			executorService.execute(() -> {
				DoubleLockSingleton doubleLockSingleton = DoubleLockSingleton.create();
				doubleLockSingleton.say();
				System.out.println("doubleLockSingleton = " + doubleLockSingleton);
			});
		}
	}

	@Test
	public void testInnerClassSingleton() {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 20; i++) {
			executorService.execute(() -> {
				InnerClassSingleton innerClassSingleton = InnerClassSingleton.create();
				System.out.println("innerClassSingleton = " + innerClassSingleton);
			});
		}
	}

	@Test
	public void testEnumSingle() {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 20; i++) {
			executorService.execute(() -> {
				EnumSingle enumSingle = EnumSingle.SINGLE;
				System.out.println("enumSingle = " + enumSingle);
			});
		}
	}

}
