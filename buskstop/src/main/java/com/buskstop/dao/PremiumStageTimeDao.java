package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.PremiumStageTime;

public interface PremiumStageTimeDao {

	/**
	 * 예약 시간을 시간테이블에 등록.
	 * 옵션에 해당하는 시간코드 하나당 한번의 등록이 이루어진다.
	 * 즉 옵션이 시간코드 1,2,3을 가지면 같은 옵션에 등록만 3번
	 * @param premiumStageTime
	 * @return
	 */
	int insertPremiumStageTime(PremiumStageTime premiumStageTime);
	
	/**
	 * 예약옵션 번호로 옵션에 해당하는 시간들을 삭제
	 * @param StageNo
	 * @return
	 */
	int deletePremiumStageTime(int reservationNo);
	
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
