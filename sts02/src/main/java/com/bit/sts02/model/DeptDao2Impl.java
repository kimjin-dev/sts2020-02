package com.bit.sts02.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.sts02.model.entity.DeptVo;

public class DeptDao2Impl implements DeptDao {
	JdbcTemplate jdbcTemplate;
	RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>() {

		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptVo(rs.getInt(1),rs.getString(2),rs.getNString(3))	;
		}
	};
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql="select * from dept order by deptno desc";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		jdbcTemplate.update(sql, bean.getDeptno(),bean.getDname(),bean.getLoc());
	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		String sql="select * from dept where deptno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, deptno);
	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		return jdbcTemplate.update(sql, bean.getDname(),bean.getLoc(),bean.getDeptno());
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		String sql = "delete from dept where deptno=?";
		return jdbcTemplate.update(sql, deptno);
	}

}
