package com.bit.sts12.config;

import javax.sql.DataSource;

import org.mariadb.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class RootConfig {

	/*
	<bean id="dataSource" class="org.springframework.jdbc.datasource.SimpleDriverDataSource">
		<property name="driverClass" value="org.mariadb.jdbc.Driver"></property>
		<property name="url" value="jdbc:mysql://localhost:3306/xe"></property>
		<property name="username" value="scott"></property>
		<property name="password" value="tiger"></property>
	</bean>
	*/
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource=null;
		dataSource=new SimpleDriverDataSource();
		
		dataSource.setDriverClass(Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost:3307/xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		return dataSource;
	}
}














