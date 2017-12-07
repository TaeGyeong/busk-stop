package com.buskstop.vo;

import java.util.Date;

public class PremiumStageReservationTime {

	private int timeCode;
	private Date stageRentalDate;
	private int establishNo;
	
	public PremiumStageReservationTime() {}
	
	public PremiumStageReservationTime(int timeCode, Date stageRentalDate, int establishNo) {
		this.timeCode = timeCode;
		this.stageRentalDate = stageRentalDate;
		this.establishNo = establishNo;
	}

	@Override
	public String toString() {
		return "PremiumStageReservationTime [timeCode=" + timeCode + ", stageRentalDate=" + stageRentalDate
				+ ", establishNo=" + establishNo + "]";
	}

	public int getTimeCode() {
		return timeCode;
	}

	public void setTimeCode(int timeCode) {
		this.timeCode = timeCode;
	}

	public Date getStageRentalDate() {
		return stageRentalDate;
	}

	public void setStageRentalDate(Date stageRentalDate) {
		this.stageRentalDate = stageRentalDate;
	}

	public int getEstablishNo() {
		return establishNo;
	}

	public void setEstablishNo(int establishNo) {
		this.establishNo = establishNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + establishNo;
		result = prime * result + ((stageRentalDate == null) ? 0 : stageRentalDate.hashCode());
		result = prime * result + timeCode;
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
		PremiumStageReservationTime other = (PremiumStageReservationTime) obj;
		if (establishNo != other.establishNo)
			return false;
		if (stageRentalDate == null) {
			if (other.stageRentalDate != null)
				return false;
		} else if (!stageRentalDate.equals(other.stageRentalDate))
			return false;
		if (timeCode != other.timeCode)
			return false;
		return true;
	}
	
	
	
	
}
