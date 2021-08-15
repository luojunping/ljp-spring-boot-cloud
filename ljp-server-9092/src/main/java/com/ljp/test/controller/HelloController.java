package com.ljp.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/test/hello/world")
	public String world(String hello) {
		System.err.println("----------" + hello + "----------");
		return "hello world !!! from: " + serverPort;
	}

	@PostMapping("/test/hello/china")
	public String china(String hello) {
		System.err.println("----------" + hello + "----------");
		return "hello world !!! from: " + serverPort;
	}

}
