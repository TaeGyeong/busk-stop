package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.Follow;

public interface FollowDao {
	/**
	 * follow정보 insert
	 * @param follow
	 * @return
	 */
	int insertFollow(Follow follow);
	
	/**
	 * follow 정보 delete
	 * @param follow
	 * @return
	 */
	int deleteFollow(Follow follow);
	
	/**
	 * userId로 follow 정보 전체조회
	 * @param userId
	 * @return
	 */
	List<Follow> selectFollowByUserId(String userId);
}
