package com.ljp.test.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void testOne() {
        Map<String, Integer> mapp = new HashMap<>();
        Integer m1 = mapp.merge("helloWorld", 1, (t, u) -> {
            return t + u;
        });
        Integer m2 = mapp.merge("helloWorld", 2, (t, u) -> {
            return t + u;
        });
        Integer m3 = mapp.merge("helloWorld", 3, (t, u) -> {
            return t + u;
        });
        Integer m4 = mapp.merge("helloWorld", 4, (t, u) -> {
            return t + u;
        });
        Integer m5 = mapp.merge("helloWorld", 5, (t, u) -> {
            return t + u;
        });
        System.out.println(m1 + "-" + m2 + "-" + m3 + "-" + m4 + "-" + m5);
    }

}
