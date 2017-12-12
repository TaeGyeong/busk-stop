package com.buskstop.dao;

import com.buskstop.vo.Help;

public interface HelpDao {
	
	void insertHelp();
	
	int insertHelp(Help help);
	
	Help selectHelpByHelpNum(int helpNum);

	int deleteHelpByHelpNum(int helpNum);

	int updateHelp(Help help);
	
	
}
