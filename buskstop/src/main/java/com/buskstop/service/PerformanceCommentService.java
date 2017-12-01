package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.PerformanceComment;

public interface PerformanceCommentService {

	void insertPerformanceComment(PerformanceComment performanceComment);

	int deletePerformanceCommentByPerformanceCommentNo(int performanceCommentNo);

	void updatePerformanceComment(PerformanceComment performanceComment);
	
	List<PerformanceComment> listComment(int performanceNo);
}
