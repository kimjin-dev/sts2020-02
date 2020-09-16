package com.bit.sts05;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class TestContext {
	//org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(this.getClass());
	org.slf4j.Logger log=org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Autowired	
	DataSource dataSource;
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
		@Test
		public void testDatasource() throws SQLException {
			Connection conn = dataSource.getConnection();
			log.debug(conn.toString());
			assertNotNull(conn);
		}
		
		@Test
		public void testSqlSessionFactory() {
			assertNotNull(sqlSessionFactory);
		}
		
		@Test
		public void testSelectDept() {
			try(
				SqlSession session =sqlSessionFactory.openSession()
					){
				List<Map<String, String>> list=session.selectList("dept.selectDept");
				assertNotNull(list);
				for(Map<String,String>map:list) {
					log.debug(map.toString());
				}
			}
		
		}
}
