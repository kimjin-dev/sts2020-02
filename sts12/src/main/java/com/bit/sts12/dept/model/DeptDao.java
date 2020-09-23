package com.bit.sts12.dept.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.sts12.dept.model.entity.DeptVo;

public interface DeptDao {

	@Select("select * from dept03")
	List<DeptVo> selectAll() throws SQLException;
	
	@Select("select * from dept03 where deptno=#{deptno}")
	DeptVo selectOne(int deptno) throws SQLException;
	
	@Insert("insert into dept03 (dname,loc) values (#{dname},#{loc})")
	void insertOne(DeptVo bean) throws SQLException;
	
	@Update("update dept03 set dname=#{dname},loc=#{loc} where deptno=#{deptno}")
	int updateOne(DeptVo bean) throws SQLException;
	
	@Delete("delete from dept03 where deptno=#{deptno}")
	int deleteOne(int deptno) throws SQLException;
}
