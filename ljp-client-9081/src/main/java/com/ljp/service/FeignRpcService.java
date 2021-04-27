package com.ljp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "LJP-SERVER")
public interface FeignRpcService {

	@GetMapping("/ljp-server/test/testTest")
	String testTest();

}
