package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.Authority;

public interface AuthorityService {
	
	boolean readArtistAutoritiesByUserId(String userId);
}
