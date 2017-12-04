package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.UserDao;
import com.buskstop.vo.User;


@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertUser(User user) {
		return session.insert(makeSqlId("insertUser"),user);
	}
	
	@Override
	public User selectUserById(String id) {
		return session.selectOne(makeSqlId("selectUserById"), id);
	}
	
	
	@Override
	public int updateUser(User user) {
		return session.update(makeSqlId("updateUser"), user);
	}
	
	@Override
	public int dropUpdateUserById(String id) {
		return session.update(makeSqlId("dropUserById"),id);
	}
	
	@Override
	public int selectDropById(String id) {
		return session.selectOne(makeSqlId("selectDropById"), id);
	}

	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.userMapper."+id;
	}
	
}
