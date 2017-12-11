package com.buskstop.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.StageReservationDao;
import com.buskstop.vo.StageReservation;

@Repository
public class StageReservationDaoImpl implements StageReservationDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.stageReservationMapper."+id;
	}

	@Override
	public int insertStageReservation(StageReservation stageReservation) {
		return session.insert(makeSqlId("insertStageReservation"), stageReservation);
	}

	@Override
	public StageReservation selectStageReservationByStageNoforRentalStateCode(int stageNo) {
		return session.selectOne(makeSqlId("selectStageReservationByStageNoforRentalStateCode"), stageNo);
	}

	@Override
	public int cancelStageReservation(int stageNo) {
		return session.update(makeSqlId("cancelStageReservation"), stageNo);
	}
		
}
