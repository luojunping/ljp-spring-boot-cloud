package com.ljp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Objects;

@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories(basePackages = "com.ljp.**.dao.two", entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanTwo", transactionManagerRef = "jpaTransactionManagerTwo")
public class JpaTwoConfiguration {

	@Autowired
	@Qualifier("dataSourceTwo")
	DataSource dataSourceTwo;
	@Autowired
	JpaProperties jpaProperties;

	@Bean("localContainerEntityManagerFactoryBeanTwo")
	LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanTwo(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
		return entityManagerFactoryBuilder.dataSource(dataSourceTwo).packages("com.ljp.**.po.two").properties(jpaProperties.getProperties()).persistenceUnit("ljp-two").build();
	}

	@Bean("jpaTransactionManagerTwo")
	JpaTransactionManager jpaTransactionManagerTwo(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanTwo) {
		EntityManagerFactory entityManagerFactory = localContainerEntityManagerFactoryBeanTwo.getObject();
		Objects.requireNonNull(entityManagerFactory, "EntityManagerFactory entityManagerFactory is null : localContainerEntityManagerFactoryBeanTwo");
		return new JpaTransactionManager(entityManagerFactory);
	}

}
