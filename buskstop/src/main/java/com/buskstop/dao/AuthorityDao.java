package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.Authority;

public interface AuthorityDao {
	
	/**
	 * 권한테이블에 로우를 추가하는 Dao
	 * @param authority
	 * @return
	 */
	int insertAuthority(Authority authority);

	/**
	 * 사용자가 가지는 모든 권한 조회
	 * @param userId
	 * @return
	 */
	List<Authority> selectAuthoritiesByUserId(String userId);

	/**
	 * 사용자 권한 수정
	 * @param authority
	 * @return
	 */
	int updateAuthority(Authority authority);
	
}
