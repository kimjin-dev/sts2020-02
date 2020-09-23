package com.bit.sts12.dept.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bit.sts12.dept.model.entity.DeptVo;

public interface DeptDao {

	@Select("select * from dept03")
	List<DeptVo> selectAll() throws SQLException;
}
