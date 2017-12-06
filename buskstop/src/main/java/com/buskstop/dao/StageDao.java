package com.buskstop.dao;

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

	/**
	 * 공연장 수정
	 * @param stage
	 * @return
	 */
	int updateStage(Stage stage);
}
