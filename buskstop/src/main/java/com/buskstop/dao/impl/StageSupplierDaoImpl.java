package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.StageSupplierDao;
import com.buskstop.vo.StageSupplier;

@Repository
public class StageSupplierDaoImpl implements StageSupplierDao{

	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public int insertStageSupplier(StageSupplier supplier) {
		return session.insert(makeSqlId("insertStageSupplier"), supplier);
	}
	
	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.stageSupplierMapper."+id;
	}
}
