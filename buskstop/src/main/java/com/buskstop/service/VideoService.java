package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.User;
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
}
