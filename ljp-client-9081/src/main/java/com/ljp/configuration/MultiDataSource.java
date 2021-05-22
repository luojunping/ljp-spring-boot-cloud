package com.ljp.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class MultiDataSource {

	@Primary
	@Bean("dataSourceOne")
	@ConfigurationProperties(prefix = "spring.datasource.one")
	DataSource dataSourceOne() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean("dataSourceTwo")
	@ConfigurationProperties(prefix = "spring.datasource.two")
	DataSource dataSourceTwo() {
		return DruidDataSourceBuilder.create().build();
	}

}
