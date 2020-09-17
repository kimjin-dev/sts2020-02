package com.bit.sts06.emp.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.sts06.emp.model.EmpDao;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDao empDao;

	@Override
	public void list(HttpServletRequest req) throws SQLException {
		if(req.getParameter("page")==null)
			req.setAttribute("list", empDao.selectAll());
		else
			req.setAttribute("list"
					, empDao.selectAll(Integer.parseInt(req.getParameter("page"))));
	}

}