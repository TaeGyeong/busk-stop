package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.VideoComment;

public interface VideoCommentService {

	void insertVideoComment(VideoComment videoComment);
	
	List<VideoComment> selectVideoCommentByVideoNo(int videoNo);
	
	int updateVideoCommentByVideoCommentNo(VideoComment videoComment);
	
	int deleteVideoCommentByVideoCommentNo(int videoCommentNo);
}
