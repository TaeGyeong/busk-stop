package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.PremiumStageImageDao;
import com.buskstop.vo.PremiumStageImage;

@Repository
public class PremiumStageImageDaoImpl implements PremiumStageImageDao{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertImage(PremiumStageImage image) {
		return session.insert(makeSqlId("insertImage"), image );
	}
	
	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.premiumStageImageMapper."+id;
	}
}
