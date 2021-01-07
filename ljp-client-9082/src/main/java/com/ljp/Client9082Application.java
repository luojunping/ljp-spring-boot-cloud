package com.ljp;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Client9082Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Client9082Application.class).web(WebApplicationType.SERVLET).run(args);
    }

}
