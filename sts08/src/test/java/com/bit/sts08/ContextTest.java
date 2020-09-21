package com.bit.sts08;

import static org.junit.Assert.assertSame;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class ContextTest {
	Logger log=LoggerFactory.getLogger(ContextTest.class);
	
	@Inject
	JdbcTemplate jdbcTemplate;
	@Test
	public void testDataSource() throws SQLException {
		assertSame(9,jdbcTemplate.queryForList("select * from dept03").size());
		jdbcTemplate.update("insert into dept03 (dname,loc) values ('test', 'test')");
		assertSame(9,jdbcTemplate.queryForList("select * from dept03").size());
	}
}
