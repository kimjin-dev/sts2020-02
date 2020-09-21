package com.bit.sts08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.AbstractDocument.Content;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts08.model.entity.DeptVo;
import com.bit.sts08.service.DeptService;

@Controller
public class DeptController {
	@Inject
	DeptService deptService;

	@RequestMapping(value = "/dept/",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String,Object> listPage() {
		try {
			return deptService.list();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/dept/{deptno}")
	@ResponseBody
	public DeptVo detailPage(@PathVariable int deptno) throws Exception {
		return deptService.getOne(deptno);
	}
	
	@RequestMapping(value = "/dept/",method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity updatePage(HttpServletRequest req,@RequestBody DeptVo bean) throws Exception {
//		BufferedReader reader =new BufferedReader(new InputStreamReader(req.getInputStream()));
//		System.out.println(reader.readLine());
		deptService.updateOne(bean);
		ResponseEntity entity=ResponseEntity.ok(HttpStatus.OK);
		return entity;
	}
}