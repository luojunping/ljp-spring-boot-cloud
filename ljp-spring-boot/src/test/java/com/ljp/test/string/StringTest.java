package com.ljp.test.string;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void testOne() {
        String testStr = "思想政治,历史,地理(3门科目考生均须选考方可报考)";
        String[] tempArray = testStr.replace("历史", "").split(",");
        for (String s : tempArray) {
            System.out.println(s);
        }
    }

}
