package com.bit.sts02.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.sts02.model.entity.DeptVo;

public class DeptDao1Impl implements DeptDao {
	
	@Override
	public List<DeptVo> selectAll() throws SQLException{
		String sql="select * from dept";
		List<DeptVo> list=new ArrayList<DeptVo>();
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(
				Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/xe", "xe", "1234");
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				){
			while(rs.next())
				list.add(new DeptVo(
							rs.getInt(1),rs.getString(2),rs.getString(3)
						));
		}
		return list;
	}
}
