package com.buskstop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buskstop.dao.PerformanceCommentDao;
import com.buskstop.service.PerformanceCommentService;
import com.buskstop.vo.PerformanceComment;

@Service
public class PerformanceCommentServiceImpl implements PerformanceCommentService{
	
	@Autowired
	private PerformanceCommentDao dao;
	
	@Override
	public List<PerformanceComment> selectListComment(int performanceNo){
		return dao.selectListComment(performanceNo);
	}
	
	@Override
	public void insertPerformanceComment(PerformanceComment performanceComment) {
		dao.insertPerformanceComment(performanceComment);
	}
	
	@Override
	public int deletePerformanceCommentByPerformanceCommentNo(int performanceCommentNo) {
		return dao.deletePerformanceCommentByPerformanceCommentNo(performanceCommentNo);
	}
	
	@Override
	public void updatePerformanceComment(PerformanceComment performanceComment) {
		dao.updatePerformanceComment(performanceComment);
	}

}
