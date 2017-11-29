package com.buskstop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buskstop.vo.Authority;

@Service
public interface AuthorityService {
	
	boolean readArtistAutoritiesByUserId(String userId);
}
