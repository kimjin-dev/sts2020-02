package com.bit.sts12.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

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
}
