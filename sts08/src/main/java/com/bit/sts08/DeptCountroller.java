package com.bit.sts08;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts08.service.DeptService;

@Controller
public class DeptCountroller {
		@Inject
		DeptService deptService;
		
		@RequestMapping(value = "/dept/", method=RequestMethod.GET)
		public String listPage(Model model) {
			try {
				deptService.list(model);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "home";
		}
		
}
