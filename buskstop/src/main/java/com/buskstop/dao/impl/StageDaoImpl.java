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
		System.out.println("dao");
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
	public int updateStage(Stage stage) {
		return session.update(makeSqlId("updateStage"), stage);
	}
	
	@Override
	public int updateStageForStageReservation(int stageNo, int stageReservation) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("stageNo", stageNo);
		map.put("stageReservation", stageReservation);
		
		return session.update(makeSqlId("updateStageForStageReservation"), map);
	}

	@Override
	public int selectStageCountByLocation(String stageLocation, Date startDate, Date endDate) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("stageLocation", stageLocation);
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		
		return session.selectOne(makeSqlId("selectStageCountByLocation"), map);
	}

	@Override
	public List<Stage> selectStageByStageLocation(int beginItemInPage, int endItemInPage, String locationSearch, Date startDate, Date endDate) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end", endItemInPage);
		map.put("stageLocation", locationSearch);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		System.out.println("dao까지 가져온 것"+ map);
		return session.selectList(makeSqlId("selectStageByStageLocation"),map);
	}
	
	@Override
	public int selectStageCountById(String idSearch, Date startDate, Date endDate) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("stageSellerId", idSearch);
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		
		return session.selectOne(makeSqlId("selectStageCountById"), map);
	}

	@Override
	public List<Stage> selectStageById(int beginItemInPage, int endItemInPage, String idSearch, Date startDate, Date endDate) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end", endItemInPage);
		map.put("stageLocation", idSearch);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		System.out.println("dao까지 가져온 것"+ map);
		return session.selectList(makeSqlId("selectStageById"),map);
	}

	@Override
	public int selectStageCountByName(String name, Date startDate, Date endDate) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("stageName", name);
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		return session.selectOne(makeSqlId("selectStageCountByName"),map);
	}

	@Override
	public List<Stage> selectStageByName(int beginItemInPage, int endItemInPage, String nameSearch, Date startDate, Date endDate) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end", endItemInPage);
		map.put("stageName", nameSearch);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		System.out.println("dao까지 가져온 것"+ map);
		return session.selectList(makeSqlId("selectStageByName"),map);
	}

	@Override
	public int selectStageCountByStageDate(Date startDate, Date endDate) {
		System.out.println("dao 카운터 데이트");
		HashMap<String, Object> map = new HashMap<>();
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		return session.selectOne(makeSqlId("selectStageCountByStageDate"),map);
	}

	@Override
	public List<Stage> selectStageByStageDate(int beginItemInPage, int endItemInPage, Date startDate, Date endDate) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end", endItemInPage);
		map.put("startDate",startDate);
		map.put("endDate",endDate);		
		return session.selectList(makeSqlId("selectStageByStageDate"),map);
	}

	@Override
	public int selectStageCountOnlyId(String stageSellerId){
		return session.selectOne(makeSqlId("selectStageCountOnlyId"),stageSellerId);
	}
	
	@Override
	public List<Stage> selectStageOnlyId(int beginItemInPage, int endItemInPage, String idSearch){
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end",endItemInPage);
		map.put("stageSellerId",idSearch);
		return session.selectList(makeSqlId("selectStageOnlyId"),map);
	}
	
	@Override
	public int selectStageCountOnlyLocation(String stageLocation){
		System.out.println(stageLocation);
		return session.selectOne(makeSqlId("selectStageCountOnlyLocation"),stageLocation);
	}
	
	@Override
	public List<Stage> selectStageOnlyLocation(int beginItemInPage, int endItemInPage, String locationSearch){
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end",endItemInPage);
		map.put("stageLocation",locationSearch);
		return session.selectList(makeSqlId("selectStageOnlyLocation"),map);
	}
	
	@Override
	public int selectStageCountOnlyName(String stageName){
		return session.selectOne(makeSqlId("selectStageCountOnlyName"),stageName);
	}
	
	@Override
	public List<Stage> selectStageOnlyName(int beginItemInPage, int endItemInPage, String nameSearch){
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end",endItemInPage);
		map.put("stageName",nameSearch);
		return session.selectList(makeSqlId("selectStageOnlyName"),map);
	}
	
	@Override
	public int selectStageCountByLocationAndName(String nameSearch, Date startDate, Date endDate, String locationSearch) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("stageName", nameSearch);
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		map.put("stageLocation", locationSearch);
		return session.selectOne(makeSqlId("selectStageCountByLocationAndName"),map);
	}

	@Override
	public List<Stage> selectStageByLocationAndName(int beginItemInPage, int endItemInPage, String nameSearch, Date startDate, Date endDate, String locationSearch) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("begin", beginItemInPage);
		map.put("end", endItemInPage);
		map.put("stageName", nameSearch);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("stageLocation", locationSearch);
		System.out.println("dao까지 가져온 것"+ map);
		return session.selectList(makeSqlId("selectStageByLocationAndName"),map);
	}


	@Override
	public int deleteStageByStageNo(int stageNo) {
		return session.delete(makeSqlId("deleteStageByStageNo"), stageNo);
	}
	
}

