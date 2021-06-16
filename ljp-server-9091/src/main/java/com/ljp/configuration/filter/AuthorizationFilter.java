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
				if ("HelloWorld".equals(cookie.getValue())) {
//					System.out.println("request.getScheme() = " + request.getScheme());
//					System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
//					System.out.println("request.getRemotePort() = " + request.getRemotePort());
//					System.out.println("request.getContextPath() = " + request.getContextPath());
//					System.out.println("request.getServletPath() = " + request.getServletPath());
//					System.out.println("request.getRequestURI() = " + request.getRequestURI());
//					System.out.println("request.getRequestURL() = " + request.getRequestURL());
//					System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
//					System.out.println("request.getProtocol() = " + request.getProtocol());
//					System.out.println("request.getServerName() = " + request.getServerName());
//					System.out.println("request.getServerPort() = " + request.getServerPort());
					response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
					response.sendRedirect("http://127.0.0.1:9081/ljp-client/test/hello/world");
					return;
				}
			}
		}
		System.err.println("------------------------------------------------------");
		filterChain.doFilter(request, response);
	}

}
