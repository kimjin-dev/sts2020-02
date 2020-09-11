package com.bit.sts02.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts02.model.DeptDao;
import com.bit.sts02.model.DeptDao1Impl;

@Controller
@RequestMapping("/dept/")
public class DeptController {
	// Dept table CRUD
	DeptDao deptDao;
	
	@Autowired
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	@RequestMapping("list")
	public String list(Model model) throws SQLException {
		model.addAttribute("list", new DeptDao1Impl().selectAll());
		return "deptList";
	}
}
