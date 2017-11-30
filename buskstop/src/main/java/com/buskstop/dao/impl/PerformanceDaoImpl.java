package com.buskstop.dao.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;
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
	public Performance selectPerformanceByPerformanceNo(int performanceNo){
		Performance i = session.selectOne(makeSqlId("selectPerformanceByPerformanceNo"),performanceNo);
		return i;
	}
	
	@Override
	public int updatePerformance(Performance performance) {
		System.out.println(performance);
		System.out.println(session.update(makeSqlId("updatePerformance"),performance));
		return session.update(makeSqlId("updatePerformance"),performance);
	}
	
	@Override
	public int deletePerformanceByPerformanceNo(int performanceNo) {
		return session.delete(makeSqlId("deletePerformanceByPerformanceNo"),performanceNo);
	}
	
	public List<Performance> selectAllPerformance(){
		return session.selectList(makeSqlId("selectAllPerformance"));
	}
	
	public List<Performance> selectPerformanceByPerformanceTitle(String performanceTitle){
		return session.selectList(makeSqlId("selectPerformanceByPerformanceTitle"), performanceTitle);
	}
	
	public List<Performance> selectPerformanceByPerformanceUserId(String performanceUserId){
		return session.selectList(makeSqlId("selectPerformanceByPerformanceUserId"), performanceUserId);
	}
	
	public List<Performance> selectPerformanceByPerformanceLocation(String performanceLocation){
		return session.selectList(makeSqlId("selectPerformanceByPerformanceLocation"), performanceLocation);
	}
	
	public List<Performance> selectPerformanceByPerformanceName(String performanceName){
		return session.selectList(makeSqlId("selectPerformanceByPerformanceName"), performanceName);
	}
	
	public List<Performance> selectPerformanceByPerformanceContent(String performanceContent){
		return session.selectList(makeSqlId("selectPerformanceByPerformanceContent"), performanceContent);
	}

}
//com.buskstop.config.mybatis.mapper.