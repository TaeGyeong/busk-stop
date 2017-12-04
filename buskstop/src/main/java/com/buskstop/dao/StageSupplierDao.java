package com.buskstop.dao;

import com.buskstop.vo.StageSupplier;

public interface StageSupplierDao {
	/**
	 * 공급자 insert
	 * @param supplier
	 * @return
	 */
	int insertStageSupplier(StageSupplier supplier);
	
	/**
	 * 공급자 정보 update
	 * @param supplier
	 * @return
	 */
	int updateStageSupplier(StageSupplier supplier);
	
	/**
	 * id로 공급자 정보 찾아오기.
	 * @param userId
	 * @return
	 */
	StageSupplier selectSupplierById(String userId);
}
