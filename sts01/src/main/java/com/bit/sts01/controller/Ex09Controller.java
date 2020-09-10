package com.bit.sts01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.sts01.model.entity.TestBean;

@Controller
public class Ex09Controller {
	
	@RequestMapping("/ex09")
	public String ex01() {
		System.out.println("arg ¾øÀ½");
		return "ex09";
	}
	
	@RequestMapping("/ex10")
	public String ex01(HttpServletRequest req) {
		String id = req.getParameter("id");
		System.out.println("id : "+id);
		req.setAttribute("id", id);
		return "ex09";
	}
	
	@RequestMapping("/ex11")
	public String ex01(Model model, HttpServletRequest req) {
		model.addAttribute("id", req.getParameter("id"));
		return "ex09";
	}
	
	@RequestMapping("/ex12")
	public String ex01(@RequestParam int su) {
		System.out.println(su);
		return "ex09";
	}
	
	@RequestMapping("/ex13/{num}/{msg}")
	public String ex02(@PathVariable("num") int su,@PathVariable String msg) {
		System.out.println(msg+" : "+su);
		return "ex09";
	}
	
	@RequestMapping("/ex14")
	public String ex03(@ModelAttribute("id") String id) {
		id = "ABCD";
		return "ex09";
	}
	
	@RequestMapping("/ex15")
	public String ex04(@ModelAttribute("bean") TestBean bean) {
		System.out.println(bean);
		return "ex15";
	}
}
