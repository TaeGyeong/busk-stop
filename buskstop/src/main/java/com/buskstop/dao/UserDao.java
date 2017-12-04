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
	
	/**
	 * user table update
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * user의 DROP_CHECK UPDATE
	 * @param id
	 * @return
	 */
	int dropUpdateUserById(String id);
	
	/**
	 * user의 drop_check column 조회
	 * @param id
	 * @return
	 */
	int selectDropById(String id);
}
