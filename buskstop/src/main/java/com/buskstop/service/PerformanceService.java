package com.buskstop.service;

import java.util.Date;
import java.util.List;

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
	
	Performance PerformanceByPerformanceNo(int performanceNo);
	
	List<Performance> selectAllPerformance();
	
	/**
	 * 공연정보 제목으로 검색
	 * @param performanceTitle
	 * @return
	 */
	List<Performance> selectPerformanceByPerformanceTitle(String performanceTitle);
	/**
	 * 공연정보 작성자로 검색
	 * @param performanceUserId
	 * @return
	 */
	List<Performance> selectPerformanceByPerformanceUserId(String performanceUserId);
	/**
	 * 공연정보 공연장소로 검색
	 * @param performanceLocation
	 * @return
	 */
	List<Performance> selectPerformanceByPerformanceLocation(String performanceLocation);
	/**
	 * 공연정보 공연이름으로 검색
	 * @param performanceName
	 * @return
	 */
	List<Performance> selectPerformanceByPerformanceName(String performanceName);
	/**
	 * 공연정보 내용으로 검색
	 * @param performanceContent
	 * @return
	 */
	List<Performance> selectPerformanceByPerformanceContent(String performanceContent);

}
