package com.bit.sts12.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mariadb.jdbc.Driver;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.bit.sts12.dept.model")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class RootConfig {

	/*
	<bean id="dataSource" class="org.springframework.jdbc.datasource.SimpleDriverDataSource">
		<property name="driverClass" value="org.mariadb.jdbc.Driver"></property>
		<property name="url" value="jdbc:mysql://localhost:3307/xe"></property>
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
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		return bean.getObject();
	}
	
	@Bean
	public SqlSession sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}














