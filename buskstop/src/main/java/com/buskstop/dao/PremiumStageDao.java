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
	
	/*********************** 목록조회 & 검색 시 페이징 위한 Dao ***********************/
	/**
	 * 모든 프리미엄스테이지의 개수.
	 * @return
	 */
	int selectAllPremiumStageCount();
	
	/**
	 * 프리미엄 스테이지를 시작넘버부터 끝넘버까지 불러오는 dao
	 * @return
	 */
	List<PremiumStage> selectAllPremiumStage(int start, int end);
}
