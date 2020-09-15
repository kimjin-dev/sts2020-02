package com.bit.sts04.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.sts04.model.entity.EmpVo;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class EmpDaoIbatisImpl implements EmpDao{
	@Autowired
	SqlMapClient sqlMapClient;
	
	@Override
	public List<EmpVo> selectAll() throws SQLException {
		
		return sqlMapClient.queryForList("selectAll");
	}

	@Override
	public EmpVo selectOne(int key) throws SQLException {

		return null;
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		sqlMapClient.insert("insertOne",bean);
		
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {

		return 0;
	}

	@Override
	public int deleteOne(int ket) throws SQLException {

		return 0;
	}

}
