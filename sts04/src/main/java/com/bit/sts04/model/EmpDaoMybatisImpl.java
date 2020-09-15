	package com.bit.sts04.model;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.bit.sts04.model.entity.EmpVo;


public class EmpDaoMybatisImpl extends SqlSessionDaoSupport implements EmpDao {

	@Override
	public List<EmpVo> selectAll() throws SQLException {
		return getSqlSession().selectList("bit.selectAll");
	}

	@Override
	public EmpVo selectOne(int key) throws SQLException {
		return getSqlSession().selectOne("bit.selectOne", key);
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		getSqlSession().insert("bit.insertOne", bean);
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOne(int key) throws SQLException {
		return 0;
	}

}