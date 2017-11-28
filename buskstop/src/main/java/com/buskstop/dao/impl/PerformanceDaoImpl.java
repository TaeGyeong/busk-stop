package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.PerformanceDao;
import com.buskstop.vo.Performance;

@Repository
public class PerformanceDaoImpl implements PerformanceDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.performanceMapper."+id;
	}
	
	@Override
	public int insertPerformance(Performance performance) {
		return session.insert(makeSqlId("insertPerformance"), performance);
	}

	@Override
	public Performance selectPerformanceByPerformanceNo(int performanceNo) {
		return session.selectOne(makeSqlId("selectPerformanceByPerformanceNo"),performanceNo);
	}
	
	@Override
	public int updatePerformance(Performance performance) {
		return session.update(makeSqlId("updatePerformance"),performance);
	}
	
	@Override
	public int deletePerformanceByPerformanceNo(int performanceNo) {
		return session.delete(makeSqlId("deletePerformanceByPerformanceNo"),performanceNo);
	}
	
}
//com.buskstop.config.mybatis.mapper.