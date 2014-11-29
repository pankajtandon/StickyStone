package com.nayidisha.sticky.domain.config;

import java.util.Properties;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan (basePackages="com.nayidisha.sticky.domain")
@Import({H2DataSourceConfiguration.class, MySQLDataSourceConfiguration.class})
@EnableJpaRepositories
public class DomainConfiguration { 	

	
	@Inject
	private PersistableConfiguration persistableConfiguration;
		

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory); 
	    return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(Properties jpaProperties) throws Exception {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(Boolean.TRUE);
	    vendorAdapter.setShowSql(Boolean.TRUE);   
	    vendorAdapter.setDatabasePlatform(persistableConfiguration.getDialect());

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setPersistenceUnitName("sticky");
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.nayidisha.sticky.domain");
	    factory.setDataSource(persistableConfiguration.getDataSource());

	    factory.setJpaProperties(jpaProperties);
	    factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());

	    return factory;
	}

	Properties jpaProperties() {
	    Properties props = new Properties();
	    props.put("hibernate.query.substitutions", "true 'Y', false 'N'");
	    props.put("hibernate.hbm2ddl.auto", "create-drop");
	    props.put("hibernate.show_sql", "false");
	    props.put("hibernate.format_sql", "true");

	    return props;
	}


}
