package com.buskstop.dao;

import java.util.List;

import com.buskstop.vo.PremiumStage;

public interface PremiumStageDao {
	/**
	 * 공급자 insert
	 * @param supplier
	 * @return
	 */
	int insertPremiumStage(PremiumStage supplier);
	
	/**
	 * 공급자 정보 update
	 * @param supplier
	 * @return
	 */
	int updateStageSupplier(PremiumStage supplier);
	
	/**
	 * id로 공급자 정보 찾아오기.
	 * @param userId
	 * @return
	 */
	List<PremiumStage> selectSupplierById(String userId);

	
	/**
	 * userId로 프리미엄스테이지의 공연장제목 select.
	 * @param userId
	 * @return
	 */
	List<String> selectStageNameById(String userId);
	
	/**
	 * 사업장번호로 PremiumStage data select
	 * @param establishNum
	 * @return
	 */
	PremiumStage selectStageByEstablishNum(int establishNum);
	
	/**
	 * 사업장 번호로 PremiumStage data delete
	 * @param establishNum
	 * @return
	 */
	int deleteStageByEstablishNum(int establishNum);
}
