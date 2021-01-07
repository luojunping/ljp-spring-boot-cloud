package com.ljp.test.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestTest {

    private Object object = new Object();

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        for(int i = 0; i < 10; i++) {
            System.out.println("--------------------------" + i);
            new Thread(()->{
                lock.lock();
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("-------------1-------------");
                lock.unlock();
            }).start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(()->{
                lock.lock();
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("-------------2-------------");
                lock.unlock();
            }).start();
        }
    }

}
