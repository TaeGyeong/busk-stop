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
	
	//모든 공연 정보 조회 (Mock)
	List<Performance> selectAllPerformance();
	
	Performance selectPerformanceByPerformanceNo(int performanceNo);
}
