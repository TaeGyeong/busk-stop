package com.buskstop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buskstop.dao.PerformanceDao;
import com.buskstop.service.PerformanceService;
import com.buskstop.vo.Performance;

@Service
public class PerformanceServiceImpl implements PerformanceService {

	@Autowired
	private PerformanceDao dao;
	
	// 공연정보 등록
	@Override
	@Transactional
	public void insertPerformance(Performance performance) {
		// Performance 테이블 insert
		dao.insertPerformance(performance);
	}

	@Override
	public Performance getPerformanceByPerformanceNo(int performanceNo) {
		return dao.selectPerformanceByPerformanceNo(performanceNo);
	}

	@Override
	public void updatePerformance(Performance performance) {
		dao.updatePerformance(performance);
	}

	@Override
	public int deletePerformanceByPerformance(int performanceNo) {
		return dao.deletePerformanceByPerformanceNo(performanceNo);
	}

	@Override
	public List<Performance> selectAllPerformance() {
		List<Performance> list = dao.selectAllPerformance();
		return list;
	}
	
	@Override
	public Performance PerformanceByPerformanceNo(int performanceNo){
		return dao.selectPerformanceByPerformanceNo(performanceNo);
	}
	
	public void updatePerformanceCountByPerformanceNo(int performanceNo){
		dao.updatePerformanceCountByPerformanceNo(performanceNo);
	}
	
	// 공연정보 검색
	@Override
	public List<Performance> selectPerformanceByPerformanceTitle(String performanceTitle) {

		List<Performance> list = dao.selectPerformanceByPerformanceTitle(performanceTitle);
		return list;
	}

	@Override
	public List<Performance> selectPerformanceByPerformanceUserId(String performanceUserId) {

		List<Performance> list = dao.selectPerformanceByPerformanceUserId(performanceUserId);
		return list;
	}

	@Override
	public List<Performance> selectPerformanceByPerformanceLocation(String performanceLocation) {

		List<Performance> list = dao.selectPerformanceByPerformanceLocation(performanceLocation);
		return list;
	}

	@Override
	public List<Performance> selectPerformanceByPerformanceName(String performanceName) {

		List<Performance> list = dao.selectPerformanceByPerformanceName(performanceName);
		return list;
	}

	@Override
	public List<Performance> selectPerformanceByPerformanceContent(String performanceContent) {

		List<Performance> list = dao.selectPerformanceByPerformanceContent(performanceContent);
		return list;
	}
	// 좋아요 조인 조회
	@Override
	public List<Performance> selectAllPerformanceJoin(){
		List<Performance> list = dao.selectAllPerformanceJoin();
		return list;
	}
	
}
