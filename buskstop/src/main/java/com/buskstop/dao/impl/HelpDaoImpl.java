package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.HelpDao;
import com.buskstop.vo.Help;

@Repository
public class HelpDaoImpl implements HelpDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.helpMapper." + id;
	}
	
	/********************************* insert Dao *********************************/
	@Override
	public void insertHelp() {
		System.out.println("Log: HelpDaoImpl.java -> helpMapper.Xml id=\"insertHelp\" 호출");
	}
	
	@Override
	public int insertHelp(Help help) {
		return session.insert(makeSqlId("insertHelp"), help);
	}

}
