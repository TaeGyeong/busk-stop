package com.buskstop.service.impl;

import java.util.List;

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
		List<VideoLike> list = videoLikeDao.selectLikeUserByVideoNum(num);
		for(VideoLike u : list) {
			System.out.println(u);
			System.out.println(list.size());
		}
		return list;
	}
}
