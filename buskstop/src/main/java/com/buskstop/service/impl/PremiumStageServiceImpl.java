package com.buskstop.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buskstop.common.util.PagingBean;
import com.buskstop.dao.AuthorityDao;
import com.buskstop.dao.PremiumStageDao;
import com.buskstop.dao.StageDao;
import com.buskstop.dao.StageImageDao;
import com.buskstop.service.PremiumStageService;
import com.buskstop.vo.Authority;
import com.buskstop.vo.PremiumStage;
import com.buskstop.vo.Stage;
import com.buskstop.vo.StageImage;

@Service
public class PremiumStageServiceImpl implements PremiumStageService{
	
	@Autowired
	private AuthorityDao authorDao;
	
	@Autowired
	private PremiumStageDao supplierDao;
	
	@Autowired
	private StageDao stageDao;
	
	@Autowired
	private StageImageDao stageImageDao;
	
	@Override
	@Transactional
	public void registerSupplier(PremiumStage supplier) {
		supplierDao.insertStageSupplier(supplier);
		authorDao.insertAuthority(new Authority(supplier.getOperatorUserId(), "ROLE_PRODUCER"));
	}
	
	@Override
	public int updateSupplier(PremiumStage supplier) {
		return supplierDao.updateStageSupplier(supplier);
	}

	@Override
	public PremiumStage selectSupplierById(String userId) {
		return supplierDao.selectSupplierById(userId);
	}
	
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
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb = new PagingBean(stageDao.selectStageCount(),page);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectAllStage(pb.getBeginItemInPage(),pb.getEndItemInPage());
		map.put("list",list);		
		return map;
	}
	
	@Override
	public Map<String,Object> selectStageByStageLocation(int page, String stageLocation, String startDate, String endDate){
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb= new PagingBean(stageDao.selectStageCountByLocation(stageLocation,startDate,endDate),page);
		System.out.println("위치:"+stageLocation);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectStageByStageLocation(pb.getBeginItemInPage(), pb.getEndItemInPage(), stageLocation,startDate,endDate);
		map.put("list",list);
		return map;
	}

	@Override
	public Map<String, Object> selectStageByInstrument(int page, String instrument, String startDate, String endDate) {
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb= new PagingBean(stageDao.selectStageCountByInstrument(instrument,startDate,endDate),page);
		
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectStageByInstrument(pb.getBeginItemInPage(), pb.getEndItemInPage(), instrument,startDate,endDate);
		map.put("list",list);
		
		return map;
	}

	@Override
	public Map<String, Object> selectStageByStageDate(int page, Date startDate, Date endDate) {
		HashMap<String, Object> map = new HashMap<>();
		PagingBean pb= new PagingBean(stageDao.selectStageCountByStageDate(startDate,endDate),page);
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectStageByStgeDate(pb.getBeginItemInPage(), pb.getEndItemInPage(), startDate, endDate);
		map.put("list", list);
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
	
}
