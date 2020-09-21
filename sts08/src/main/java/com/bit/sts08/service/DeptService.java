package com.bit.sts08.service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.ui.Model;

import com.bit.sts08.model.entity.DeptVo;

public interface DeptService {

	void list(Model model) throws SQLException;

	Map<String, Object> list() throws SQLException;

	DeptVo getOne(int deptno) throws SQLException;

	void updateOne(DeptVo bean) throws SQLException;

}