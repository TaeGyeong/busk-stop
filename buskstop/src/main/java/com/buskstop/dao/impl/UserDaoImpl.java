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
		System.out.println(user+"%n :daoimpl");
		return session.update(makeSqlId("updateUser"), user);
	}

	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.userMapper."+id;
	}
	
}
