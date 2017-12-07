package com.buskstop.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.PremiumStageTimeDao;
import com.buskstop.vo.PremiumStageTime;

@Repository
public class PremiumStageTimeDaoImpl implements PremiumStageTimeDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.PremiumStageTimeMapper."+id;
	}

	@Override
	public int insertPremiumStageTime(PremiumStageTime premiumStageTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePremiumStageTime(int reservationNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePremiumStageTime(PremiumStageTime premiumStageTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PremiumStageTime> selectPremiumStageTimeByReservationNo(int reservationNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
