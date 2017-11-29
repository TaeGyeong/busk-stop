package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.Performance;

public interface PerformanceService {

	/**
	 * 공연정보 등록
	 * @param performance
	 */
	void insertPerformance(Performance performance);
	
	List<Performance> selectAllPerformance();
	
	Performance selectPerformanceByPerformanceNo(int performanceNo);
}
