package com.bit.sts08.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts08.model.DeptDao;

@Service
public class DeptServiceImpl implements DeptService {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void list(Model model) throws SQLException {
		
		model.addAttribute("list",sqlSession.getMapper(DeptDao.class).selectAll());
	}

}
