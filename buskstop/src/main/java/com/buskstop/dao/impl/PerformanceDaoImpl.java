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
	
	public List<Performance> selectAllPerformance(){
		return session.selectList(makeSqlId("selectAllPerformance"));
	}
	
	public Performance selectPerformanceByPerformanceNo(int performanceNo){
		System.out.println("Dao 파라미터");
		System.out.println(performanceNo);
		
		Performance i = session.selectOne(makeSqlId("selectPerformanceByPerformanceNo"),performanceNo);
		
		System.out.println("Dao 리턴");
		System.out.println(i);
		return i;
	}
	
}
//com.buskstop.config.mybatis.mapper.