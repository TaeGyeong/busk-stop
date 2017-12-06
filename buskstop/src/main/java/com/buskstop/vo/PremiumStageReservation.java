package com.buskstop.vo;

public class PremiumStageReservation {

		private int establishNo;
		private String UserId;
		private int stageState;
		
		public PremiumStageReservation() {}
		
		public PremiumStageReservation(int establishNo, String userId, int stageState) {
			this.establishNo = establishNo;
			UserId = userId;
			this.stageState = stageState;
		}
		@Override
		public String toString() {
			return "PremiumStageReservation [establishNo=" + establishNo + ", UserId=" + UserId + ", stageState="
					+ stageState + "]";
		}
		public int getEstablishNo() {
			return establishNo;
		}
		public void setEstablishNo(int establishNo) {
			this.establishNo = establishNo;
		}
		public String getUserId() {
			return UserId;
		}
		public void setUserId(String userId) {
			UserId = userId;
		}
		public int getStageState() {
			return stageState;
		}
		public void setStageState(int stageState) {
			this.stageState = stageState;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((UserId == null) ? 0 : UserId.hashCode());
			result = prime * result + establishNo;
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
			PremiumStageReservation other = (PremiumStageReservation) obj;
			if (UserId == null) {
				if (other.UserId != null)
					return false;
			} else if (!UserId.equals(other.UserId))
				return false;
			if (establishNo != other.establishNo)
				return false;
			if (stageState != other.stageState)
				return false;
			return true;
		}
		
		
}
