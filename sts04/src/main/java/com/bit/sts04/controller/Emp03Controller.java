package com.bit.sts04.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.sts04.model.EmpDao;
import com.bit.sts04.model.entity.EmpVo;

@Controller
@RequestMapping("/emp")
public class Emp03Controller {
	@Autowired
	EmpDao empDao;
	
	@RequestMapping("/")
	public String list(Model model) throws SQLException {
		model.addAttribute("list", empDao.selectAll());
		return "emp/list";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public void add() {
	}
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(@ModelAttribute EmpVo bean) {
		try {
			empDao.insertOne(bean);
		} catch (SQLException e) {
			return "emp/add";
		}
		return "redirect:./";
	}
	
}
