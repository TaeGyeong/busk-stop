package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.Performance;

public interface PerformanceDao {
	
	/**
	 * 공연 정보 등록
	 * @param performance
	 * @return
	 */
	int insertPerformance(Performance performance);

	Performance selectPerformanceByPerformanceNo(int performanceNo);	
	
	int deletePerformanceByPerformanceNo(int performanceNo);

	int updatePerformance(Performance performance);
	//모든 공연 정보 조회 (Mock)
	List<Performance> selectAllPerformance();

	List<Performance> selectPerformanceByPerformanceTitle(String performanceTitle);
	
	List<Performance> selectPerformanceByPerformanceUserId(String performanceUserId);
	
	List<Performance> selectPerformanceByPerformanceLocation(String performanceLocation);
	
	List<Performance> selectPerformanceByPerformanceName(String performanceName);
	
	List<Performance> selectPerformanceByPerformanceContent(String performanceContent);

}
