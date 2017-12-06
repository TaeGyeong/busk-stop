package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.StageImageDao;
import com.buskstop.vo.StageImage;

@Repository
public class StageImageDaoImpl implements StageImageDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.stageImageMapper."+id;
	}
	
	@Override
	public int insertStageImage(StageImage stageImage) {
		return session.insert(makeSqlId("insertStageImage"), stageImage);
	}
}
