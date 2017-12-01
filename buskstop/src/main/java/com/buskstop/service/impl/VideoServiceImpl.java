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
	private VideoLikeDao videoLikeDao;
	
	@Autowired
	private VideoDao dao;
	
	////////////좋아요////////////
	// 좋아요 추가.
	@Override 
	public void plusLike(VideoLike like) {
		videoLikeDao.insertVideoLike(like);
	}
	
	// 좋아요 삭제.
	@Override 
	public void deleteLike(VideoLike like) {
		videoLikeDao.deleteVideoLike(like);
	}
	
	///////////동영상///////////
	
	//동영상 등록
	@Override 
	public int insertVideo(Video video) {
		return dao.insertVideo(video);
	}
	
	// 동영상 수정
	@Override
	public int updateVideo(Video update) {
		return dao.updateVideo(update);
	}

	//동영상 삭제
	@Override
	public int deleteVideoByVideoNum(int videoNo) {
		return dao.deleteVideoByVideoNum(videoNo);
	}

	//----------동영상 조회----------------------------
	
	//동영상번호로 동영상 조회
	@Override 
	public Video viewVideoByVideoNo(int videoNo) {
		return dao.selectVideoByVideoNo(videoNo);
	}
	
	// 동영상 번호로 좋아요 누른 정보 조회.
	@Override 
	public List<VideoLike> selectLikeUserByNum(int num){
		return videoLikeDao.selectLikeUserByVideoNum(num);
	}

	// 모든 동영상 조회.
	@Override 
	public List<Video> viewAllVideo (String category) {
		return dao.selectAllVideoByCategory(category);
	}

	// 제목으로 동영상 조회.
	@Override
	public List<Video> viewVideoByTitleAndCategory(String videoCategory, String videoTitle) {
		return dao.selectVideoByTitleAndCategory(videoCategory, videoTitle);
	}

	// 아티스트로 동영상 조회.
	@Override
	public List<Video> viewVideoByArtistAndCategory(String videoCategory, String videoArtist) {
		return dao.selectVideoByArtistAndCategory(videoCategory, videoArtist);
	}

	// 게시자 id로 동영상 조회.
	@Override
	public List<Video> viewVideoByUserIdAndCategory(String videoCategory, String videoUserId) {
		return dao.selectVideoByUserIdAndCategory(videoCategory, videoUserId);
	}

}
