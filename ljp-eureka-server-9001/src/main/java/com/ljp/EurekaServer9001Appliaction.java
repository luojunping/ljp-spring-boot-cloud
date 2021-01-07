package com.ljp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer9001Appliaction {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer9001Appliaction.class, args);
    }

}
