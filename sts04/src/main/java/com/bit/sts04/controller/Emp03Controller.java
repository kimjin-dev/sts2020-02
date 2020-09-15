package com.bit.sts04.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.sts04.model.EmpDao;
import com.bit.sts04.model.entity.EmpVo;

@Controller
@RequestMapping("/emp")
public class Emp03Controller {
	@Autowired
	EmpDao empDao;
	
	@RequestMapping("/")
	public ModelAndView list() throws SQLException {
		List<EmpVo> list=empDao.selectAll();
		for(EmpVo bean: list) {
			System.out.println(bean);
		}
		return null;
	}
	
}
