package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.PremiumStageDao;
import com.buskstop.vo.PremiumStage;

@Repository
public class PremiumStageDaoImpl implements PremiumStageDao{

	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public int insertStageSupplier(PremiumStage supplier) {
		return session.insert(makeSqlId("insertStageSupplier"), supplier);
	}
	
	@Override
	public int updateStageSupplier(PremiumStage supplier) {
		return session.update(makeSqlId("updateStageSupplier"), supplier);
	}
	
	@Override
	public PremiumStage selectSupplierById(String userId) {
		return session.selectOne(makeSqlId("selectSupplierById"), userId);
	}

	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.stageSupplierMapper."+id;
	}
}
