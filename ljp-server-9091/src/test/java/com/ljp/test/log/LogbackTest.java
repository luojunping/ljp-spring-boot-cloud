package com.ljp.test.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogbackTest {

	public static void main(String[] args) {
		log.error("hello world : {}", LogbackTest.class.getName());
	}

}
