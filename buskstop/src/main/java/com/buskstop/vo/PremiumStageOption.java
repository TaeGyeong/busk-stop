package com.buskstop.vo;

import java.util.Date;

public class PremiumStageOption {

	private int optionNo; //예약옵션
	private Date stageRentalDate; //시간 아닌 날짜만
	private int stageState;//옵션의 예약 상태 - 0:신청대기, 1:수락대기, 2:대관완료
	private int establishNo; //사업장 번호
	
	public PremiumStageOption() {}

	public PremiumStageOption(int optionNo, Date stageRentalDate, int stageState, int establishNo) {
		this.optionNo = optionNo;
		this.stageRentalDate = stageRentalDate;
		this.stageState = stageState;
		this.establishNo = establishNo;
	}

	public int getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}

	public Date getStageRentalDate() {
		return stageRentalDate;
	}

	public void setStageRentalDate(Date stageRentalDate) {
		this.stageRentalDate = stageRentalDate;
	}

	public int getStageState() {
		return stageState;
	}

	public void setStageState(int stageState) {
		this.stageState = stageState;
	}

	public int getEstablishNo() {
		return establishNo;
	}

	public void setEstablishNo(int establishNo) {
		this.establishNo = establishNo;
	}

	@Override
	public String toString() {
		return "PremiumStageOption [optionNo=" + optionNo + ", stageRentalDate=" + stageRentalDate + ", stageState="
				+ stageState + ", establishNo=" + establishNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + establishNo;
		result = prime * result + optionNo;
		result = prime * result + ((stageRentalDate == null) ? 0 : stageRentalDate.hashCode());
		result = prime * result + stageState;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremiumStageOption other = (PremiumStageOption) obj;
		if (establishNo != other.establishNo)
			return false;
		if (optionNo != other.optionNo)
			return false;
		if (stageRentalDate == null) {
			if (other.stageRentalDate != null)
				return false;
		} else if (!stageRentalDate.equals(other.stageRentalDate))
			return false;
		if (stageState != other.stageState)
			return false;
		return true;
	}
}
