package com.bit.sts12.service;

import java.sql.SQLException;
import java.util.List;

import com.bit.sts12.dept.model.entity.DeptVo;

public interface DeptService {

	List<DeptVo> list() throws SQLException;

}