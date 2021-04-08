package com.ljp.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("testListener")
public class TestListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.err.println("TestListener is initialized ...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.err.println("TestListener is destroyed ...");
	}

}
