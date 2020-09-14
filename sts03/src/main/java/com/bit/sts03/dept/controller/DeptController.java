package com.bit.sts03.dept.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts03.dept.model.Dept03Dao;
import com.bit.sts03.dept.model.entity.Dept03Vo;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	Dept03Dao dept03Dao;

	@RequestMapping("/")
	public String list(Model model) {
		model.addAttribute("list", dept03Dao.selectAll());
		return "dept/list";
	}
	
	@RequestMapping("/{deptno}")
	public String one(@PathVariable("deptno") int deptno,Model model) {
		model.addAttribute("title", "Detail");
		model.addAttribute("bean", dept03Dao.selectOne(deptno));
		return "dept/form";
	}
	
	@RequestMapping(value = "/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("title", "Add");
		return "dept/form";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insert(@ModelAttribute("bean") Dept03Vo bean,HttpServletRequest req) throws SQLException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		dept03Dao.insertOne(bean);
		return "redirect:./";
	}
}
