package com.pieropan.dualconnection.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories(
        basePackages = "com.pieropan.dualconnection.segundobanco.repository",
        entityManagerFactoryRef = "segundaEntityManager",
        transactionManagerRef = "segundaTransactionManager"
)
@Configuration
public class SegundoBancoConfig {

    @Bean(name = "segundoDataSource")
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSourceProperties segundoDataSource() {
        return new DataSourceProperties();
    }

    @Bean(name = "segundaEntityManager")
    public LocalContainerEntityManagerFactoryBean segundaEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(segundoDataSource().initializeDataSourceBuilder().build());
        em.setPackagesToScan("com.pieropan.dualconnection.segundobanco.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public PlatformTransactionManager segundaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(segundaEntityManager().getObject());

        return transactionManager;
    }
}