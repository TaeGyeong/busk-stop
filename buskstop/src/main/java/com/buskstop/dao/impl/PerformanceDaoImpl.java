package com.buskstop.dao.impl;

import java.util.List;

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
	public Performance selectPerformanceByPerformanceNo(int performanceNo){
		return session.selectOne(makeSqlId("selectPerformanceByPerformanceNo"),performanceNo);
	}
	
	/*공연 정보 조회글 카운터 + 1, 공연글 정보 조회랑 세트로 호출*/
	@Override
	public int updatePerformanceCountByPerformanceNo(int performanceNo) {
		System.out.println("Dao 파라미터");
		System.out.println(performanceNo);
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