package com.ljp.test.configuration;

import com.google.common.collect.Lists;
import com.ljp.test.filter.TestFilter;
import com.ljp.test.listener.TestListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ServletConfiguration {

	@Bean
	public FilterRegistrationBean<TestFilter> testFilter() {
		FilterRegistrationBean<TestFilter> filterRegistrationBean = new FilterRegistrationBean<>(new TestFilter());
		filterRegistrationBean.setName("testFilter");
		filterRegistrationBean.setUrlPatterns(Lists.newArrayList("/*"));
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean<TestListener> testListener() {
		ServletListenerRegistrationBean<TestListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new TestListener());
		servletListenerRegistrationBean.setOrder(1);
		return servletListenerRegistrationBean;
	}

}
