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


	int selectStageCountByStageDate(Date startDate, Date endDate);

	List<Stage> selectStageByStgeDate(int beginItemInPage, int endItemInPage, Date startDate, Date endDate);
	int selectStageCountByLocation(String stageLocation, String startDate, String endDate);
	
	List<Stage> selectStageByStageLocation(int beginItemInPage, int endItemInPage, String stageLocation,
			String startDate, String endDate);

	int selectStageCountByInstrument(String instrument, String startDate, String endDate);

	List<Stage> selectStageByInstrument(int beginItemInPage, int endItemInPage, String instrument, String startDate,
			String endDate);

	/**
	 * 공연장 수정
	 * @param stage
	 * @return
	 */
	int updateStage(Stage stage);

}
