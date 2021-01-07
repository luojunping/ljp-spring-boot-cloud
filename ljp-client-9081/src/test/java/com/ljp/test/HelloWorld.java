package com.ljp.test;

import java.util.Scanner;

class NotPositiveException extends Exception {

}

public class HelloWorld {

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++) {
            System.out.println("输入一个正整数");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            try {
                int x = Integer.parseInt(str);
                if ( x <= 0) throw new NotPositiveException();
            } catch(NotPositiveException e) {
                System.out.println("应该输入大于0的整数");
            } catch(NumberFormatException e) {
                System.out.println(str + "不是整数字符串");
            } finally {
                System.out.println("输入的数是：" + str);
            }
        }
    }

}
