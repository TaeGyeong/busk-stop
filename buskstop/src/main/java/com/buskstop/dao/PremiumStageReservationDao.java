package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.PremiumStageReservation;

public interface PremiumStageReservationDao {

	/**
	 * 프리미엄 공연장 시간옵션 등록
	 * @param reservation
	 * @return
	 */
	int insertPremiumStageReservation(PremiumStageReservation reservation);
	
	/**
	 * 프리미엄 공연장 시간옵션 삭제
	 * @param reservationNo
	 * @return
	 */
	int deletePremiumStageReservation(int reservationNo);
	
	/**
	 * 프리미엄 공연장 시간옵션 수정
	 * @param reservation
	 * @return
	 */
	int updatePremiumStageReservation(PremiumStageReservation reservation);
	
	/**
	 * 프리미엄 공연장 시간옵션 예약상태 수정
	 * 0 : 대관신청가능, 1 : 대관신청중(수락대기, 대관신청불가능), 2 : 대관신청완료(수락, 대관신청불가능)
	 * @param stageState
	 * @return
	 */
	int updatePremiumStageReservationState(int stageState);
	
	/**
	 * 사업장번호로 사업장이 가지는 시간옵션 전체조회
	 * @param EstablishNo
	 * @return
	 */
	List<PremiumStageReservation> selectPremiumStageReservationByEstablishNo(int EstablishNo);
	
	/**
	 * 공연장 시간옵션 예약상태와 공연장 사업자번호로 시간옵션 조회
	 *  - ex) 해당 사업장에 신청중(수락대기) 상태인 시간옵션을 보여줌
	 * @param stageState
	 * @return
	 */
	List<PremiumStageReservation> selectPremiumStageReservationByStageState(int stageState, int establishNo);
	
	/**
	 * 대관신청자 아이디로 예약옵션 조회
	 *  - 사용자가 자신이 예약신청한 옵션을 조회할 때 사용
	 * @param userId
	 * @return
	 */
	List<PremiumStageReservation> selectPremiumStageReservationByUserId(String userId);
}
