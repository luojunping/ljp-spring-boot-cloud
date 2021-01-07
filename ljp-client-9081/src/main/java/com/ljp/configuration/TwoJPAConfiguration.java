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
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.ljp.dao.two", entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanTwo", transactionManagerRef = "platformTransactionManagerTwo")
public class TwoJPAConfiguration {

    @Autowired
    @Qualifier("dataSourceTwo")
    DataSource dataSourceTwo;
    @Autowired
    JpaProperties jpaProperties;

    @Bean("localContainerEntityManagerFactoryBeanTwo")
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanTwo(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceTwo).packages("com.ljp.po.two").properties(jpaProperties.getProperties()).persistenceUnit("ljp-two").build();
    }

    @Bean("platformTransactionManagerTwo")
    PlatformTransactionManager platformTransactionManagerTwo(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean bean = localContainerEntityManagerFactoryBeanTwo(builder);
        return new JpaTransactionManager(bean.getObject());
    }

}
