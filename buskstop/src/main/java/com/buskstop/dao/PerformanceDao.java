package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.Performance;
import com.buskstop.vo.PerformanceLike;

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
	
	//모든 공연 정보 조회
	List<Performance> selectAllPerfor();
	
	//모든 공연 정보 조회 페이징
	List<Performance> selectAllPerformance(int beginItemNum, int endItemNum);
	//모든 정보 count
	int selectPerformanceCount();
	
	//제목으로 검색 페이징
	List<Performance> selectPerformanceByPerformanceTitle(int beginItemNum, int endItemNum, String performanceTitle);
	//제목으로 검색 count 
	int selectPerformanceCountByTitle(String performanceTitle);
	
	//작성자로 검색 페이징
	List<Performance> selectPerformanceByPerformanceUserId(int beginItemNum, int endItemNum, String performanceUserId);
	//작성자로 검색 count
	int selectPerformanceCountByUserId(String userId);
		
	//공연장소로 검색 페이징
	List<Performance> selectPerformanceByPerformanceLocation(int beginItemNum, int endItemNum, String performanceLocation);
	//공연장소로 검색 count
	int selectPerformanceCountByLocation(String location);
	
	//공연이름으로 검색 페이징
	List<Performance> selectPerformanceByPerformanceName(int beginItemNum, int endItemNum, String performanceName);
	//공연이름으로 검색 count
	int selectPerformanceCountByPerformanceName(String performanceName);
	
	//공연내용으로 검색 페이징
	List<Performance> selectPerformanceByPerformanceContent(int beginItemNum, int endItemNum, String performanceContent);
	//공연내용으로 검색 count
	int selectPerformanceCountByPerformanceContent(String content);
}
