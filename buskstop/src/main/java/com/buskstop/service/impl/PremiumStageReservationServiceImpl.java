package com.buskstop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.PremiumStageReservationDao;
import com.buskstop.dao.PremiumStageOptionDao;
import com.buskstop.service.PremiumStageReservationService;
import com.buskstop.vo.PremiumStageReservation;
import com.buskstop.vo.PremiumStageOption;

@Repository
public class PremiumStageReservationServiceImpl implements PremiumStageReservationService{
	
	@Autowired
	private PremiumStageReservationDao reservationDao;
	
	@Autowired
	private PremiumStageOptionDao timeDao;

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
	public List<PremiumStageReservation> selectPremiumStageReservationByEstablishNo(int establishNo) {
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
	public int createPremiumStageOption(PremiumStageOption option) {
		// TODO Auto-generated method stub
				return 0;
	}

	@Override
	public int removePremiumStageOption(int reservationNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PremiumStageOption> selectPremiumStageOptionByEstablishNo(int establishNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
