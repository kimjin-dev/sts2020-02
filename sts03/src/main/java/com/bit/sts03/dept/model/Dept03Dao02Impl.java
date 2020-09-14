package com.bit.sts03.dept.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.bit.sts03.dept.model.entity.Dept03Vo;

public class Dept03Dao02Impl extends SqlMapClientDaoSupport implements Dept03Dao{

	@Override
	public List<Dept03Vo> selectAll() throws SQLException {
		
		return getSqlMapClient().queryForList("selectAll");
	}

	@Override
	public Dept03Vo selectOne(int deptno) throws SQLException {
		
		return (Dept03Vo) getSqlMapClient().queryForObject("selectOne", deptno);
	}

	@Override
	public void insertOne(Dept03Vo bean) throws SQLException {
		getSqlMapClient().insert("insertOne", bean);
		
	}

	@Override
	public int updateOne(Dept03Vo bean) throws SQLException {
		
		return getSqlMapClient().update("updateOne", bean);
	}

	@Override
	public int zDeleteOne(int deptno) throws SQLException {
		
		return getSqlMapClient().delete("deleteOne", deptno);
	}
	
}
