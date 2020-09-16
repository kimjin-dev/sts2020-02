package com.bit.sts05.dept.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.sts05.dept.model.entity.DeptVo;

@Repository
public class DeptDaoImpl implements DeptDao {

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public List<DeptVo> selectAll(){
		try(
				SqlSession session=sqlSessionFactory.openSession();
				){
			return session.selectList("selectAll");
		}
	}
}
