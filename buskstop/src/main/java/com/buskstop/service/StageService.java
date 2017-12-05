package com.buskstop.service;

import com.buskstop.vo.Stage;
import com.buskstop.vo.StageSupplier;

public interface StageService {
	/**
	 * 공급자 등록
	 * @param supplier
	 */
	void registerSupplier(StageSupplier supplier);
	
	/**
	 * 공급자 정보 수정
	 * @param supplier
	 * @return
	 */
	int updateSupplier(StageSupplier supplier);
	
	/**
	 * Id로 공급자 정보 가져오기.
	 * @param userId
	 * @return
	 */
	StageSupplier selectSupplierById(String userId);
	
	/**
	 * 공연장 등록
	 * @param stage
	 */
	void insertStage(Stage stage);
}
