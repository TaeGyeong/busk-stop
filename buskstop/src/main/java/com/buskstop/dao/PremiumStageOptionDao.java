package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.PremiumStageOption;

public interface PremiumStageOptionDao {

	/**
	 * 예약옵션 등록
	 * @param premiumStageOption
	 * @return
	 */
	int insertPremiumStageOption(PremiumStageOption premiumStageOption);
	
	/**
	 * 예약옵션 번호로 해당하는 옵션삭제
	 * @param StageNo
	 * @return
	 */
	int deletePremiumStageOption(int reservationNo);
	
	/**
	 * 사업장번호로 옵션조회
	 * @param establishNo
	 * @return
	 */
	List<PremiumStageOption> selectPremiumStageOptionByEstablishNo(int establishNo);
}
