package com.ljp.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.jms.connection.JmsTransactionManager;

import javax.jms.ConnectionFactory;

@Configuration(proxyBeanMethods = false)
public class TransactionManagerConfiguration {

	@ConditionalOnSingleCandidate(ConnectionFactory.class)
	@Bean("jmsTransactionManager")
	JmsTransactionManager jmsTransactionManager(ConnectionFactory connectionFactory) {
		return new JmsTransactionManager(connectionFactory);
	}

	@ConditionalOnSingleCandidate(MongoDatabaseFactory.class)
	@Bean("mongoTransactionManager")
	MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory mongoDatabaseFactory) {
		return new MongoTransactionManager(mongoDatabaseFactory);
	}

}
