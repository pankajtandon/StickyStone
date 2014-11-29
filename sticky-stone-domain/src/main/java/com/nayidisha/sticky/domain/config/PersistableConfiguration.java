package com.nayidisha.sticky.domain.config;

import javax.sql.DataSource;

public interface PersistableConfiguration {

	public DataSource getDataSource();
	
	public String getDialect();
}
