package com.bit.sts08.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.bit.sts08.model.entity.DeptVo;

public interface DeptDao {
	
	@Select("select * from dept03 order by deptno desc")
	List<DeptVo> selectAll() throws SQLException;
	
	@Select("select * from dept03 where deptno=#{val}")
	DeptVo selectOne(@Param("val")int deptno) throws SQLException;
	
	@Insert("insert into dept03 (dname, loc) values (#{dname}, #{loc})")
	//param 생략 가능
	void insertOne(DeptVo bean) throws SQLException;
	
	@Update("update dept03 set dname=#{dname}, loc=#{loc} where deptno=#{deptno}")
	int updateOne(DeptVo bean) throws SQLException;
	
	@Delete("delete from dept03 where deptno=#{deptno}")
	int deleteOne(int deptno) throws SQLException;
	
	@Select("select count(*) from dept03")
	int selectSize() throws SQLException;
}
