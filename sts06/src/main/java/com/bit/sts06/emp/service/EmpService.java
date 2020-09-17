package com.bit.sts06.emp.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface EmpService {
	void list(HttpServletRequest req) throws SQLException;
}