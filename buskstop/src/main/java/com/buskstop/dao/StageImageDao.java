package com.buskstop.dao;

import com.buskstop.vo.StageImage;

public interface StageImageDao {

	/**
	 * 공연장 사진 등록
	 * @param stageImage
	 * @return
	 */
	int insertStageImage(StageImage stageImage);
}
