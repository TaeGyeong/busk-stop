package com.buskstop.service;

import java.util.List;
import com.buskstop.vo.Video;
import com.buskstop.vo.VideoLike;

public interface VideoService {
	/**
	 * 좋아요 정보를 저장
	 * @param like
	 */
	public void plusLike(VideoLike like);
	/**
	 * 좋아요 정보 삭제
	 * @param like
	 */
	public void deleteLike(VideoLike like);
	/**
	 * 좋아요누른 유저정보 조회
	 * @param num
	 * @return
	 */
	public List<VideoLike> selectLikeUserByNum(int num);
	
	/**
	 * 동영상 등록
	 * @param video
	 */
	int insertVideo(Video video);
	
	/**
	 * 
	 * 동영상 번호로 동영상 조회
	 * @param videoNo
	 * @return
	 */
	Video selectVideoByVideoNo(int videoNo);
	
	/**
	 * 모든 공연영상을 조회.
	 * @return
	 */
	List<Video> viewAllVideo(String category);
	
	/**
	 * 동영상의 정보를 수정한다.
	 * @param video
	 * @return
	 */
	int updateVideo(Video video);
	
	/**
	 * 영상번호를 받아 동영상 정보를 제거한다.
	 * @param videoNo
	 * @return
	 */
	int deleteVideoByVideoNum(int videoNo);
}
