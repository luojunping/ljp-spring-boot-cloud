package com.ljp;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Gateway9009Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Gateway9009Application.class).web(WebApplicationType.REACTIVE).run(args);
		// SpringApplication.run(Gateway9009Application.class, args);
	}

}
