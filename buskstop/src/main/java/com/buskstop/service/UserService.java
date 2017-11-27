package com.buskstop.service;

import com.buskstop.vo.Authority;
import com.buskstop.vo.User;

public interface UserService {
	
	void joinMemberService(User user, Authority authority);

}
