package com.bit.sts01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class Ex05Controller {

	
		@RequestMapping("/ex06")
		public void ex01() {}
		
		
		@RequestMapping("/ex/ex07")// return "/ex/ex07";
		public void ex02() {}
}
