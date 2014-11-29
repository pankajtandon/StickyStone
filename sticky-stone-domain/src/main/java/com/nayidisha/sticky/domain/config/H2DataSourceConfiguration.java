package com.nayidisha.sticky.domain.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Configuration

@Profile("loc")	
@PropertySource({"classpath:application.properties", "classpath:application-loc.properties"})
public class H2DataSourceConfiguration implements PersistableConfiguration {

	@Inject
	private Environment env;
	
	@Bean
	@Override
	public DataSource getDataSource()  {
		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName(env.getRequiredProperty("db.driver"));
	    ds.setUrl(env.getRequiredProperty("db.url"));
	    ds.setUsername(env.getRequiredProperty("db.username"));
	    ds.setPassword(env.getRequiredProperty("db.password"));

	    return ds;
	}	

}
