package com.ljp.test.listener;

import org.springframework.core.annotation.Order;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("testListener")
@Order(1)
public class TestWebListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.err.println("TestWebListener is initialized ...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.err.println("TestWebListener is destroyed ...");
	}

}
