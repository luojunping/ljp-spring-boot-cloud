package com.ljp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceTransactionManagerAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
public class ClientOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientOneApplication.class, args);
	}

}
