package com.ljp.test.controller;

import com.ljp.test.dto.UserDTO;
import com.ljp.test.service.TestTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestTestController {

	@Value("${server.port}")
	private String serverPort;

	@Autowired
	private TestTestService testTestService;

	@GetMapping("/test/test/helloWorld")
	public String helloWorld() {
		UserDTO userDTO = testTestService.helloWorld();
		return "hello world : " + serverPort + " : " + userDTO;
	}

	@GetMapping("/test/testTest")
	public String testTest() {
		log.debug("TestTestController.testTest() : {}", serverPort);
		log.error("TestTestController.testTest() : {}", serverPort);
		log.info("TestTestController.testTest() : {}", serverPort);
		return "TestTestController.testTest() : " + serverPort;
	}

}
