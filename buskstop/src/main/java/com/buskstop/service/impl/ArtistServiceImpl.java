package com.buskstop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buskstop.dao.ArtistDao;
import com.buskstop.dao.AuthorityDao;
import com.buskstop.service.ArtistService;
import com.buskstop.vo.Artist;
import com.buskstop.vo.Authority;

@Service
public class ArtistServiceImpl implements ArtistService{

	@Autowired
	ArtistDao artistDao;
	
	@Autowired
	AuthorityDao authorityDao;
	
	@Override
	public void registerArtist(Artist artist) {
		artistDao.insertArtist(artist);
		authorityDao.insertAuthority(new Authority(artist.getArtistId(),"ROLE_ARTIST"));
	}
	
}
