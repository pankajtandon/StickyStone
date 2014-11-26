package com.nayidisha.sticky.domain.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;



@Configuration
@EnableJpaRepositories
@Profile("dev")
public class DomainConfiguration {
	
	
	private Environment env;
	
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter adapter, DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("com.nayidisha.sticky.domain");
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(adapter);
        return emf;
    }

    @Bean
    JpaVendorAdapter adapter() {
    	return new HibernateJpaVendorAdapter();
    }
    
    @Bean
    public DataSource dataSource() {
    	return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.HSQL)
        .setScriptEncoding("UTF-8")
        .ignoreFailedDrops(true)
        .build();    	
    }
    
    @Bean
    PlatformTransactionManager transactionManager( EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
