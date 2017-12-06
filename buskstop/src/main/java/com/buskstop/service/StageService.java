package com.buskstop.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.buskstop.vo.Stage;
import com.buskstop.vo.StageImage;
import com.buskstop.vo.StageSupplier;

public interface StageService {
	/**
	 * 공급자 등록
	 * @param supplier
	 */
	void registerSupplier(StageSupplier supplier);
	
	/**
	 * 공급자 정보 수정
	 * @param supplier
	 * @return
	 */
	int updateSupplier(StageSupplier supplier);
	
	/**
	 * Id로 공급자 정보 가져오기.
	 * @param userId
	 * @return
	 */
	StageSupplier selectSupplierById(String userId);
	
	/**
	 * 공연장 등록
	 * @param stage
	 */
	void insertStage(Stage stage);
	
	/**
	 * 공연장 사진 등록
	 * @param stageImage
	 */
	void insertStageImage(StageImage stageImage);

	Stage selectStageByStageNo(int stageNo);

	List<Stage> selectStage();

	Map<String, Object> selectAllStage(int page);

	Map<String, Object> selectStageByStageDate(int page, Date startDate, Date endDate);

	Map<String, Object> selectStageByStageLocation(int page, String stageLocation, String startDate, String endDate);

	Map<String, Object> selectStageByInstrument(int page, String instrument, String startDate, String endDate);
}
