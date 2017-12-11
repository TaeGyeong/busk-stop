package com.buskstop.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PremiumStageReservation {

		private int reservationNo; //예약신청 번호
		private String UserId; //예약신청자 ID
		private int establishNo; //사업장번호
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date reservationRegTime;//예약 신청자 신청시간
		private int optionNo;//예약옵션번호
		
		public PremiumStageReservation() {}

		public PremiumStageReservation(int reservationNo, String userId, int establishNo, Date reservationRegTime,
				int optionNo) {
			this.reservationNo = reservationNo;
			UserId = userId;
			this.establishNo = establishNo;
			this.reservationRegTime = reservationRegTime;
			this.optionNo = optionNo;
		}

		public int getReservationNo() {
			return reservationNo;
		}

		public void setReservationNo(int reservationNo) {
			this.reservationNo = reservationNo;
		}

		public String getUserId() {
			return UserId;
		}

		public void setUserId(String userId) {
			UserId = userId;
		}

		public int getEstablishNo() {
			return establishNo;
		}

		public void setEstablishNo(int establishNo) {
			this.establishNo = establishNo;
		}

		public Date getReservationRegTime() {
			return reservationRegTime;
		}

		public void setReservationRegTime(Date reservationRegTime) {
			this.reservationRegTime = reservationRegTime;
		}

		public int getOptionNo() {
			return optionNo;
		}

		public void setOptionNo(int optionNo) {
			this.optionNo = optionNo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((UserId == null) ? 0 : UserId.hashCode());
			result = prime * result + establishNo;
			result = prime * result + optionNo;
			result = prime * result + reservationNo;
			result = prime * result + ((reservationRegTime == null) ? 0 : reservationRegTime.hashCode());
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
			PremiumStageReservation other = (PremiumStageReservation) obj;
			if (UserId == null) {
				if (other.UserId != null)
					return false;
			} else if (!UserId.equals(other.UserId))
				return false;
			if (establishNo != other.establishNo)
				return false;
			if (optionNo != other.optionNo)
				return false;
			if (reservationNo != other.reservationNo)
				return false;
			if (reservationRegTime == null) {
				if (other.reservationRegTime != null)
					return false;
			} else if (!reservationRegTime.equals(other.reservationRegTime))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "PremiumStageReservation [reservationNo=" + reservationNo + ", UserId=" + UserId + ", establishNo="
					+ establishNo + ", reservationRegTime=" + reservationRegTime + ", optionNo=" + optionNo + "]";
		}
}
