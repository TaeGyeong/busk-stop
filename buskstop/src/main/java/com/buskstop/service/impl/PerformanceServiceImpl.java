package com.buskstop.service.impl;

import java.util.Date;
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

	public List<Performance> selectAllPerformance() {

		List<Performance> list = dao.selectAllPerformance();
		return list;
	}

	public List<Performance> selectPerformanceByPerformanceTitle(String performanceTitle) {

		List<Performance> list = dao.selectPerformanceByPerformanceTitle(performanceTitle);
		return list;
	}

	public List<Performance> selectPerformanceByPerformanceUserId(String performanceUserId) {

		List<Performance> list = dao.selectPerformanceByPerformanceUserId(performanceUserId);
		return list;
	}

	public List<Performance> selectPerformanceByPerformanceLocation(String performanceLocation) {

		List<Performance> list = dao.selectPerformanceByPerformanceLocation(performanceLocation);
		return list;
	}

	public List<Performance> selectPerformanceByPerformanceName(String performanceName) {

		List<Performance> list = dao.selectPerformanceByPerformanceName(performanceName);
		return list;
	}

	public List<Performance> selectPerformanceByPerformanceContent(String performanceContent) {

		List<Performance> list = dao.selectPerformanceByPerformanceContent(performanceContent);
		return list;
	}
}
