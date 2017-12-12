package com.buskstop.service;

import java.util.List;

import com.buskstop.vo.Help;

public interface HelpService {
	
	void insertHelp();
	
	void insertHelp(Help help);

	Help selectHelpByHelpNum(int helpNum);
}
