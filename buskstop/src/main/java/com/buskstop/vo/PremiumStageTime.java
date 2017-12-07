package com.buskstop.vo;

import java.util.Date;

public class PremiumStageTime {

	private int timeCode; //0~24시를 1~24로 정함
	private Date stageRentalDate; //시간 아닌 날짜만
	private int reservationNo; //사업장 번호
	
	public PremiumStageTime() {}

	public PremiumStageTime(int timeCode, Date stageRentalDate, int reservationNo) {
		super();
		this.timeCode = timeCode;
		this.stageRentalDate = stageRentalDate;
		this.reservationNo = reservationNo;
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

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	@Override
	public String toString() {
		return "PremiumStageReservationTime [timeCode=" + timeCode + ", stageRentalDate=" + stageRentalDate
				+ ", reservationNo=" + reservationNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reservationNo;
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
		PremiumStageTime other = (PremiumStageTime) obj;
		if (reservationNo != other.reservationNo)
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
