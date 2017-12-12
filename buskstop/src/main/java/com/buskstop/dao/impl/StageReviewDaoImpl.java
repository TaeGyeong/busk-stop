package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.StageReviewDao;

@Repository
public class StageReviewDaoImpl implements StageReviewDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
}
