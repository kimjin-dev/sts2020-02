package com.bit.sts08.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.bit.sts08.model.entity.DeptVo;

public interface DeptDao {
	
	@Select("select * from dept03")
	List<DeptVo> selectAll() throws SQLException;
	DeptVo SelectOne(int deptno) throws SQLException;
	void insertOne(DeptVo bean) throws SQLException;
	int updateOne(DeptVo bean) throws SQLException;
	int deleteOne(int deptno) throws SQLException;
}
