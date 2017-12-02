package com.buskstop.dao;

import com.buskstop.vo.User;

public interface UserDao {
	/**
	 * 새로운 user data 등록
	 * @param user
	 * @return
	 */
	int insertUser(User user);
	
	/**
	 * id로 user 정보 객체를 select
	 * @param id
	 * @return
	 */
	User selectUserById(String id);
	
	int updateUser(User user);
}
