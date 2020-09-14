package com.bit.sts03.dept.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.sts03.dept.model.entity.Dept03Vo;

public class Dept03DaoImpl {
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Dept03Vo> rowMapper = new RowMapper<Dept03Vo>() {

		@Override
		public Dept03Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Dept03Vo(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
		}
	};
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Dept03Vo> selectAll() {
		String sql="select * from dept03 order by deptno";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
}
