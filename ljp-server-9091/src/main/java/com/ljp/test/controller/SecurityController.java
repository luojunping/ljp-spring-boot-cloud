package com.ljp.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/api/apiHello")
	public String apiHello() {
		return "hello api !!!";
	}

	@GetMapping("/admin/adminHello")
	public String adminHello() {
		return "hello admin !!!";
	}

	@GetMapping("/guest/guestHello")
	public String guestHello() {
		return "hello guest !!!";
	}

	@GetMapping("/other/otherHello")
	public String otherHello() {
		return "hello other !!!";
	}

}
