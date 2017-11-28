package com.buskstop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.buskstop.dao.VideoDao;
import com.buskstop.service.VideoService;
import com.buskstop.vo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.buskstop.dao.VideoLikeDao;
import com.buskstop.service.VideoService;
import com.buskstop.vo.User;
import com.buskstop.vo.VideoLike;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoLikeDao videoLikeDao;
	
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
	@Override
	public void plusLike(VideoLike like) {
		videoLikeDao.insertVideoLike(like);
	}
	
	@Override
	public void deleteLike(VideoLike like) {
		videoLikeDao.deleteVideoLike(like);
	}
	
	@Override
	public List<VideoLike> selectLikeUserByNum(int num){
		return videoLikeDao.selectLikeUserByVideoNum(num);
	}
}
