package com.bit.sts07;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts07.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	@Inject
	EmpService empService;

	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String list(Model model) throws SQLException {
		empService.listService(model);
		return "emp/list";
	}
}









