package com.buskstop.dao;

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
}
