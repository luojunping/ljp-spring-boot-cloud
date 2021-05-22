package com.ljp.configuration;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class RetryerConfiguration {

	@Bean
	public Retryer feignRetryer() {
		return new Retryer.Default(5, 30, 5);
	}

}
