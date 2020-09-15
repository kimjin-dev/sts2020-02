package com.bit.sts04.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sts04Controller {
	
	@RequestMapping("/")
	public String index(Model model) throws SQLException {
		String[] arr= {
			"big01.jpg",	
			"big02.jpg",	
			"big03.jpg",	
			"big04.jpg",	
			"big05.jpg",	
			"big06.jpg",	
		};
		model.addAttribute("imgs", arr);
		return "home";
	}
}
