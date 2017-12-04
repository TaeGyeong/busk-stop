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
	
	int updatePerformanceCountByPerformanceNo(int performanceNo);
	
	int deletePerformanceByPerformanceNo(int performanceNo);

	int updatePerformance(Performance performance);
	
	//모든 공연 정보 조회
	List<Performance> selectAllPerfor();
	
	//모든 공연 정보 조회 페이징
	List<Performance> selectPerformance(int beginItemNum, int endItemNum);
	//모든 정보 count
	int selectPerformanceCount();
	
	
	/**
	 * 	아티스트 공연정보 전체조회
	 * @param beginItemNum
	 * @param endItemNum
	 * @return
	 */
	List<Performance> selectArtistPerformance(int beginItemNum, int endItemNum);
	
	/**
	 * 	아티스트 공연정보 수 카운트
	 * @return
	 */
	int selectArtistPerformanceCount();
	
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
	
	
	/*************************************************************************************
	 * 	Artist Performance Search Paging
	 *************************************************************************************/
	
	/**
	 * 제목으로 검색 페이징
	 * @param beginItemNum
	 * @param endItemNum
	 * @param performanceTitle
	 * @return
	 */
	List<Performance> selectArtistPerformanceByPerformanceTitle(int beginItemNum, int endItemNum,String performanceTitle);

	/**
	 * 제목으로 검색결과 카운트
	 * @param performanceTitle
	 * @return
	 */
	int selectArtistPerformanceCountByTitle(String performanceTitle);
	
	/**
	 * 유저id 로 검색페이징
	 * @param beginItemNum
	 * @param endItemNum
	 * @param performanceUserId
	 * @return
	 */
	List<Performance> selectArtistPerformanceByPerformanceUserId(int beginItemNum, int endItemNum, String performanceUserId);

	/**
	 * 카운트
	 * @param userId
	 * @return
	 */
	int selectArtistPerformanceCountByUserId(String userId);

	/**
	 * 공연장소로 검색결과 페이징
	 * @param beginItemNum
	 * @param endItemNum
	 * @param performanceLocation
	 * @return
	 */
	List<Performance> selectArtistPerformanceByPerformanceLocation(int beginItemNum, int endItemNum, String performanceLocation);

	/**
	 * 공연장소로 검색 카운트
	 * @param location
	 * @return
	 */
	int selectArtistPerformanceCountByLocation(String location);

	/**
	 * 공연제목으로 검색 페이징
	 * @param beginItemNum
	 * @param endItemNum
	 * @param performanceName
	 * @return
	 */
	List<Performance> selectArtistPerformanceByPerformanceName(int beginItemNum, int endItemNum, String performanceName);

	/**
	 * 공연제목으로 카운트
	 * @param performanceName
	 * @return
	 */
	int selectArtistPerformanceCountByPerformanceName(String performanceName);
	
	/**
	 * 공연내용으로 검색 페이징
	 * @param beginItemNum
	 * @param endItemNum
	 * @param performanceContent
	 * @return
	 */
	List<Performance> selectArtistPerformanceByPerformanceContent(int beginItemNum, int endItemNum, String performanceContent);

	/**
	 * 공연내용으로 검색 카운트
	 * @param content
	 * @return
	 */
	int selectArtistPerformanceCountByPerformanceContent(String content);
}
