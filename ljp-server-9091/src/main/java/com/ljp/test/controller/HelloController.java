package com.ljp.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

	@GetMapping("/test/hello/world")
	public String world() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello world !!!";
	}

	@PostMapping("/test/hello/china")
	public String china(String hello) {
		System.out.println("-------------------------" + hello);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello world !!!";
	}

}
