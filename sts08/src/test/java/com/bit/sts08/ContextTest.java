package com.bit.sts08;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class ContextTest {
	Logger log=LoggerFactory.getLogger(ContextTest.class);
	
	@Inject
	DataSource dataSource;
	@Test
	public void testDataSource() throws SQLException {
		log.debug(dataSource.toString());
		for (int i = 0; i < 20; i++) {
			Connection conn = dataSource.getConnection();
			log.debug(i+" : "+conn.hashCode()+"");
			conn.close();
			
		}
	}
}
