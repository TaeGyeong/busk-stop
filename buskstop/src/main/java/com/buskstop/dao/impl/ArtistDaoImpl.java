package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.ArtistDao;
import com.buskstop.vo.Artist;

@Repository
public class ArtistDaoImpl implements ArtistDao{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertArtist(Artist artist) {
		return session.insert(makeSqlId("insertArtist"),artist);
	}
	

	private String makeSqlId(String id){
		return "com.buskstop.config.mybatis.mapper.authorityMapper."+id;
	}
	
}