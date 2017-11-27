package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.AuthorityDao;
import com.buskstop.vo.Authority;

@Repository
public class AuthorityDaoImpl implements AuthorityDao{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertAuthority(Authority authority) {
		System.out.println(authority);
		return session.insert(makeSqlId("insertAuthority"),authority); 
	}

	
	private String makeSqlId(String id){
		return "com.buskstop.config.mybatis.mapper.authorityMapper."+id;
	}
}
