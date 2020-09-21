package com.bit.sts08;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts08.model.entity.DeptVo;
import com.bit.sts08.service.DeptService;

@Controller
public class DeptCountroller {
		@Inject
		DeptService deptService;
		
		@RequestMapping(value = "/dept/", method=RequestMethod.GET, produces = {"application/json; charset=utf-8"})
		@ResponseBody
		public Map listPage(Model model) {
			try {
				deptService.list(model);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Map map=new HashMap();
			List list = new ArrayList();
			map.put("root", list);
			list.add(new DeptVo());
			list.add(new DeptVo());
			list.add(new DeptVo());
			return map;
		}
		
}
