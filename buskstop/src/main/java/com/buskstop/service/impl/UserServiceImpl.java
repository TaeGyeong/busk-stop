package com.buskstop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buskstop.dao.AuthorityDao;
import com.buskstop.dao.UserDao;
import com.buskstop.service.UserService;
import com.buskstop.vo.Authority;
import com.buskstop.vo.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthorityDao authorDao;
	
	@Override
	@Transactional
	public void joinMemberService(User user,Authority authority) {
		userDao.insertUser(user);
		authorDao.insertAuthority(authority);
	}
	
}
