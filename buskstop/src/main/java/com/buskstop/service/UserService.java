package com.buskstop.service;

import com.buskstop.vo.Authority;
import com.buskstop.vo.User;

public interface UserService {
	/**
	 * 새로운 회원을 추가시키는 service
	 * @param user
	 * @param authority
	 */
	void joinMember(User user, Authority authority);

	
	/**
	 * id를 통해 회원정보를 조회하는 service
	 * @param id
	 * @return
	 */
	User selectMemberById(String id);
	
	/**
	 * user 정보를 update하는 service
	 * @param user
	 * @return
	 */
	int updateMember(User user);
}
