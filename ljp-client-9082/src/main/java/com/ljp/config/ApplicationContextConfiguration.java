package com.ljp.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfiguration {

    @Bean
    @Scope("singleton")
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
