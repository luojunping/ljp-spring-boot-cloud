package com.ljp.test.optional;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		String str_null = "666";
		System.out.println(Optional.ofNullable(str_null).orElse(createStr("orElse")));
		System.out.println(Optional.ofNullable(str_null).orElseGet(() -> createStr("orElseGet")));
	}

	public static String createStr(String source) {
		System.out.printf("OptionalTest.createStr(%s)%n", source);
		return "hello world !!!";
	}

}
