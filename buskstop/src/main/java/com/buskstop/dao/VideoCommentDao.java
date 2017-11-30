package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.VideoComment;

public interface VideoCommentDao {

	/**
	 * 동영상 댓글 등록
	 * @param videoComment
	 * @return
	 */
	int insertVideoComment(VideoComment videoComment);
	
	/**
	 * 동영상 번호로 해당 동영상의 댓글 모두 조회
	 * @param videoNo
	 * @return
	 */
	List<VideoComment> selectVideoCommentByVideoNo(int videoNo);
}
