package com.ljp.test.controller;

import com.ljp.test.service.ActivemqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class ActivemqController {

	@Autowired
	private ActivemqService activemqService;

	@GetMapping("/test/activemq/send/text/message")
	public void sendTextMessage(String textMessage) {
		activemqService.sendTextMessage(textMessage);
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("this is init postConstruct...");
		System.out.println("this is init postConstruct...");
		System.out.println("this is init postConstruct...");
	}

}
