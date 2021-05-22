package com.ljp.autoconfigure.jms;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import javax.jms.ConnectionFactory;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({JmsTemplate.class, PlatformTransactionManager.class})
@EnableConfigurationProperties({JmsProperties.class, ActiveMQProperties.class})
public class JmsTransactionManagerAutoConfiguration {

	@Configuration(proxyBeanMethods = false)
	static class JmsTransactionManagerConfiguration {

		@Bean("jmsTransactionManager")
		@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
		// @ConditionalOnSingleCandidate(ConnectionFactory.class)
		public JmsTransactionManager jmsTransactionManager(ConnectionFactory connectionFactory) {
			System.out.println("JmsTransactionManager is initialization ........................");
			return new JmsTransactionManager(connectionFactory);
		}

	}

}
