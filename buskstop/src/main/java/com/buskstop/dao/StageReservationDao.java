package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.StageReservation;

public interface StageReservationDao {

	/**
	 * 공연장 예약 등록
	 * @param stageReservation
	 * @return
	 */
	int insertStageReservation(StageReservation stageReservation);
	
	/**
	 * 공연장 번호를 받아서 진행중인 예약이 있다면 조회
	 * @param stageNo
	 * @return
	 */
	StageReservation selectStageReservationByStageNoforRentalStateCode(int stageNo);
	
	/**
	 * 공연장 번호를 받아서 진행중인 예약 취소
	 * @param stageNo
	 * @return
	 */
	int cancelStageReservation(int stageNo);
	
	/**
	 * 공연장 번호로 공연장예약 정보 조회
	 * @param stageNo
	 * @return
	 */
	List<StageReservation> selectStageReservationByStageNo(int stageNo);
}
