package com.ljp.test.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 1000000000; i++) {
				if (Thread.interrupted())
					break;
				System.out.println(i);
				// try {
				// TimeUnit.SECONDS.sleep(1);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
			}
		});
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		thread.interrupt();
	}

}
