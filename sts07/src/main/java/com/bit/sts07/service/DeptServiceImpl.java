package com.bit.sts07.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts07.model.DeptDao;
import com.bit.sts07.model.entity.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {
	@Inject
	SqlSession sqlSession;

	@Override
	public void listService(Model model) throws SQLException{
		DeptDao dao = sqlSession.getMapper(DeptDao.class);
		System.out.println(dao);
		model.addAttribute("list", dao.selectAll());
//		model.addAttribute("list", sqlSession.selectList("selectAll"));
	}

	@Override
	public void oneAddService(DeptVo bean) throws SQLException {
		DeptDao dao=sqlSession.getMapper(DeptDao.class);
		dao.insertOne(bean);
		bean.setDname("next)"+bean.getDname());
		dao.insertOne(bean);
	}

	@Override
	public void detailService(Model model, int deptno) throws SQLException {
		DeptDao dao=sqlSession.getMapper(DeptDao.class);
		model.addAttribute("bean",dao.selectOne(deptno));
	}

	@Override
	public void oneEditService(DeptVo bean) throws SQLException {
		DeptDao dao=sqlSession.getMapper(DeptDao.class);
		dao.updateOne(bean);
	}

	@Override
	public void oneDelService(int deptno) throws SQLException {
		DeptDao dao=sqlSession.getMapper(DeptDao.class);
		dao.deleteOne(deptno);
		dao.deleteOne(deptno-1);
	}
}












