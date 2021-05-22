package com.ljp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Objects;

@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories(basePackages = "com.ljp.**.dao.one", entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanOne", transactionManagerRef = "jpaTransactionManagerOne")
public class JpaOneConfiguration {

	@Autowired
	@Qualifier("dataSourceOne")
	DataSource dataSourceOne;
	@Autowired
	JpaProperties jpaProperties;

	@Primary
	@Bean("localContainerEntityManagerFactoryBeanOne")
	LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanOne(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
		return entityManagerFactoryBuilder.dataSource(dataSourceOne).packages("com.ljp.**.po.one").properties(jpaProperties.getProperties()).persistenceUnit("ljp-one").build();
	}

	@Primary
	@Bean("jpaTransactionManagerOne")
	PlatformTransactionManager jpaTransactionManagerOne(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanOne) {
		EntityManagerFactory entityManagerFactory = localContainerEntityManagerFactoryBeanOne.getObject();
		Objects.requireNonNull(entityManagerFactory, "EntityManagerFactory entityManagerFactory is null : localContainerEntityManagerFactoryBeanOne");
		return new JpaTransactionManager(entityManagerFactory);
	}

}
