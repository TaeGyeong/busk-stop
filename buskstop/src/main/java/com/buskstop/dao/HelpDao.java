package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.Help;

public interface HelpDao {
	
	void insertHelp();
	
	int insertHelp(Help help);
	
	Help selectHelpByHelpNum(int helpNum);

	int deleteHelpByHelpNum(int helpNum);

	int updateHelp(Help help);
	
	/**
	 * 모든 고객센터 조회 페이징
	 * @param beginItemNum
	 * @param endItemNum
	 * @return
	 */
	List<Help> selectAllHelp(int beginItemNum, int endItemNum);
	
	/**
	 * 모든 고객센터 카운트
	 * @return
	 */
	int selectAllHelpCount();
}
