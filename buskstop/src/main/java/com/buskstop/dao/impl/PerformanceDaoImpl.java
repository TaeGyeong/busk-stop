package com.buskstop.dao.impl;

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
	public Performance selectPerformanceByPerformanceNo(int performanceNo) {
		return session.selectOne(makeSqlId("selectPerformanceByPerformanceNo"),performanceNo);
	}
	
	/*공연 정보 조회글 카운터 + 1, 공연글 정보 조회랑 세트로 호출*/
	@Override
	public int updatePerformanceCountByPerformanceNo(int performanceNo) {
		return session.update(makeSqlId("updatePerformanceCountByPerformanceNo"),performanceNo);
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
	
	@Override
	public List<Performance> selectAllPerformance(){
		return session.selectList(makeSqlId("selectAllPerformance"));
	}
	
	@Override
	public List<Performance> selectPerformanceByPerformanceTitle(String performanceTitle){
		return session.selectList(makeSqlId("selectPerformanceByPerformanceTitle"), performanceTitle);
	}
	
	@Override
	public List<Performance> selectPerformanceByPerformanceUserId(String performanceUserId){
		return session.selectList(makeSqlId("selectPerformanceByPerformanceUserId"), performanceUserId);
	}
	
	@Override
	public List<Performance> selectPerformanceByPerformanceLocation(String performanceLocation){
		return session.selectList(makeSqlId("selectPerformanceByPerformanceLocation"), performanceLocation);
	}
	
	@Override
	public List<Performance> selectPerformanceByPerformanceName(String performanceName){
		return session.selectList(makeSqlId("selectPerformanceByPerformanceName"), performanceName);
	}
	
	@Override
	public List<Performance> selectPerformanceByPerformanceContent(String performanceContent){
		return session.selectList(makeSqlId("selectPerformanceByPerformanceContent"), performanceContent);
	}
	
	@Override
	public List<Performance> selectAllPerformanceJoin(){
		return session.selectList(makeSqlId("selectAllPerformanceJoin"));
	}
	
}
//com.buskstop.config.mybatis.mapper.