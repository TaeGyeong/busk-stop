package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.PerformanceComment;

public interface PerformanceCommentDao {

	
	int insertPerformanceComment(PerformanceComment performanceComment);

	int updatePerformanceComment(PerformanceComment performanceComment);

	int deletePerformanceCommentByPerformanceCommentNo(int performanceCommentNo);

	List<PerformanceComment> listComment(int performanceNo);

}
