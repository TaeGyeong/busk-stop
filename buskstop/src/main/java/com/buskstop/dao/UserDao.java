package com.buskstop.dao;

import com.buskstop.vo.User;

public interface UserDao {
	int insertUser(User user);
	
	User selectUserById(String id);
}
