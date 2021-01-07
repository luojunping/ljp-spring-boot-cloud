package com.ljp.test.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("LJP-SERVER")
public interface TestTestService {

	@GetMapping("/ljp-server/test/test/helloWorld")
	String helloWorld();

	@GetMapping("/ljp-server/test/testTest")
	String testTest();

}
