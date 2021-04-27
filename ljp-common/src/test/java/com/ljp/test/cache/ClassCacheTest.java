package com.ljp.test.cache;

public class ClassCacheTest {

	public static void main(String[] args) {
//		Integer a = new Integer(129);
//		Integer b = new Integer(129);
//		Integer c = Integer.valueOf(129);
//		Integer d = Integer.valueOf(129);
//		Integer e = 129;
//		Integer f = 129;
//		System.out.println(a == b);
//		System.out.println(b == c);
//		System.out.println(c == d);
//		System.out.println(d == e);
//		System.out.println(e == f);
		String s1 = "java工程师";
		String s2 = s1.intern();
		System.out.println("s1==s2:" + (s1 == s2));
		String s3 = "java工程师";
		System.out.println("s2==s3:" + (s2 == s3));
		System.out.println("s1==s3:" + (s1 == s3));
		String str_1 = "1" + "1";
		String str_3 = str_1.intern();
		String str_2 = "11";
		System.out.println(str_1 == str_2);// true
	}

}
