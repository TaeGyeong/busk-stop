package com.buskstop.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.VideoDao;
import com.buskstop.vo.Video;

@Repository
public class VideoDaoImpl implements VideoDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.videoMapper."+id;
	}

	@Override//동영상 등록
	public int insertVideo(Video video) {
		return session.insert(makeSqlId("insertVideo"), video);
	}
	
	@Override//동영상 번호로 동영상 조회
	public Video selectVideoByVideoNo(int videoNo) {
		return session.selectOne(makeSqlId("selectVideoByVideoNo"), videoNo);
	}

	@Override//카테고리로 영상 조회
	public List<Video> selectAllVideoByCategory(String category) {
		return session.selectList(makeSqlId("selectAllVideoByCategory"),category);
	}
	
}
