package com.ljp.test;

import org.apache.commons.lang3.math.NumberUtils;

public class UUIDTest {

    public static void main(String[] args) {
        String a = "0.5";
        String b = "0.5";
        System.out.println(NumberUtils.toDouble(a, 0D));
        System.out.println(NumberUtils.toDouble(b, 0D));
        System.out.println(NumberUtils.toDouble(a, 0D) == NumberUtils.toDouble(b, 0D));
    }

}
