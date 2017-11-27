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

	List<Authority> selectAuthoritiesByUserId(String userId);

	int updateAuthority(Authority authority);
	
}
