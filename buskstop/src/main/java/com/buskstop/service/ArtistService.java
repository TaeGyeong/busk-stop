package com.buskstop.service;

import com.buskstop.vo.Artist;

public interface ArtistService {
	void registerArtist(Artist artist);
	
	Artist readArtistByUserId(String userId);
}
