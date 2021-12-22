package com.ljp.test.controller;

import com.ljp.test.service.SimpleTestService;
import com.ljp.test.service.impl.SimpleTestServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleTestController {

	@Autowired
	private SimpleTestService simpleTestService;
	@Autowired
	private SimpleTestServiceDemo simpleTestServiceDemo;

	@GetMapping("/test/simpleTest/testTransaction")
	public String testTransaction(@RequestParam("param") String param) {
		simpleTestServiceDemo.testTransaction(param);
		simpleTestService.testTransaction(param);
		return "hello world !!!";
	}

}
