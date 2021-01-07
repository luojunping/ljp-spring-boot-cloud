package com.ljp.test.controller;

import com.ljp.test.service.TestTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestTestController {

	private static final String TEST_URL = "http://LJP-SERVER/";

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private TestTestService testTestService;

	@GetMapping("/test/test/helloWorld")
	public String helloWorld() {
		return restTemplate.getForObject(TEST_URL + "ljp-server/test/test/helloWorld", String.class);
	}

	@GetMapping("/test/test/helloWorldOpenFeign")
	public String helloWorldOpenFeign() {
		return "OpenFeign" + testTestService.helloWorld();
	}

	@GetMapping("/test/testTest")
	public String testTest() {
		return restTemplate.getForObject(TEST_URL + "ljp-server/test/testTest", String.class);
	}

	@GetMapping("/test/testTestOpenFeign")
	public String testTestOpenFeign() {
		return "OpenFeign : " + testTestService.testTest();
	}

}
