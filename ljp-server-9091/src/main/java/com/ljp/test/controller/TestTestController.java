package com.ljp.test.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ljp.test.dto.UserDTO;
import com.ljp.test.service.TestTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

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
		return "TestTestController.testTest() : " + serverPort;
	}

	@GetMapping("/test/cookie/add")
	public String addCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = new Cookie("addCookie", "/test/cookie/add");
		cookie.setMaxAge(60 * 60 * 24 * 7);
		cookie.setPath("/");
		response.addCookie(cookie);
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("Asia/Chongqing")));
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		String token = JWT.create().withClaim("username", "username").withExpiresAt(calendar.getTime())
				.sign(Algorithm.HMAC512("token"));
		cookie = new Cookie("token", token);
		cookie.setMaxAge(60 * 60 * 24 * 7);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "TestTestController.addCookie() : " + serverPort;
	}

	@GetMapping("/test/cookie/delete")
	public String deleteCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return "TestTestController.deleteCookie() : " + serverPort;
	}

	@GetMapping("/test/session/add")
	public String addSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.setAttribute("session", "session");
		session.setAttribute("hahaha", "hahaha");
		return "TestTestController.addSession() : " + serverPort;
	}

	@GetMapping("/test/session/delete")
	public String deleteSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("hahaha");
		session.invalidate();
		return "TestTestController.deleteSession() : " + serverPort;
	}

	@GetMapping("/test/hello")
	public String hello(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		log.info("hello------------------------{}", name);
		log.error("hello------------------------{}", name);
		return "hello : " + name;
	}

}
