package com.nayidisha.sticky.domain.config;

import java.util.Properties;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;



@Configuration
@ComponentScan (basePackages="com.nayidisha.sticky.domain")
@EnableJpaRepositories
//@PropertySource({"classpath:application-${profile}.properties", "classpath:application.properties"})
@PropertySource({"classpath:application.properties"})

public class DomainConfiguration {
	
	//private static final String H2_JDBC_URL_TEMPLATE = "jdbc:h2:%s/target/db/sticky;AUTO_SERVER=TRUE";
	
	@Inject
	private Environment env;

	@Profile("loc")	
	@Bean
	public DataSource dataSourceH2() throws Exception {
		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName(env.getRequiredProperty("db.driver"));
	    ds.setUrl(env.getRequiredProperty("db.url"));
	    ds.setUsername(env.getRequiredProperty("db.username"));
	    ds.setPassword(env.getRequiredProperty("db.password"));

	    return ds;
	}
	
	@Profile("dev")	
	@Bean
	public DataSource dataSourceMySQl() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        dataSource.setUsername(env.getRequiredProperty("db.username"));
        dataSource.setPassword(env.getRequiredProperty("db.password"));
         
        return dataSource;
	}
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory); 
	    return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties jpaProperties) throws Exception {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(Boolean.TRUE);
	    vendorAdapter.setShowSql(Boolean.TRUE);     

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setPersistenceUnitName("sticky");
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.nayidisha.sticky.domain");
	    factory.setDataSource(dataSource);     

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
