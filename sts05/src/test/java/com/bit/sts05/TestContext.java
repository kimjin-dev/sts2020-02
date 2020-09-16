package com.bit.sts05;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.sts05.dept.model.entity.DeptVo;

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
		public void testSelectTest() {
			try (SqlSession session = sqlSessionFactory.openSession()) {
					Map<String, Object> target=new HashMap<String, Object>();
					target.put("dname", "tester");
					target.put("loc","학원");
					target.put("deptno",1234);
					session.insert("test.insertTest",target);

					Map<String, Object> map = session.selectOne("test.selectDept",1234);
//					Set<Entry<String, Object>> entrySet = map.entrySet();
//					Iterator<Entry<String, Object>> ite = entrySet.iterator();
//					while(ite.hasNext()) {
//						Entry<String, Object> entry = ite.next();
//						log.debug(entry.getKey()+":"+entry.getValue());
//					}

					assertSame(1, session.delete("test.deleteTest",1234));
				}
		}
		
		@Test
		public void testSelectDept() {
			try(   
					SqlSession session=sqlSessionFactory.openSession();
					
					){
				session.selectList("dept.selectDept",new DeptVo(5,null,"test22"));
				
			}
		}
		
}
