package com.bit.sts01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * POJO Plain Old Java Object, 간단히 POJO는 말 그대로 해석을 하면 오래된 방식의 간단한 자바 오브젝트라는 말로서 
 * Java EE 등의 중량 프레임워크들을 사용하게 되면서 해당 프레임워크에 종속된 "무거운" 객체를 만들게 된 것에 
 * 반발해서 사용되게 된 용어이다.
 */
@org.springframework.stereotype.Controller
public class Ex01Controller{
	
	@RequestMapping("/ex01.bit")
	public ModelAndView ex01(){
		
		return new ModelAndView("ex01");
	}
	
}
