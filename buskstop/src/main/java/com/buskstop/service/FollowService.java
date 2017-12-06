package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.Follow;

public interface FollowService {
	/**
	 * userId로 팔로우한 artistId를 List로 조회
	 * @param userId
	 * @return
	 */
	boolean searchFollowing(String userId, String followingId);
	
	/**
	 * 팔로우 service
	 */
	void doFollow(String userId, String followingId);
	
	/**
	 * 언팔로우 service
	 */
	void unFollow(String userId, String followingId);
}
