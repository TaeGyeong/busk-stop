package com.buskstop.dao;

import com.buskstop.vo.Authority;

public interface AuthorityDao {
	
	/**
	 * 권한테이블에 로우를 추가하는 Dao
	 * @param authority
	 * @return
	 */
	int insertAuthority(Authority authority);
	
	/**
	 * 기존 권한 테이블을 업데이트 해주는 Dao
	 * @param authority
	 * @return
	 */
	int updateAuthority(Authority authority);
}
