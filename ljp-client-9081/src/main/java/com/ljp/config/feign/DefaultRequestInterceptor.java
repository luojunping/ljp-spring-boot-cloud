package com.ljp.config.feign;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.Collection;
import java.util.Map;

public class DefaultRequestInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		Request request = template.request();
		Map<String, Collection<String>> headers = request.headers();
		System.out.println(template.headers());
	}

}
