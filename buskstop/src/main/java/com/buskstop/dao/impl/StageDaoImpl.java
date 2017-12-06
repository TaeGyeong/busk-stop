package com.buskstop.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.StageDao;
import com.buskstop.vo.Stage;

@Repository
public class StageDaoImpl implements StageDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.stageMapper."+id;
	}
	
	@Override
	public int insertStage(Stage stage) {
		return session.insert(makeSqlId("insertStage"), stage);
	}
	
	@Override
	public Stage selectStageByStageNo(int stageNo) {
		return session.selectOne(makeSqlId("selectStageByStageNo"),stageNo);
	}
	
	@Override
	public List<Stage> selectStage() {
		return session.selectOne(makeSqlId("selectStage"));
	}
	
	@Override
	public List<Stage> selectAllStage(int beginNum, int endNum) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("begin", beginNum);
		map.put("end",endNum);
		return session.selectList(makeSqlId("selectAllStage"),map);
	}
	
	@Override
	public int selectStageCount() {
		return session.selectOne(makeSqlId("selectStageCount"));
	}

	@Override
	public int selectStageCountByLocation(String stageLocation, String sDate, String eDate) {
		return session.selectOne(makeSqlId("selectStageCountByLocation"), stageLocation);
	}

	@Override
	public List<Stage> selectStageByStageLocation(int beginItemInPage, int endItemInPage, String stageLocation, String sDate, String eDate) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end", endItemInPage);
		map.put("stageLocation", stageLocation);
		map.put("sDate", sDate);
		map.put("eDate", eDate);
		return session.selectList(makeSqlId("selectStageByStageLocation"),map);
	}

	@Override
	public int selectStageCountByInstrument(String instrument, String sDate, String eDate) {
		return session.selectOne(makeSqlId("selectStageCountByInstrument"),instrument);
	}

	@Override
	public List<Stage> selectStageByInstrument(int beginItemInPage, int endItemInPage, String instrument, String sDate, String eDate) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end", endItemInPage);
		map.put("stageLocation", instrument);
		map.put("sDate", sDate);
		map.put("eDate", eDate);
		return session.selectList(makeSqlId("selectStageByInstrument"),map);
	}

	@Override
	public int selectStageCountByStageDate(Date startDate, Date endDate) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("sDate", startDate);
		map.put("eDate",endDate);
		return session.selectOne(makeSqlId("selectStageCountByStageDate"),map);
	}

	@Override
	public List<Stage> selectStageByStgeDate(int beginItemInPage, int endItemInPage, Date startDate, Date endDate) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end", endItemInPage);
		map.put("sDate",startDate);
		map.put("eDate",endDate);		
		return session.selectList(makeSqlId("selectStageByStageDate"),map);
	}

}

