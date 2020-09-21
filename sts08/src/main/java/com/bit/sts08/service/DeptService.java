package com.bit.sts08.service;

import java.sql.SQLException;

import org.springframework.ui.Model;

public interface DeptService {

	void list(Model model) throws SQLException;
	
}
