package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.PerformanceLike;

public interface PerformanceLikeService {

	/**
	 * 공연정보 좋아요 추가
	 * @param like
	 */
	void insertPerformanceLike(PerformanceLike like);
	
	/**
	 * 공연정보 좋아요 삭제
	 * @param like
	 */
	void deletePerformanceLike(PerformanceLike like);
	
	/**
	 * 공연정보 좋아요 회원 조회
	 * @param num
	 * @return
	 */
	List<PerformanceLike> selectperformanceLikeByPerformanceLikeNo(int num);
}
