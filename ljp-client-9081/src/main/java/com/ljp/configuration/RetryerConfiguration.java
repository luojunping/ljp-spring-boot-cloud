package com.ljp.configuration;

import feign.Retryer;

// @Configuration(proxyBeanMethods = false)
public class RetryerConfiguration {

	//	@Bean
	public Retryer feignRetryer() {
		return new Retryer.Default(5, 30, 5);
	}

}
