package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.Authority;

public interface AuthorityService {
	
	/**
	 * 사용자 id로 사용자에게 아티스트 권한이 있는지 조회
	 * @param userId
	 * @return
	 */
	boolean readArtistAutoritiesByUserId(String userId);
}
