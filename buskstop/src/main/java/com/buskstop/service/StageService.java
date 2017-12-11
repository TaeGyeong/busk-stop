package com.buskstop.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.buskstop.vo.PremiumStage;
import com.buskstop.vo.Stage;
import com.buskstop.vo.StageImage;
import com.buskstop.vo.StageReservation;

public interface StageService {
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
	
	/**
	 * 공연장예약 등록
	 * @param stageReservation
	 */
	void insertStageReservation(StageReservation stageReservation);

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


	/**
	 * 프리미엄공연장 사진등록.
	 * @param establishNum
	 * @param imageList
	 */
	void registStageImage(int establishNum, List<String> imageList);

	Map<String, Object> selectStageByStageLocation(int page, String stageLocation, Date startDate, Date endDate);

	/**
	 * 공연장 공연장 번호로 삭제
	 * @param stageNo
	 */
	void deleteStageByStageNo(int stageNo);
	
	/**
	 * 공연장사진 공연장사진 번호로 삭제
	 * @param stageImageNo
	 */
	void deleteStageImageByStageImageNo(int stageImageNo);

	Map<String, Object> selectStageByStageSellerId(int page, String idSearch, Date startDate, Date endDate);

	Map<String, Object> selectStageOnlyId(int page, String idSearch);

	Map<String, Object> selectStageOnlyLocation(int page, String locationSearch);
	
	Map<String, Object> selectStageOnlyName(int page, String nameSearch);

	Map<String, Object> selectStageByLocationAndName(int page, String locationSearch, Date startDate, Date endDate,
			String nameSearch);

	Map<String, Object> selectStageByName(int page, String nameSearch, Date startDate, Date endDate);
	
	/**
	 * 공연장 번호를 받아서 예약진행중이라면 조회
	 * @param stageNo
	 * @return
	 */
	StageReservation selectStageReservationByStageNoforRentalStateCode(int stageNo);
	
	/**
	 * 공연장 번호를 받아서 예약 상태 변경
	 * @param stageNo
	 * @param stageReservation
	 * @return
	 */
	Map<String, Object> updateStageForStageReservation(int stageNo, int stageReservation);
	
	Map<String, Object> selectStageByLocationAndNameNoDate(int page, String locationSearch, String nameSearch);

	Map<String, Object> selectStageByLocationAndIDNoDate(int page, String locationSearch, String idSearch);

	Map<String, Object> selectStageByNameAndIdNoDate(int page, String nameSearch, String idSearch);

}
