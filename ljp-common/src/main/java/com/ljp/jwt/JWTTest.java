package com.ljp.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JWTTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 15 * 24);
		String token = JWT.create().withClaim("loginName", "loginName").withClaim("userName", "userName")
				.withClaim("email", "111111@qq.com").withExpiresAt(calendar.getTime())
				.sign(Algorithm.HMAC512("password"));
		System.out.println("token = " + token);
		JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512("password")).build();
		DecodedJWT decodedJWT = jwtVerifier.verify(token);
		System.out.println("decodedJWT.getHeader() = " + decodedJWT.getHeader());
		System.out.println("decodedJWT.getPayload() = " + decodedJWT.getPayload());
		System.out.println("decodedJWT.getSignature() = " + decodedJWT.getSignature());
		System.out.println("decodedJWT.getToken() = " + decodedJWT.getToken());
		System.out.println("decodedJWT.getAlgorithm() = " + decodedJWT.getAlgorithm());
		System.out.println(
				"decodedJWT.getClaim(\"loginName\").asString() = " + decodedJWT.getClaim("loginName").asString());
		System.out.println("decodedJWT.getContentType() = " + decodedJWT.getContentType());
		System.out.println("decodedJWT.getExpiresAt() = "
				+ new SimpleDateFormat("yyyy-MM-dd hh:mm:sss").format(decodedJWT.getExpiresAt()));
	}

}
