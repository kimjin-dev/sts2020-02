package com.bit.sts07.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts07.model.EmpDao;

@Service
public class EmpServiceImpl implements EmpService {
	@Inject
	SqlSession sqlSession;

	@Override
	public void listService(Model model) throws SQLException {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		model.addAttribute("list", dao.selectAll());
	}

}
