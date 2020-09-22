package com.bit.sts10;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/page2")
	public void page2() {
		
	}
	
	@RequestMapping("/page3")
	public void page3() {
		
	}
	
	@RequestMapping("/page4")
	public void page4() {
		
	}

	@RequestMapping("/login")
	public String login(HttpSession session) {
		if(session.getAttribute("login")==null) {
			return "login";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/result")
	public String result(String id, String pw, HttpServletRequest req, HttpSession session) {
		logger.info("id:"+id+":pw"+pw);
		//HttpSession session = req.getSession();
		session.setAttribute("login", true);
		session.setAttribute("who", id);
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();//섹션 갱신함
		return "redirect:/";
	}
	
	
	
	
}
