package com.buskstop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.PremiumStageReservationDao;
import com.buskstop.dao.PremiumStageTimeDao;
import com.buskstop.service.PremiumStageReservationService;
import com.buskstop.vo.PremiumStageReservation;
import com.buskstop.vo.PremiumStageTime;

@Repository
public class PremiumStageReservationServiceImpl implements PremiumStageReservationService{
	
	@Autowired
	private PremiumStageReservationDao reservationDao;
	
	@Autowired
	private PremiumStageTimeDao timeDao;

	@Override
	public int createPremiumStageReservation(PremiumStageReservation reservation) {
		return reservationDao.insertPremiumStageReservation(reservation);
	}

	@Override
	public int removePremiumStageReservation(int reservationNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePremiumStageReservation(PremiumStageReservation reservation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePremiumStageReservationState(int reservationNo, int stageState) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updatePremiumStageReservationStateToOne(int reservationNo, Date reservationRegTime) {
		// TODO Auto-generated method stub
				return 0;
	}

	@Override
	public List<PremiumStageReservation> selectPremiumStageReservationByEstablishNo(int establishNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<PremiumStageReservation> selectPremiumStageReservationByStageState(PremiumStageReservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PremiumStageReservation> selectPremiumStageReservationByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public int createPremiumStageTime(List<PremiumStageTime> list) {
		int result = 0;
		for(PremiumStageTime time : list) {
			timeDao.insertPremiumStageTime(time);
			result ++;
		}
		return result;
	}

	@Override
	public int removePremiumStageTime(int reservationNo) {
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
