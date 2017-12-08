package com.buskstop.service;

import java.util.Date;
import java.util.List;

import com.buskstop.vo.PremiumStageReservation;
import com.buskstop.vo.PremiumStageOption;

public interface PremiumStageReservationService {

	/**
	 * 프리미엄 공연장 대관 신청
	 * @param reservation
	 * @return
	 */
	int createPremiumStageReservation(PremiumStageReservation reservation);
	
	/**
	 * 프리미엄 공연장 신청 취소
	 * @param reservationNo
	 * @return
	 */
	int removePremiumStageReservation(int reservationNo);
	
	/**
	 * 사업장번호로 사업장이 받은 대관신청 전체조회
	 * @param EstablishNo
	 * @return
	 */
	List<PremiumStageReservation> selectPremiumStageReservationByEstablishNo(int EstablishNo);
	
	/**
	 * 대관신청자 아이디로 사용자가 한 대관신청 전체조회
	 * @param userId
	 * @return
	 */
	List<PremiumStageReservation> selectPremiumStageReservationByUserId(String userId);
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 예약옵션 등록
	 * @param premiumStageOption
	 * @return
	 */
	int createPremiumStageOption(PremiumStageOption premiumStageOption);
	
	/**
	 * 예약옵션 번호로 해당하는 옵션삭제
	 * @param StageNo
	 * @return
	 */
	int removePremiumStageOption(int reservationNo);
	
	/**
	 * 사업장번호로 옵션조회
	 * @param establishNo
	 * @return
	 */
	List<PremiumStageOption> selectPremiumStageOptionByEstablishNo(int establishNo);
}
