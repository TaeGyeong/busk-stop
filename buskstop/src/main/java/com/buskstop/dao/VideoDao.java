package com.buskstop.dao;

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
	
	
}
