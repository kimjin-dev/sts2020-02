package com.bit.sts08.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts08.model.entity.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional
public class DeptDaoTest {
	@Inject
	SqlSession sqlSession;
	
	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void testSelectAll() throws SQLException {
		assertSame(10, sqlSession.getMapper(DeptDao.class).selectAll().size());
	}

	@Test
	public void testSelectOne() throws SQLException {
		assertNotNull(sqlSession.getMapper(DeptDao.class).SelectOne(1));
	}

	@Test
	public void testCRUxD() throws SQLException {
		assertSame(10, sqlSession.getMapper(DeptDao.class).selectAll().size());
		
		assertSame(10, sqlSession.getMapper(DeptDao.class).selectSize());
		
		DeptVo target = new DeptVo(0, "test", "test");
		sqlSession.getMapper(DeptDao.class).insertOne(target);
		assertSame(11, sqlSession.getMapper(DeptDao.class).selectAll().size());
		
		target.setDeptno(sqlSession.getMapper(DeptDao.class).selectAll().get(0).getDeptno());
		target.setDname("테스트");
		target.setLoc("테스트지역");
		sqlSession.getMapper(DeptDao.class).updateOne(target);
		assertEquals(target, sqlSession.getMapper(DeptDao.class).SelectOne(target.getDeptno()));
		
		sqlSession.getMapper(DeptDao.class).deleteOne(target.getDeptno());
		assertSame(10, sqlSession.getMapper(DeptDao.class).selectAll().size());
	}

}
