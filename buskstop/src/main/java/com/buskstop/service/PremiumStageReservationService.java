package com.buskstop.service;

import java.util.Date;
import java.util.List;

import com.buskstop.vo.PremiumStageReservation;
import com.buskstop.vo.PremiumStageTime;

public interface PremiumStageReservationService {

	/**
	 * 프리미엄 공연장 시간옵션 등록
	 * @param reservation
	 * @return
	 */
	int createPremiumStageReservation(PremiumStageReservation reservation);
	
	/**
	 * 프리미엄 공연장 시간옵션 삭제
	 * @param reservationNo
	 * @return
	 */
	int removePremiumStageReservation(int reservationNo);
	
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
	int updatePremiumStageReservationState(int reservationNo, int stageState);
	
	/**
	 * 프리미엄 공연장 시간옵션 예약상태 수락대기(1)로 변경
	 * 신청시간도 함께 등록
	 * @param stageState
	 * @return
	 */
	int updatePremiumStageReservationStateToOne(int reservationNo, Date reservationRegTime);
	
	/**
	 * 사업장번호로 사업장이 가지는 시간옵션 전체조회
	 * @param EstablishNo
	 * @return
	 */
	List<PremiumStageReservation> selectPremiumStageReservationByEstablishNo(int establishNo);
	
	/**
	 * 공연장 시간옵션 예약상태와 공연장 사업자번호로 시간옵션 조회
	 *  - ex) 해당 사업장에 신청중(수락대기) 상태인 시간옵션을 보여줌
	 * @param stageState
	 * @return
	 */
	List<PremiumStageReservation> selectPremiumStageReservationByStageState(PremiumStageReservation reservation);
	
	/**
	 * 대관신청자 아이디로 예약옵션 조회
	 *  - 사용자가 자신이 예약신청한 옵션을 조회할 때 사용
	 * @param userId
	 * @return
	 */
	List<PremiumStageReservation> selectPremiumStageReservationByUserId(String userId);
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 예약 시간을 시간테이블에 등록.
	 * 옵션에 해당하는 시간코드 하나당 한번의 등록이 이루어진다.
	 * 즉 옵션이 시간코드 1,2,3을 가지면 같은 옵션에 등록만 3번
	 * @param premiumStageTime
	 * @return
	 */
	int createPremiumStageTime(List<PremiumStageTime> list);
	
	/**
	 * 예약옵션 번호로 옵션에 해당하는 시간들을 삭제
	 * @param StageNo
	 * @return
	 */
	int removePremiumStageTime(int reservationNo);
	
	/**
	 * 해당옵션에 해당하는 시간하나를 수정
	 * 옵션에 시간코드가 3개면 3번 수정이 일어나야한다.
	 * @param premiumStageTime
	 * @return
	 */
	int updatePremiumStageTime(PremiumStageTime premiumStageTime);
	
	/**
	 * 옵션번호로 예약옵션에 해당하는 모든 시간코드 조회
	 * @param reservationNo
	 * @return
	 */
	List<PremiumStageTime> selectPremiumStageTimeByReservationNo(int reservationNo);
}
