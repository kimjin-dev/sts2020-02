package com.bit.sts07.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts07.model.DeptDao;

@Service
public class DeptServiceImpl implements DeptService {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void listService(Model model) throws SQLException{
		DeptDao dao=sqlSession.getMapper(DeptDao.class);
		model.addAttribute("list", dao.selectAll());
		
	}
}
