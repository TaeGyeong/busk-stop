package com.buskstop.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
	
	/**
	 * 조회처리하는 메소드 페이징
	 * @param page
	 * @return
	 */
	Map<String, Object> selectAllPerformance(int page);
	
	/**
	 * 조회처리
	 * @return
	 */
	List<Performance> selectAllPerfor();
	
	/**
	 * 공연정보 제목으로 검색 페이징
	 * @param performanceTitle
	 * @return
	 */
	Map<String, Object> selectPerformanceByPerformanceTitle(int page, String performanceTitle);
	/**
	 * 공연정보 작성자로 검색 페이징
	 * @param performanceUserId
	 * @return
	 */
	Map<String, Object> selectPerformanceByPerformanceUserId(int page, String userId);
	/**
	 * 공연정보 공연장소로 검색 페이징
	 * @param performanceLocation
	 * @return
	 */
	Map<String, Object> selectPerformanceByPerformanceLocation(int page, String performanceLocation);
	/**
	 * 공연정보 공연이름으로 검색 페이징
	 * @param performanceName
	 * @return
	 */
	Map<String, Object> selectPerformanceByPerformanceName(int page, String performanceName);
	/**
	 * 공연정보 내용으로 검색 페이징
	 * @param performanceContent
	 * @return
	 */
	Map<String, Object> selectPerformanceByPerformanceContent(int page, String performanceContent);
}
