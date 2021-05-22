package com.ljp.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/test/hello/world")
	public String world() {
		return "hello world !!!";
	}

}
