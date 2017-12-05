package com.buskstop.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buskstop.common.util.PagingBean;
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

	/********************************************************************************************/
	@Override 
	public Map<String, Object> selectPerformance(int page) {

		HashMap<String, Object> map = new HashMap<>();
		
		//PagingBean 생성
		PagingBean pb = new PagingBean(dao.selectPerformanceCount(), page);
		
		map.put("pageBean", pb);
		List<Performance> list = dao.selectPerformance(pb.getBeginItemInPage(), pb.getEndItemInPage());		
		
		map.put("list", list);
		
		return map;
	}
	
	@Override 
	public Map<String, Object> selectArtistPerformance(int page) {

		HashMap<String, Object> map = new HashMap<>();
		
		//PagingBean 생성
		PagingBean pb = new PagingBean(dao.selectArtistPerformanceCount(), page);
		
		map.put("pageBean", pb);
		List<Performance> list = dao.selectArtistPerformance(pb.getBeginItemInPage(), pb.getEndItemInPage());		
		
		map.put("list", list);
		
		return map;
	}
	
	/********************************************************************************************/
	@Override
	public List<Performance> selectAllPerfor(){
		return dao.selectAllPerfor();
	}
	
	@Override
	public Performance PerformanceByPerformanceNo(int performanceNo){
		return dao.selectPerformanceByPerformanceNo(performanceNo);
	}
	
	public void updatePerformanceCountByPerformanceNo(int performanceNo){
		dao.updatePerformanceCountByPerformanceNo(performanceNo);
	}
	
	// 공연정보 검색
	// 제목으로 검색 페이징
	@Override
	public Map<String, Object> selectPerformanceByPerformanceTitle(int page,String performanceTitle) {

		HashMap<String, Object> map = new HashMap<>();
		//PagingBean 생성
		PagingBean pb = new PagingBean(dao.selectPerformanceCountByTitle(performanceTitle), page);
		
		map.put("pageBean", pb);
		List<Performance> list = dao.selectPerformanceByPerformanceTitle(pb.getBeginItemInPage(), pb.getEndItemInPage(), performanceTitle);		
		map.put("list", list);
		
		return map;
	}

	// 작성자로 검색 페이징
	@Override
	public Map<String, Object> selectPerformanceByPerformanceUserId(int page, String userId) {

		HashMap<String, Object> map = new HashMap<>();
		//PagingBean 생성
		PagingBean pb = new PagingBean(dao.selectPerformanceCountByUserId(userId), page);
		
		map.put("pageBean", pb);
		List<Performance> list = dao.selectPerformanceByPerformanceUserId(pb.getBeginItemInPage(), pb.getEndItemInPage(), userId);
		map.put("list", list);
		
		return map;
	}

	//공연장소로 검색 페이징
	@Override
	public Map<String, Object> selectPerformanceByPerformanceLocation(int page, String performanceLocation) {

		HashMap<String, Object> map = new HashMap<>();
		//PagingBean 생성
		PagingBean pb = new PagingBean(dao.selectPerformanceCountByLocation(performanceLocation), page);
		
		map.put("pageBean", pb);
		List<Performance> list = dao.selectPerformanceByPerformanceLocation(pb.getBeginItemInPage(), pb.getEndItemInPage(), performanceLocation);
		map.put("list", list);
		
		return map;
	}

	//공연이름으로 검색 페이징
	@Override
	public Map<String, Object> selectPerformanceByPerformanceName(int page, String performanceName) {

		HashMap<String, Object> map = new HashMap<>();
		//PagingBean 생성
		PagingBean pb = new PagingBean(dao.selectPerformanceCountByPerformanceName(performanceName), page);
		
		map.put("pageBean", pb);
		List<Performance> list = dao.selectPerformanceByPerformanceName(pb.getBeginItemInPage(), pb.getEndItemInPage(), performanceName);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> selectPerformanceByPerformanceContent(int page, String performanceContent) {

		HashMap<String, Object> map = new HashMap<>();
		//PagingBean 생성
		PagingBean pb = new PagingBean(dao.selectPerformanceCountByPerformanceContent(performanceContent), page);
		
		map.put("pageBean", pb);
		List<Performance> list = dao.selectPerformanceByPerformanceContent(pb.getBeginItemInPage(), pb.getEndItemInPage(), performanceContent);
		map.put("list", list);
		
		return map;
	}
	
	@Override
	public Map<String, Object> selectPerformanceByPerformanceDate(int page, Date sDate, Date eDate){
		
		HashMap<String, Object> map = new HashMap<>();
		//PagingBean 생성
		PagingBean pb = new PagingBean(dao.selectPerformanceCountByPerformanceDate(sDate, eDate), page);
		
		map.put("pageBean", pb);
		List<Performance> list = dao.selectPerformanceByPerformanceDate(pb.getBeginItemInPage(), pb.getEndItemInPage(), sDate, eDate);
		map.put("list", list);
		
		return map;
	}
	
	/****************************************************
	 * 	Artist Performance Select Service & Paging
	 ****************************************************/
	
	// 공연정보 검색
		// 제목으로 검색 페이징
		@Override
		public Map<String, Object> selectArtistPerformanceByPerformanceTitle(int page,String performanceTitle) {

			HashMap<String, Object> map = new HashMap<>();
			//PagingBean 생성
			PagingBean pb = new PagingBean(dao.selectArtistPerformanceCountByTitle(performanceTitle), page);
			
			map.put("pageBean", pb);
			List<Performance> list = dao.selectArtistPerformanceByPerformanceTitle(pb.getBeginItemInPage(), pb.getEndItemInPage(), performanceTitle);		
			map.put("list", list);
			
			return map;
		}

		// 작성자로 검색 페이징
		@Override
		public Map<String, Object> selectArtistPerformanceByPerformanceUserId(int page, String userId) {

			HashMap<String, Object> map = new HashMap<>();
			//PagingBean 생성
			PagingBean pb = new PagingBean(dao.selectArtistPerformanceCountByUserId(userId), page);
			
			map.put("pageBean", pb);
			List<Performance> list = dao.selectArtistPerformanceByPerformanceUserId(pb.getBeginItemInPage(), pb.getEndItemInPage(), userId);
			map.put("list", list);
			
			return map;
		}

		//공연장소로 검색 페이징
		@Override
		public Map<String, Object> selectArtistPerformanceByPerformanceLocation(int page, String performanceLocation) {

			HashMap<String, Object> map = new HashMap<>();
			//PagingBean 생성
			PagingBean pb = new PagingBean(dao.selectArtistPerformanceCountByLocation(performanceLocation), page);
			
			map.put("pageBean", pb);
			List<Performance> list = dao.selectArtistPerformanceByPerformanceLocation(pb.getBeginItemInPage(), pb.getEndItemInPage(), performanceLocation);
			map.put("list", list);
			
			return map;
		}

		//공연이름으로 검색 페이징
		@Override
		public Map<String, Object> selectArtistPerformanceByPerformanceName(int page, String performanceName) {

			HashMap<String, Object> map = new HashMap<>();
			//PagingBean 생성
			PagingBean pb = new PagingBean(dao.selectArtistPerformanceCountByPerformanceName(performanceName), page);
			
			map.put("pageBean", pb);
			List<Performance> list = dao.selectArtistPerformanceByPerformanceName(pb.getBeginItemInPage(), pb.getEndItemInPage(), performanceName);
			map.put("list", list);
			
			return map;
		}

		@Override
		public Map<String, Object> selectArtistPerformanceByPerformanceContent(int page, String performanceContent) {

			HashMap<String, Object> map = new HashMap<>();
			//PagingBean 생성
			PagingBean pb = new PagingBean(dao.selectArtistPerformanceCountByPerformanceContent(performanceContent), page);
			
			map.put("pageBean", pb);
			List<Performance> list = dao.selectArtistPerformanceByPerformanceContent(pb.getBeginItemInPage(), pb.getEndItemInPage(), performanceContent);
			map.put("list", list);
			
			return map;
		}
	
}
