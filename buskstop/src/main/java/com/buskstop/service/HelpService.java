package com.buskstop.service;

import java.util.List;
import java.util.Map;

import com.buskstop.vo.Help;

public interface HelpService {
	
	void insertHelp();
	
	void insertHelp(Help help);

	Help selectHelpByHelpNum(int helpNum);

	void updateHelp(Help help);

	int deleteHelpByHelpNum(int helpNum);
	
	/**
	 * 고객센터 전체 조회 페이징
	 * @param page
	 * @return
	 */
	Map<String, Object> selectAllHelp(int page);
}
