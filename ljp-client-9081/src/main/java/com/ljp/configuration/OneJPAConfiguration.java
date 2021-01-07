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

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.ljp.dao.one", entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanOne", transactionManagerRef = "platformTransactionManagerOne")
public class OneJPAConfiguration {

    @Autowired
    @Qualifier("dataSourceOne")
    DataSource dataSourceOne;
    @Autowired
    JpaProperties jpaProperties;

    @Primary
    @Bean("localContainerEntityManagerFactoryBeanOne")
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanOne(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceOne).packages("com.ljp.po.one").properties(jpaProperties.getProperties()).persistenceUnit("ljp-one").build();
    }

    @Primary
    @Bean("platformTransactionManagerOne")
    PlatformTransactionManager platformTransactionManagerOne(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean bean = localContainerEntityManagerFactoryBeanOne(builder);
        return new JpaTransactionManager(bean.getObject());
    }

}
