package com.bit.sts12.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bit.sts12.dept.model.entity.DeptVo;

public interface DeptService {

	List<DeptVo> list() throws SQLException;

	DeptVo detail(int key) throws SQLException;
	
	void insert(DeptVo bean) throws SQLException;
	
	DeptVo update(DeptVo bean) throws SQLException;
	
	boolean delete(int key) throws SQLException;
}