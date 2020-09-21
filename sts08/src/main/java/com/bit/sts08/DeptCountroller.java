package com.bit.sts08;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts08.service.DeptService;
import com.google.gson.Gson;

@Controller
public class DeptCountroller {
		@Inject
		DeptService deptService;
		
		@RequestMapping(value = "/dept/", method=RequestMethod.GET, produces = {"application/json; charset=utf-8"})
		public @ResponseBody String listPage(Model model) {
			try {
				deptService.list(model);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Map map=new HashMap();
			map.put("root", model.asMap().get("list"));	
			
			//java-<json변환 toString
			Gson gson = new Gson();
			return gson.toJson(map);
		}
		
}
