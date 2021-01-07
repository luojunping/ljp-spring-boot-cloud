package com.ljp.test.gc;

import java.lang.ref.PhantomReference;

public class GCTest {

    public static void main(String[] args) {
        int[] intArray = new int[1024 * 1024 * 128];
        intArray = null;
        System.out.println("--------------");
        intArray = new int[1024 * 1024 * 128];
        intArray = null;
        System.out.println("--------------");
        intArray = new int[1024 * 1024 * 128];
        intArray = null;
        PhantomReference phantomReference = new PhantomReference(intArray, null);
        phantomReference.get();
    }

}
