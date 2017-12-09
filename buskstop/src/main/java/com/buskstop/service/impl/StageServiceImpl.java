package com.buskstop.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buskstop.common.util.PagingBean;
import com.buskstop.dao.StageDao;
import com.buskstop.dao.StageImageDao;
import com.buskstop.service.StageService;
import com.buskstop.vo.Stage;
import com.buskstop.vo.StageImage;

@Service
public class StageServiceImpl implements StageService{
	
	
	@Autowired
	private StageDao stageDao;
	
	@Autowired
	private StageImageDao stageImageDao;
	
	@Override
	public void insertStage(Stage stage) {
		stageDao.insertStage(stage);
	}
	
	@Override
	public void insertStageImage(StageImage stageImage) {
		stageImageDao.insertStageImage(stageImage);
	}
	
	@Override
	public Stage selectStageByStageNo(int stageNo) {
		return stageDao.selectStageByStageNo(stageNo);
	}
	
	@Override
	public List<Stage> selectStage() {
		return stageDao.selectStage();
	}
	
	@Override
	public Map<String, Object> selectAllStage(int page){
		System.out.println("서비스");
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb = new PagingBean(stageDao.selectStageCount(),page);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectAllStage(pb.getBeginItemInPage(),pb.getEndItemInPage());
		map.put("list",list);		
		return map;
	}
	
	@Override
	public Map<String,Object> selectStageByStageLocation(int page, String locationSearch, Date startDate, Date endDate){
		System.out.println("장소 검색");
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb= new PagingBean(stageDao.selectStageCountByLocation(locationSearch,startDate,endDate),page);
		System.out.println("페이징 : "+pb);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectStageByStageLocation(pb.getBeginItemInPage(), pb.getEndItemInPage(), locationSearch,startDate,endDate);
		map.put("list",list);
		System.out.println("장소 검색하고 뽑아온 리스트 : "+list);
		return map;
	}

	@Override
	public Map<String, Object> selectStageByInstrument(int page, String instrumentSearch, Date startDate, Date endDate) {
		System.out.println("악기 검색");
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb= new PagingBean(stageDao.selectStageCountByInstrument(instrumentSearch,startDate,endDate),page);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectStageByInstrument(pb.getBeginItemInPage(), pb.getEndItemInPage(), instrumentSearch,startDate,endDate);
		map.put("list",list);
		System.out.println("악기 검색하고 뽑아온 리스트 : "+list);
		return map;
	}

	@Override
	public Map<String, Object> selectStageByStageDate(int page, Date startDate, Date endDate) {
		System.out.println("날짜 검색");
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb= new PagingBean(stageDao.selectStageCountByStageDate(startDate,endDate),page);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectStageByStageDate(pb.getBeginItemInPage(), pb.getEndItemInPage(), startDate, endDate);
		map.put("list", list);
		return map;
	}
	
	@Override
	public Map<String, Object> selectStageByStageSellerId(int page, String idSearch,Date startDate, Date endDate) {
		System.out.println("아이디 검색");
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb= new PagingBean(stageDao.selectStageCountById(idSearch,startDate,endDate),page);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectStageById(pb.getBeginItemInPage(), pb.getEndItemInPage(), idSearch,startDate,endDate);
		map.put("list",list);
		System.out.println("악기 검색하고 뽑아온 리스트 : "+list);
		return map;
	}
	
	@Override
	public Map<String,Object> selectStageOnlyId(int page, String idSearch){
		System.out.println("단일 아이디 검색");
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb = new PagingBean(stageDao.selectStageCountOnlyId(idSearch),page);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectStageOnlyId(pb.getBeginItemInPage(),pb.getEndItemInPage(),idSearch);
		map.put("list",list);
		return map;
	}
	
	@Override
	public Map<String,Object> selectStageOnlyLocation(int page, String locationSearch){
		System.out.println("단일 장소 검색");
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb = new PagingBean(stageDao.selectStageCountOnlyLocation(locationSearch),page);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectStageOnlyLocation(pb.getBeginItemInPage(),pb.getEndItemInPage(),locationSearch);
		map.put("list",list);
		return map;
	}
	
	@Override
	public Map<String,Object> selectStageOnlyInstrument(int page, String instrumentSearch){
		System.out.println("단일 악기 검색");
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb = new PagingBean(stageDao.selectStageCountOnlyInstrument(instrumentSearch),page);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectStageOnlyInstrument(pb.getBeginItemInPage(),pb.getEndItemInPage(),instrumentSearch);
		map.put("list",list);
		System.out.println("단일 악기 서비스까지 나오는 리스트"+list);
		return map;
	}
	
	
	@Override
	public void updateStage(Stage stage) {
		stageDao.updateStage(stage);
	}
	
	@Override
	public List<StageImage> selectStageImageByStageNo(int stageNo) {
		return stageImageDao.selectStageImageByStageNo(stageNo);
	}
	
	@Override
	public void deleteStageImageByStageNo(int stageNo) {
		stageImageDao.deleteStageImageByStageNo(stageNo);
	}

	@Override
	@Transactional
	public void registStageImage(int establishNum, List<String> imageList) {
		for(String stageImage : imageList) {
			stageImageDao.insertStageImage(new StageImage(1, stageImage, establishNum));
		}
	}
	
	@Override
	public void deleteStageByStageNo(int stageNo) {
		stageDao.deleteStageByStageNo(stageNo);
	}
	
	@Override
	public void deleteStageImageByStageImageNo(int stageImageNo) {
		stageImageDao.deleteStageImageByStageImageNo(stageImageNo);
	}
	
}
