package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.Video;

public interface VideoDao {

	/**
	 * 동영상 등록
	 * @param video
	 * @return
	 */
	int insertVideo (Video video);
	
	/**
	 * 동영상 번호로 동영상 조회
	 * @param videoNo
	 * @return
	 */
	Video selectVideoByVideoNo (int videoNo);	
	
	/**
	 * 모든 동영상 조회
	 * @return
	 */
	List<Video> selectAllVideoByCategory (String category);
	
	
	/**
	 * 동영상의 정보를 수정
	 * @param video
	 * @return
	 */
	int updateVideo(Video video);
}
