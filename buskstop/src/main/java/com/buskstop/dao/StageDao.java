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

	int selectStageCountByStageDate(Date startDate, Date endDate);

	List<Stage> selectStageByStageDate(int beginItemInPage, int endItemInPage, Date startDate, Date endDate);
	int selectStageCountByLocation(String stageLocation, Date startDate, Date endDate);
	
	List<Stage> selectStageByStageLocation(int beginItemInPage, int endItemInPage, String stageLocation,
			Date startDate, Date endDate);

	int selectStageCountByInstrument(String instrument, Date startDate, Date endDate);

	/**
	 * 공연장 수정
	 * @param stage
	 * @return
	 */
	int updateStage(Stage stage);
	
	List<Stage> selectStageByInstrument(int beginItemInPage, int endItemInPage, String instrument, Date sDate,
			Date eDate);
	
	/**
	 * 공연장 번호를 받아서 삭제
	 * @param stageNo
	 * @return
	 */
	int deleteStageByStageNo(int stageNo);
}
