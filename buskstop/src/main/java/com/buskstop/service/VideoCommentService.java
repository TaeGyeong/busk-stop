package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.VideoComment;

public interface VideoCommentService {

	public void insertVideoComment(VideoComment videoComment);
	
	public List<VideoComment> selectVideoCommentByVideoNo(int videoNo);
}
