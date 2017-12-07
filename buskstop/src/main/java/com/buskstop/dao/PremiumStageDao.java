package com.buskstop.dao;

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
	PremiumStage selectSupplierById(String userId);
	
}
