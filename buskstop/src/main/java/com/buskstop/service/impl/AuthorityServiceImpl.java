package com.buskstop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buskstop.dao.AuthorityDao;
import com.buskstop.service.AuthorityService;
import com.buskstop.vo.Authority;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	AuthorityDao dao;
	
	@Override
	public boolean readArtistAutoritiesByUserId(String userId) {
		return dao.selectArtistAuthoritiesByUserId(userId);
	}
	
}
