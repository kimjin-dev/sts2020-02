package com.bit.sts12;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts12.dept.model.entity.DeptVo;
import com.bit.sts12.service.DeptService;

@Controller
public class DeptController {
	@Inject
	DeptService deptService;

	@RequestMapping(value = "/dept/",method=RequestMethod.GET)
	public @ResponseBody List<DeptVo> list() throws SQLException{
		return deptService.list();
	}
}
