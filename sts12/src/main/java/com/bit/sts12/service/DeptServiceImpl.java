package com.bit.sts12.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts12.dept.model.DeptDao;
import com.bit.sts12.dept.model.entity.DeptVo;

@Service

public class DeptServiceImpl implements DeptService {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<DeptVo> list() throws SQLException{
		return sqlSession.getMapper(DeptDao.class).selectAll();
	}

	@Override
	public DeptVo detail(int key) throws SQLException {
		return sqlSession.getMapper(DeptDao.class).selectOne(key);
	}

	@Override
	public void insert(DeptVo bean) throws SQLException {
		sqlSession.getMapper(DeptDao.class).insertOne(bean);
	}

	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
	@Override
	public DeptVo update(DeptVo bean) throws SQLException {
		sqlSession.getMapper(DeptDao.class).updateOne(bean);
		return sqlSession.getMapper(DeptDao.class).selectOne(bean.getDeptno());
	}

	@Override
	public boolean delete(int key) throws SQLException {
		return 0<sqlSession.getMapper(DeptDao.class).deleteOne(key);
	}
}











