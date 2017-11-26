package com.buskstop.dao;

import com.buskstop.vo.User;

public interface AuthorityDao {
	User selectUserByUserId(String id);
	
}
