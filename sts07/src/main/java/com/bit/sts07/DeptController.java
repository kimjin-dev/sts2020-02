package com.bit.sts07;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts07.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Inject
	DeptService deptService;
	
	@RequestMapping("/")
	public String list(Model model) {
		try {
			deptService.listService(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "dept/list";
	}
}
