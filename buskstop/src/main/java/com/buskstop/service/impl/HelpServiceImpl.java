package com.buskstop.service.impl;

import org.springframework.stereotype.Service;

import com.buskstop.service.HelpService;
import com.buskstop.vo.Help;

@Service
public class HelpServiceImpl implements HelpService{
		
	@Override
	public void insertHelp() {
		System.out.println("Log : HelpServiceImpl.java insertHelp() 호출");
	}
	
	@Override
	public void insertHelp(Help help) {
	}

		
}
