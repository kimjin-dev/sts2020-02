package com.bit.sts03.dept.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.sts03.dept.model.entity.Dept03Vo;

public class Dept03DaoImpl implements Dept03Dao {
//	private JdbcTemplate jdbcTemplate;
 JdbcTemplate jdbcTemplate;
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
	
	@Override
	public List<Dept03Vo> selectAll() {
		String sql="select * from dept03 order by deptno";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public Dept03Vo selectOne(int deptno) {
		String sql="select * from dept03 where deptno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, deptno);
	}
	
	public void insertOne(Dept03Vo bean) throws SQLException {
		String sql="insert into dept03 (dname,loc) values (?,?)";
		jdbcTemplate.update(sql, bean.getDname(), bean.getLoc());
	}

	@Override
	public int updateOne(Dept03Vo bean) throws SQLException {
		String sql ="update dept03 set dname=?, loc=? where deptno=?";
		return jdbcTemplate.update(sql, bean.getDname(), bean.getLoc(), bean.getDeptno());
	}

	@Override
	public int zDeleteOne(int deptno) throws SQLException {
		String sql ="delete from dept03 where deptno=?";
		return jdbcTemplate.update(sql, deptno);
	}
}
