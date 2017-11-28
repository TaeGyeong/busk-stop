package com.buskstop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buskstop.dao.VideoDao;
import com.buskstop.service.VideoService;
import com.buskstop.vo.Video;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoDao dao;
	
	@Override //동영상 등록
	public int insertVideo(Video video) {
		return dao.insertVideo(video);
	}

	@Override //동영상번호로 동영상 조회
	public Video selectVideoByVideoNo(int videoNo) {
		return dao.selectVideoByVideoNo(videoNo);
	}

}
