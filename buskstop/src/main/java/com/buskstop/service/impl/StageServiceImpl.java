package com.buskstop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buskstop.dao.AuthorityDao;
import com.buskstop.dao.StageDao;
import com.buskstop.dao.StageSupplierDao;
import com.buskstop.dao.UserDao;
import com.buskstop.service.StageService;
import com.buskstop.vo.Authority;
import com.buskstop.vo.Stage;
import com.buskstop.vo.StageSupplier;
import com.buskstop.vo.User;

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
	
}
