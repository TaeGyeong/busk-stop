package com.buskstop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buskstop.dao.AuthorityDao;
import com.buskstop.dao.StageSupplierDao;
import com.buskstop.dao.UserDao;
import com.buskstop.service.StageService;
import com.buskstop.vo.Authority;
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
	
	@Override
	public void registerSupplier(StageSupplier supplier) {
		supplierDao.insertStageSupplier(supplier);
		authorDao.updateAuthority(new Authority(supplier.getUserId(), "ROLE_PRODUCER"));
	}
	
}
