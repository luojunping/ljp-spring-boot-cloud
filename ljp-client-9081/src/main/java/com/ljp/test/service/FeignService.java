package com.ljp.test.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "LJP-SERVER")
public interface FeignService {

	@GetMapping("/ljp-server/test/hello/world")
	String helloWorld();

	@PostMapping("/ljp-server/test/hello/china")
	String helloChina(@RequestParam("hello") String hello);

}
