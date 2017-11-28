package com.buskstop.service;

import com.buskstop.vo.Video;

public interface VideoService {

	/**
	 * 동영상 등록
	 * @param video
	 */
	int insertVideo(Video video);
	
	Video selectVideoByVideoNo(int videoNo);
}
