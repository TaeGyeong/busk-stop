package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.Authority;

public interface AuthorityDao {
	
	int insertAuthority(Authority authority);
	
	List<Authority> selectAuthoritiesByUserId(String userId);
	
}
