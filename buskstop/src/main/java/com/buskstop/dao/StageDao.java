package com.buskstop.dao;

import java.util.Date;
import java.util.List;

import com.buskstop.vo.Stage;

public interface StageDao {
	
	/**
	 * 공연장 등록
	 * @param stage
	 * @return
	 */
	int insertStage(Stage stage);

	Stage selectStageByStageNo(int stageNo);

	List<Stage> selectStage();

	List<Stage> selectAllStage(int beginNum, int endNum);

	int selectStageCount();

	int selectStageCountByLocation(String stageLocation);

	List<Stage> selectStageByStageLocation(int beginItemInPage, int endItemInPage, String stageLocation);

	List<Stage> selectStageByInstrument(int beginItemInPage, int endItemInPage, String instrument);

	int selectStageCountByStageDate(Date startDate, Date endDate);

	List<Stage> selectStageByStgeDate(int beginItemInPage, int endItemInPage, Date startDate, Date endDate);

	int selectStageCountByInstrument(String instrument);

}
