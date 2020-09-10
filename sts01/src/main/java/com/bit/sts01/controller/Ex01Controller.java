package com.bit.sts01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * POJO Plain Old Java Object, ������ POJO�� �� �״�� �ؼ��� �ϸ� ������ ����� ������ �ڹ� ������Ʈ��� ���μ� 
 * Java EE ���� �߷� �����ӿ�ũ���� ����ϰ� �Ǹ鼭 �ش� �����ӿ�ũ�� ���ӵ� "���ſ�" ��ü�� ����� �� �Ϳ� 
 * �ݹ��ؼ� ���ǰ� �� ����̴�.
 */
@org.springframework.stereotype.Controller
public class Ex01Controller{
	
	@RequestMapping("/ex01.bit")
	public ModelAndView ex01(){
		
		return new ModelAndView("ex01");
	}
	
}
