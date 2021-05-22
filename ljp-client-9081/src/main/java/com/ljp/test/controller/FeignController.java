package com.ljp.test.controller;

import com.ljp.test.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
public class FeignController {

	@Autowired
	private FeignService feignService;

	@GetMapping("/test/feign/hello/world")
	public String helloWorld(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName() + " : " + cookie.getValue());
			}
		}
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		Enumeration<String> attributeNames = session.getAttributeNames();
		attributeNames.asIterator().forEachRemaining(name -> {
			System.out.println(session.getAttribute(name));
		});
		return feignService.helloWorld();
	}

	@PostMapping("/test/feign/hello/china")
	public String helloChina(String hello) {
		return feignService.helloChina(hello);
	}

}
