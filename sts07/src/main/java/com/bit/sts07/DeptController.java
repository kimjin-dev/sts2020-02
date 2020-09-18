package com.bit.sts07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@RequestMapping("/")
	public String list() {
		return "dept/list";
	}
}
