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
	
	/**
	 * user의 탈퇴를 update
	 * @param id
	 * @return
	 */
	void dropMember(String id);
	
	/**
	 * Email 로 User를 찾는 select service.
	 * @param email
	 * @return
	 */
	String selectMemberByEmail(String email);
	
	/**
	 * Email로 User 정보 찾은 후 메일링 하는 service.
	 * @param email
	 * @return
	 */
	int findPasswordByEmail(String email);
}
