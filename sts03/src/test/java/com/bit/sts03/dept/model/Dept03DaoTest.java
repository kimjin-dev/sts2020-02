package com.bit.sts03.dept.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.sts03.dept.model.entity.Dept03Vo;

/*@FixMethodOrder
@FixMethodOrder(MethodSorters.DEFAULT) 테스트로 출력을 할 수 있지만 순서가 보장되지 않습니다.
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 메소드명 기준으로하여 오름차순으로 실행됩니다.
@FixMethodOrder(MethodSorters.JVM) 테스트방법을 JVM이 리턴한 순서대로 실행됩니다.
*/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Dept03DaoTest {
	static Dept03Vo target = new Dept03Vo(1, "test", "test");
	Dept03Dao dept03Dao;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
//		String sql="CREATE TABLE IF NOT EXISTS `dept03` (" + 
		String sql="CREATE TABLE `dept03` (" + 
				"	`deptno` INT NOT NULL AUTO_INCREMENT," + 
				"	`dname` VARCHAR(10) NULL DEFAULT NULL," + 
				"	`loc` VARCHAR(10) NULL DEFAULT NULL," + 
				"	PRIMARY KEY (`deptno`)" + 
				")";
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
		//DataSource dataSource=(DataSource) ac.getBean("dataSource");
		//JdbcTemplate jdbcTemplate=(JdbcTemplate) ac.getBean("jdbcTemplate");
		//Dept03Dao dept03Dao=(Dept03Dao) ac.getBean("dept03Dao");
		//System.out.println(dept03Dao);
		
		DataSource dataSource=(DataSource) ac.getBean("dataSource");
		Connection conn=dataSource.getConnection();
		/* create table */
		conn.prepareStatement(sql).execute();
		/* insert dummy data */
//		conn.prepareStatement("insert into dept03 (dname,loc) "
//				+ "values ('"+target.getDname()+"','"+target.getLoc()+"')").executeUpdate();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
		File file = new File("c:\\data\\xeTest.mv.db");
		if(file.exists())file.deleteOnExit();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
		dept03Dao=(Dept03Dao) ac.getBean("dept03Dao");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testSelectAll() throws SQLException {
		//assertNotNull(dept03Dao.selectAll());
		//assertSame(2, dept03Dao.selectAll().size());
		System.out.println(dept03Dao.selectAll().get(0));
	}

	@Test
	public void testSelectOne() throws SQLException {
		assertEquals(target , dept03Dao.selectOne(target.getDeptno()));
	}
	
	@Test
	public void testInsertOne() {
		try {
			dept03Dao.insertOne(target);
			assertTrue(true);
		} catch (SQLException e) {
			assertFalse(true);
		}
	}
	
	@Test
	public void testUpdate() throws SQLException {
//		target = new Dept03Vo(target.getDeptno(), "test1", "test2");
		target.setDname("test1");
		target.setLoc("test2");
		assertSame(1, dept03Dao.updateOne(target));
	}
	
	@Test
	public void testZDeleteOne() throws SQLException {
		assertSame(1, dept03Dao.zDeleteOne(target.getDeptno()));
	}

}
