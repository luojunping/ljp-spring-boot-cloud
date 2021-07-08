package com.ljp.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthorizationRequestInterceptor implements RequestInterceptor {

	private static final String COOKIE = "Cookie";
	private static final String AUTHORIZATION = "Authorization";

	@Override
	public void apply(RequestTemplate template) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (requestAttributes != null) {
			HttpServletRequest request = requestAttributes.getRequest();
			template.header(COOKIE, request.getHeader(COOKIE));
			template.header(AUTHORIZATION, request.getHeader(AUTHORIZATION));
		}
	}

}
