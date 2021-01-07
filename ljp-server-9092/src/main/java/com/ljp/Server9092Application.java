package com.ljp;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Server9092Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Server9092Application.class).web(WebApplicationType.SERVLET).run(args);
    }

}
