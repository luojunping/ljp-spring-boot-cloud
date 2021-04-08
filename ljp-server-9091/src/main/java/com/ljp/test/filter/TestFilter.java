package com.ljp.test.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "testFilter", urlPatterns = {"/*"})
public class TestFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		System.err.println("TestFilter.doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)");
		filterChain.doFilter(request, response);
	}

}
