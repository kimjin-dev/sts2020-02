package com.bit.sts06.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts06.emp.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	EmpService empService;

	@RequestMapping("/")
	public String list(HttpServletRequest req) throws SQLException {
		empService.list(req);
		return "emp/list";
	}
}