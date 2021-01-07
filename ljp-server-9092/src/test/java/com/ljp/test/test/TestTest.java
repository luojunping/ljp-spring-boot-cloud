package com.ljp.test.test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestTest {

    public static void main(String[] args) {
        TestTest testTest = new TestTest();
        System.out.println(TestTest.getNumber());
    }

    private static int getNumber() {
        int a = 1;
        try {
            final int w = 1 / 0;
            return a;
        } catch (Exception e) {
            a = 2;
            return a;
        } finally {
            a = 3;
            return a;
        }
    }

    @Test
    public void testOne() {
        final String wd = "1a2sdfds3fdsf7fdf9sdf41sdf4";
        System.out.println("----------------------");
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(wd);
        boolean flag = matcher.find();
        while (flag) {
            System.out.print(matcher.group());
            flag = matcher.find();
        }
        System.out.println("\n----------------------");
        System.out.println(matcher.replaceAll("6"));
    }

    @Test
    public void testTwo() {
        ArrayList<String> arrayList = Lists.newArrayList("a", "b", "c", "d");
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        ImmutableList<String> immutableList = ImmutableList.copyOf(arrayList);
        arrayList.add("e");
        arrayList.add("f");
        System.out.println("arrayList=" + arrayList.size());
        System.out.println("unmodifiableList=" + unmodifiableList.size());
        System.out.println("immutableList=" + immutableList.size());
    }

    @Test
    public void testThree() throws IOException {
        File file = new File("C:\\Users\\jpluo\\Desktop\\pop.css");
        System.out.println("getAbsolutePath()=" + file.getAbsolutePath());
        System.out.println("getCanonicalPath()=" + file.getCanonicalPath());
        System.out.println("getName()=" + file.getName());
        System.out.println("getParent()=" + file.getParent());
        System.out.println("getPath()=" + file.getPath());
        System.out.println("toString()=" + file.toString());
        System.out.println("toPath()=" + file.toPath());
        System.out.println("getFreeSpace()=" + (file.getFreeSpace() / 1024 / 1024 / 1024) + "GB");
        System.out.println("getTotalSpace()=" + (file.getTotalSpace() / 1024 / 1024 / 1024) + "GB");
        System.out.println("getUsableSpace()=" + (file.getUsableSpace() / 1024 / 1024 / 1024) + "GB");
    }

    @Test
    public void testFour() throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String hostName = inetAddress.getHostName();
        String hostAddress = inetAddress.getHostAddress();
        System.out.println("hostName = " + hostName);
        System.out.println("hostAddress = " + hostAddress);
        inetAddress = Inet4Address.getLocalHost();
        hostName = inetAddress.getHostName();
        hostAddress = inetAddress.getHostAddress();
        System.out.println("hostName = " + hostName);
        System.out.println("hostAddress = " + hostAddress);
        inetAddress = Inet6Address.getLocalHost();
        hostName = inetAddress.getHostName();
        hostAddress = inetAddress.getHostAddress();
        System.out.println("hostName = " + hostName);
        System.out.println("hostAddress = " + hostAddress);
        hostName = inetAddress.getCanonicalHostName();
        byte[] address = inetAddress.getAddress();
        System.out.println("hostName = " + hostName);
        System.out.println("hostAddress = " + address[0] + "." + address[1] + "." + address[2] + "." + address[3]);
    }

}
