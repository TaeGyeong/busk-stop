package com.buskstop.vo;

import java.io.Serializable;

public class Stage implements Serializable{
	private int stageNum;
	private String stageName;
	private String stageLocation;
	private int stageCost;
	private int stageArea;
	private String stagePic;
	private String instrument;
	private String stageContent;
	private int stageParking;
	private int stageDrinking;
	private int stageFoodSell;
	private int stageFoodRestriction;
	private int stageReservation;
	private User seller;
	
	public Stage() {
	}

	public Stage(int stageNum, String stageName, String stageLocation, int stageCost, int stageArea, String stagePic,
			String instrument, String stageContent, int stageParking, int stageDrinking, int stageFoodSell,
			int stageFoodRestriction, int stageReservation, User seller) {
		this.stageNum = stageNum;
		this.stageName = stageName;
		this.stageLocation = stageLocation;
		this.stageCost = stageCost;
		this.stageArea = stageArea;
		this.stagePic = stagePic;
		this.instrument = instrument;
		this.stageContent = stageContent;
		this.stageParking = stageParking;
		this.stageDrinking = stageDrinking;
		this.stageFoodSell = stageFoodSell;
		this.stageFoodRestriction = stageFoodRestriction;
		this.stageReservation = stageReservation;
		this.seller = seller;
	}

	public int getStageNum() {
		return stageNum;
	}

	public void setStageNum(int stageNum) {
		this.stageNum = stageNum;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getStageLocation() {
		return stageLocation;
	}

	public void setStageLocation(String stageLocation) {
		this.stageLocation = stageLocation;
	}

	public int getStageCost() {
		return stageCost;
	}

	public void setStageCost(int stageCost) {
		this.stageCost = stageCost;
	}

	public int getStageArea() {
		return stageArea;
	}

	public void setStageArea(int stageArea) {
		this.stageArea = stageArea;
	}

	public String getStagePic() {
		return stagePic;
	}

	public void setStagePic(String stagePic) {
		this.stagePic = stagePic;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public String getStageContent() {
		return stageContent;
	}

	public void setStageContent(String stageContent) {
		this.stageContent = stageContent;
	}

	public int getStageParking() {
		return stageParking;
	}

	public void setStageParking(int stageParking) {
		this.stageParking = stageParking;
	}

	public int getStageDrinking() {
		return stageDrinking;
	}

	public void setStageDrinking(int stageDrinking) {
		this.stageDrinking = stageDrinking;
	}

	public int getStageFoodSell() {
		return stageFoodSell;
	}

	public void setStageFoodSell(int stageFoodSell) {
		this.stageFoodSell = stageFoodSell;
	}

	public int getStageFoodRestriction() {
		return stageFoodRestriction;
	}

	public void setStageFoodRestriction(int stageFoodRestriction) {
		this.stageFoodRestriction = stageFoodRestriction;
	}

	public int getStageReservation() {
		return stageReservation;
	}

	public void setStageReservation(int stageReservation) {
		this.stageReservation = stageReservation;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instrument == null) ? 0 : instrument.hashCode());
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		result = prime * result + stageArea;
		result = prime * result + ((stageContent == null) ? 0 : stageContent.hashCode());
		result = prime * result + stageCost;
		result = prime * result + stageDrinking;
		result = prime * result + stageFoodRestriction;
		result = prime * result + stageFoodSell;
		result = prime * result + ((stageLocation == null) ? 0 : stageLocation.hashCode());
		result = prime * result + ((stageName == null) ? 0 : stageName.hashCode());
		result = prime * result + stageNum;
		result = prime * result + stageParking;
		result = prime * result + ((stagePic == null) ? 0 : stagePic.hashCode());
		result = prime * result + stageReservation;
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
		Stage other = (Stage) obj;
		if (instrument == null) {
			if (other.instrument != null)
				return false;
		} else if (!instrument.equals(other.instrument))
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		if (stageArea != other.stageArea)
			return false;
		if (stageContent == null) {
			if (other.stageContent != null)
				return false;
		} else if (!stageContent.equals(other.stageContent))
			return false;
		if (stageCost != other.stageCost)
			return false;
		if (stageDrinking != other.stageDrinking)
			return false;
		if (stageFoodRestriction != other.stageFoodRestriction)
			return false;
		if (stageFoodSell != other.stageFoodSell)
			return false;
		if (stageLocation == null) {
			if (other.stageLocation != null)
				return false;
		} else if (!stageLocation.equals(other.stageLocation))
			return false;
		if (stageName == null) {
			if (other.stageName != null)
				return false;
		} else if (!stageName.equals(other.stageName))
			return false;
		if (stageNum != other.stageNum)
			return false;
		if (stageParking != other.stageParking)
			return false;
		if (stagePic == null) {
			if (other.stagePic != null)
				return false;
		} else if (!stagePic.equals(other.stagePic))
			return false;
		if (stageReservation != other.stageReservation)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stage [stageNum=" + stageNum + ", stageName=" + stageName + ", stageLocation=" + stageLocation
				+ ", stageCost=" + stageCost + ", stageArea=" + stageArea + ", stagePic=" + stagePic + ", instrument="
				+ instrument + ", stageContent=" + stageContent + ", stageParking=" + stageParking + ", stageDrinking="
				+ stageDrinking + ", stageFoodSell=" + stageFoodSell + ", stageFoodRestriction=" + stageFoodRestriction
				+ ", stageReservation=" + stageReservation + ", seller=" + seller + "]";
	}
	
}
