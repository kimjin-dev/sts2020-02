package com.bit.sts03.dept.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.sts03.dept.model.entity.Dept03Vo;

public class Dept03DaoTest {
	Dept03Vo target = new Dept03Vo(1, "test", "test");
	Dept03Dao dept03Dao;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAll() {
		//fail("Not yet implemented");
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
		dept03Dao=(Dept03Dao) ac.getBean("dept03Dao");
		//assertNotNull(dept03Dao.selectAll());
//		assertSame(1, dept03Dao.selectAll().size());
		System.out.println(dept03Dao.selectAll().get(0));
	}

	@Test
	public void testSelectOne() {
		
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
		dept03Dao=(Dept03Dao) ac.getBean("dept03Dao");
		assertEquals(target , dept03Dao.selectOne(target.getDeptno()));
	}

	@Test
	public void testFrist() throws SQLException {
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
		//DataSource dataSource=(DataSource) ac.getBean("dataSource");
		//JdbcTemplate jdbcTemplate=(JdbcTemplate) ac.getBean("jdbcTemplate");
		//Dept03Dao dept03Dao=(Dept03Dao) ac.getBean("dept03Dao");
		//System.out.println(dept03Dao);
		
		DataSource dataSource=(DataSource) ac.getBean("dataSource");
		Connection conn=dataSource.getConnection();
		/* create table */
		conn.prepareStatement("CREATE TABLE IF NOT EXISTS `dept03` (" + 
				"	`deptno` INT NOT NULL AUTO_INCREMENT," + 
				"	`dname` VARCHAR(10) NULL DEFAULT NULL," + 
				"	`loc` VARCHAR(10) NULL DEFAULT NULL," + 
				"	PRIMARY KEY (`deptno`)" + 
				")").execute();
		/* insert dummy data */
		conn.prepareStatement("insert into dept03 (dname,loc) values ('"+target.getDname()+"','"+target.getLoc()+"')").executeUpdate();
	}
}
