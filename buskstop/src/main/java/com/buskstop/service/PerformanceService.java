package com.buskstop.service;

import com.buskstop.vo.Performance;

public interface PerformanceService {

	/**
	 * 공연정보 등록
	 * @param performance
	 */
	void insertPerformance(Performance performance);
	
	Performance getPerformanceByPerformanceNo(int performanceNo);

	int deletePerformanceByPerformance(int performanceNo);

	void updatePerformance(Performance performance);
	
}
