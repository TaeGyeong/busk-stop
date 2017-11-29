package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.PerformanceComment;

public interface PerformanceCommentService {

	List<PerformanceComment> selectListComment(int performanceNo);

	void insertPerformanceComment(PerformanceComment performanceComment);

	int deletePerformanceCommentByPerformanceCommentNo(int performanceCommentNo);

	void updatePerformanceComment(PerformanceComment performanceComment);

}
