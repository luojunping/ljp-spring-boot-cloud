package com.ljp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan(basePackages = "com.ljp.**.mybatis.dao")
//@EnableEurekaClient
@EnableJms
@ServletComponentScan
@EnableWebMvc
public class Server9091Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Server9091Application.class).web(WebApplicationType.SERVLET).run(args);
	}

	@Bean
	public PaginationInnerInterceptor paginationInnerInterceptor() {
		PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
		paginationInnerInterceptor.setDbType(DbType.MYSQL);
		paginationInnerInterceptor.setMaxLimit(1000L);
		return paginationInnerInterceptor;
	}

}
