package com.buskstop.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.buskstop.vo.PremiumStage;
import com.buskstop.vo.Stage;
import com.buskstop.vo.StageImage;

public interface PremiumStageService {
	/**
	 * 공급자 등록
	 * @param supplier
	 */
	void registerSupplier(PremiumStage supplier);
	
	/**
	 * 공급자 정보 수정
	 * @param supplier
	 * @return
	 */
	int updateSupplier(PremiumStage supplier);
	
	/**
	 * Id로 공급자 정보 가져오기.
	 * @param userId
	 * @return
	 */
	PremiumStage selectSupplierById(String userId);
	
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
	
	/**
	 * 공연장 수정
	 * @param stage
	 */
	void updateStage(Stage stage);
	
	/**
	 * 공연장이미지 공연장 번호로 조회
	 * @param StageNo
	 * @return
	 */
	List<StageImage> selectStageImageByStageNo(int stageNo);
	
	/**
	 * 공연장이미지 공연장 번호로 삭제
	 * @param stageNo
	 */
	void deleteStageImageByStageNo(int stageNo);

	Map<String, Object> selectStageByStageDate(int page, Date startDate, Date endDate);


	Map<String, Object> selectStageByInstrument(int page, String instrument, Date startDate, Date endDate);
	
	/**
	 * 프리미엄공연장 사진등록.
	 * @param establishNum
	 * @param imageList
	 */
	void registStageImage(int establishNum, List<String> imageList);

	Map<String, Object> selectStageByStageLocation(int page, String stageLocation, Date startDate, Date endDate);
}
