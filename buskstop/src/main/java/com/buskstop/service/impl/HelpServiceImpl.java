package com.buskstop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buskstop.dao.HelpDao;
import com.buskstop.service.HelpService;
import com.buskstop.vo.Help;

@Service
public class HelpServiceImpl implements HelpService{
	
	@Autowired
	private HelpDao dao;
		
	@Override
	public void insertHelp() {
		System.out.println("Log: HelpServiceImpl.java -> helpMapper.xml 호출");
		dao.insertHelp();
	}
	
	@Override
	public void insertHelp(Help help) {
	}

		
}
