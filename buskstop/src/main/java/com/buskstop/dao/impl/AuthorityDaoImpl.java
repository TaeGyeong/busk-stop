package com.buskstop.dao.impl;

import java.util.List;

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
		return session.insert(makeSqlId("insertAuthority")); 
	}
	
	@Override
	public List<Authority> selectAuthoritiesByUserId(String userId) {
		System.out.println("au"+userId);
		return session.selectList(makeSqlId("selectAuthoritiesByUserId"), userId);
	}
	
	private String makeSqlId(String id){
		return "com.buskstop.config.mybatis.mapper.authorityMapper."+id;
	}

}
