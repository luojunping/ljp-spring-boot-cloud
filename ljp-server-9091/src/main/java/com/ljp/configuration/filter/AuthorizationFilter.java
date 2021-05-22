package com.ljp.configuration.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@WebFilter(filterName = "authorizationFilter", urlPatterns = {"/*"})
public class AuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		System.err.println("------------------------------------------------------");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.err.println(cookie.getName() + " : " + cookie.getValue());
//				if ("HelloWorld".equals(cookie.getValue())) {
//					response.sendError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
//					return;
//				}
			}
		}
		System.err.println("------------------------------------------------------");
		filterChain.doFilter(request, response);
	}

}
