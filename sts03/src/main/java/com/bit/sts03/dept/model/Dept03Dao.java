package com.bit.sts03.dept.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.sts03.dept.model.entity.Dept03Vo;

public interface Dept03Dao {

	List<Dept03Vo> selectAll() throws SQLException;
	Dept03Vo selectOne(int deptno) throws SQLException;
	void insertOne(Dept03Vo bean) throws SQLException;
	int updateOne(Dept03Vo bean) throws SQLException;
	int zDeleteOne(int deptno) throws SQLException;
}