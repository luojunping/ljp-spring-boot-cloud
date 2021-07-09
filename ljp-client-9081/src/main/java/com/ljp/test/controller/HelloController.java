package com.ljp.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
public class HelloController {

	@GetMapping("/test/hello/world")
	public String world(HttpServletResponse response) {
		System.out.println("请求已进入 HelloController.world() ...");
		LocalDateTime expiresDateTime = LocalDateTime.of(2030, 12, 31, 23, 59, 59);
		LocalDateTime lastModifiedDateTime = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		response.addDateHeader("Expires", expiresDateTime.toEpochSecond(ZoneOffset.UTC) * 1000);
		response.addDateHeader("Last-Modified", lastModifiedDateTime.toEpochSecond(ZoneOffset.UTC) * 1000);
		response.addHeader("Cache-Control", "max-age=" + 7 * 24 * 60 * 60);
		return "hello world !!! ------------------------";
	}

}
