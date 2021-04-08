package com.ljp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEurekaClient
@EnableJms
@MapperScan(basePackages = "com.ljp.**.dao")
@ServletComponentScan
@EnableWebMvc
public class Server9091Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Server9091Application.class).web(WebApplicationType.SERVLET).run(args);
	}

//    @Bean
//    public PaginationInnerInterceptor paginationInnerInterceptor() {
//        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
//        paginationInnerInterceptor.setDbType(DbType.MYSQL);
//        paginationInnerInterceptor.setMaxLimit(1000L);
//        return paginationInnerInterceptor;
//    }

}
