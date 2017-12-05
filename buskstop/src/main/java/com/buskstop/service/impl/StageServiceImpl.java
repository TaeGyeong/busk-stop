package com.buskstop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buskstop.common.util.PagingBean;
import com.buskstop.dao.AuthorityDao;
import com.buskstop.dao.StageDao;
import com.buskstop.dao.StageImageDao;
import com.buskstop.dao.StageSupplierDao;
import com.buskstop.dao.UserDao;
import com.buskstop.service.StageService;
import com.buskstop.vo.Authority;
import com.buskstop.vo.Stage;
import com.buskstop.vo.StageImage;
import com.buskstop.vo.StageSupplier;

@Service
public class StageServiceImpl implements StageService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthorityDao authorDao;
	
	@Autowired
	private StageSupplierDao supplierDao;
	
	@Autowired
	private StageDao stageDao;
	
	@Autowired
	private StageImageDao stageImageDao;
	
	@Override
	@Transactional
	public void registerSupplier(StageSupplier supplier) {
		supplierDao.insertStageSupplier(supplier);
		authorDao.insertAuthority(new Authority(supplier.getUserId(), "ROLE_PRODUCER"));
	}
	
	@Override
	public int updateSupplier(StageSupplier supplier) {
		return supplierDao.updateStageSupplier(supplier);
	}

	@Override
	public StageSupplier selectSupplierById(String userId) {
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
		System.out.println("서비스"+page);
		HashMap<String, Object> map = new HashMap<>();
		
		PagingBean pb = new PagingBean(stageDao.selectStageCount(),page);
		
		map.put("pageBean", pb);
		List<Stage> list = stageDao.selectAllStage(pb.getBeginItemInPage(),pb.getEndItemInPage());
		
		map.put("list",list);
		System.out.println("서비스ㅎㅎㅎ"+list);
		
		return map;
		
	}
	
	
}
