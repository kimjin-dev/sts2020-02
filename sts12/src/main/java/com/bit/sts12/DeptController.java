package com.bit.sts12;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts12.dept.model.entity.DeptVo;
import com.bit.sts12.service.DeptService;

@RestController
public class DeptController {
	@Inject
	DeptService deptService;

	@GetMapping(value = "/dept/")
	public List<DeptVo> list() throws SQLException{
		return deptService.list();
	}
	
	@PostMapping("/dept/")
	public ResponseEntity add(@ModelAttribute DeptVo bean) throws SQLException {
		HttpStatus status;
		status=HttpStatus.OK;
		if(bean.getDname()==null) {
			status=HttpStatus.BAD_REQUEST;
		}		
		deptService.insert(bean);
		return ResponseEntity.status(status).build();
	}
	
	@GetMapping("/dept/{deptno}")
	public DeptVo one(@PathVariable("deptno")int key) throws SQLException {
		return deptService.detail(key);
	}
	
	@PutMapping("/dept/{deptno}")
	public DeptVo edit(@PathVariable("deptno")int key,@ModelAttribute DeptVo bean) throws SQLException {
		System.out.println(bean);
		return deptService.update(bean);
	}
	
	
}





