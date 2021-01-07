package com.ljp.test;

import java.util.Properties;

public class JavaParameters {

    public static void main(String[] args) {
        String appId = System.getProperty("app.id");
        System.out.println(appId);
        System.setProperty("apollo.meta", "http://config-service-url");
        for (int i = 0; i < args.length; i++) {
            System.err.println(args[i]);
        }
        new Thread(() -> {
            System.out.println(System.getProperty("apollo.meta"));
        }).start();
        Properties properties = System.getProperties();
        properties.forEach((t, u) -> {
            System.out.println(t + "::" + u);
        });
    }

}
