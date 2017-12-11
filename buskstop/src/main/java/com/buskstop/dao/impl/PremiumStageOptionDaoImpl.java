package com.buskstop.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buskstop.dao.PremiumStageOptionDao;
import com.buskstop.vo.PremiumStageOption;

@Repository
public class PremiumStageOptionDaoImpl implements PremiumStageOptionDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id) {
		return "com.buskstop.config.mybatis.mapper.premiumStageOptionMapper."+id;
	}

	@Override
	public int insertPremiumStageOption(PremiumStageOption premiumStageOption) {
		return session.insert(makeSqlId("insertPremiumStageOption"), premiumStageOption);
	}

	@Override
	public int deletePremiumStageOption(int reservationNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PremiumStageOption> selectPremiumStageOptionByEstablishNo(int establishNo) {
		return session.selectOne(makeSqlId("selectPremiumStageOptionByEstablishNo"), establishNo);
	}

}
