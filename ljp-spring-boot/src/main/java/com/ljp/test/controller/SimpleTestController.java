package com.ljp.test.controller;

import com.ljp.test.service.SimpleTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleTestController {

	@Autowired
	private SimpleTestService simpleTestService;


}
