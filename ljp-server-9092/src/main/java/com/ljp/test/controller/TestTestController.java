package com.ljp.test.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class TestTestController {

	@Value("${server.port:9092}")
	private String serverPort;
	@Value("${time.spent:100}")
	private String timeSpent;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@GetMapping("/test/test/helloWorld")
	public String helloWorld() {
		stringRedisTemplate.opsForValue().setIfAbsent("helloWorld", "1", 20, TimeUnit.SECONDS);
		stringRedisTemplate.opsForHash().put("user", "name", "zhangsan");
		stringRedisTemplate.opsForHash().put("user", "age", "18");
		stringRedisTemplate.opsForHash().put("user", "sex", "男");
		Long helloWorld = stringRedisTemplate.opsForValue().increment("helloWorld");
		return "hello world : " + serverPort + " : " + helloWorld;
	}

	@GetMapping("/test/test/request")
	public String request(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String token = httpServletRequest.getHeader("jwt-token");
		return serverPort + " : " + token;
	}

	@GetMapping("/test/test/response")
	public String response(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String token = JWT.create().withClaim("userName", "userName").withExpiresAt(new Date())
				.sign(Algorithm.HMAC512("6666"));
		httpServletResponse.addHeader("jwt-token", token);
		return serverPort + " : " + token;
	}

	@GetMapping("/test/test/apollo")
	public String apollo() {
		log.info("serverPort: {}, timeSpent: {} !!!", serverPort, timeSpent);
		System.out.println("--------------------------------------------------");
		log.error("serverPort: {}, timeSpent: {} !!!", serverPort, timeSpent);
		return String.format("From apollo serverPort: %s, timeSpent: %s !!!", serverPort, timeSpent);
	}

}
