package com.bit.sts06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts06.emp.model.entity.EmpVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
//		EmpVo bean = new EmpVo();
		EmpVo bean = new EmpVo(4321, "ÀüºÎ", null, 1,1);
//		bean.setSabun(1234);
//		bean.setName("name");
		model.addAttribute("bean", bean);
		return "home";
	}
	
}
