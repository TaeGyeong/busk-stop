package com.buskstop.vo;

import org.springframework.web.multipart.MultipartFile;

public class PremiumStage {
	
	private int establishNum; // 사업장번호
	private String operatorUserId;
	private int operatorNo;
	private String premiumStageName; // 장소명
	private String premiumStageLocation; // 주소
	private int premiumStageArea; // 면적
	private int premiumStageCost; 
	private int premiumStageParking;
	private int premiumStageDrinking;
	private int premiumStageFoodSell;
	private int premiumStageFoodRestriction;
	private MultipartFile multiImage; 
	private String premiumStageImage; // 대표사진

	public PremiumStage() {}

	public PremiumStage(int establishNum, String operatorUserId, int operatorNo, String premiumStageName,
			String premiumStageLocation, int premiumStageArea, int premiumStageCost, int premiumStageParking,
			int premiumStageDrinking, int premiumStageFoodSell, int premiumStageFoodRestriction,
			MultipartFile multiImage, String premiumStageImage) {
		this.establishNum = establishNum;
		this.operatorUserId = operatorUserId;
		this.operatorNo = operatorNo;
		this.premiumStageName = premiumStageName;
		this.premiumStageLocation = premiumStageLocation;
		this.premiumStageArea = premiumStageArea;
		this.premiumStageCost = premiumStageCost;
		this.premiumStageParking = premiumStageParking;
		this.premiumStageDrinking = premiumStageDrinking;
		this.premiumStageFoodSell = premiumStageFoodSell;
		this.premiumStageFoodRestriction = premiumStageFoodRestriction;
		this.multiImage = multiImage;
		this.premiumStageImage = premiumStageImage;
	}

	@Override
	public String toString() {
		return "PremiumStage [establishNum=" + establishNum + ", operatorUserId=" + operatorUserId + ", operatorNo="
				+ operatorNo + ", premiumStageName=" + premiumStageName + ", premiumStageLocation="
				+ premiumStageLocation + ", premiumStageArea=" + premiumStageArea + ", premiumStageCost="
				+ premiumStageCost + ", premiumStageParking=" + premiumStageParking + ", premiumStageDrinking="
				+ premiumStageDrinking + ", premiumStageFoodSell=" + premiumStageFoodSell
				+ ", premiumStageFoodRestriction=" + premiumStageFoodRestriction + ", multiImage=" + multiImage
				+ ", premiumStageImage=" + premiumStageImage + "]";
	}

	public int getEstablishNum() {
		return establishNum;
	}

	public void setEstablishNum(int establishNum) {
		this.establishNum = establishNum;
	}

	public String getOperatorUserId() {
		return operatorUserId;
	}

	public void setOperatorUserId(String operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	public int getOperatorNo() {
		return operatorNo;
	}

	public void setOperatorNo(int operatorNo) {
		this.operatorNo = operatorNo;
	}

	public String getPremiumStageName() {
		return premiumStageName;
	}

	public void setPremiumStageName(String premiumStageName) {
		this.premiumStageName = premiumStageName;
	}

	public String getPremiumStageLocation() {
		return premiumStageLocation;
	}

	public void setPremiumStageLocation(String premiumStageLocation) {
		this.premiumStageLocation = premiumStageLocation;
	}

	public int getPremiumStageArea() {
		return premiumStageArea;
	}

	public void setPremiumStageArea(int premiumStageArea) {
		this.premiumStageArea = premiumStageArea;
	}

	public int getPremiumStageCost() {
		return premiumStageCost;
	}

	public void setPremiumStageCost(int premiumStageCost) {
		this.premiumStageCost = premiumStageCost;
	}

	public int getPremiumStageParking() {
		return premiumStageParking;
	}

	public void setPremiumStageParking(int premiumStageParking) {
		this.premiumStageParking = premiumStageParking;
	}

	public int getPremiumStageDrinking() {
		return premiumStageDrinking;
	}

	public void setPremiumStageDrinking(int premiumStageDrinking) {
		this.premiumStageDrinking = premiumStageDrinking;
	}

	public int getPremiumStageFoodSell() {
		return premiumStageFoodSell;
	}

	public void setPremiumStageFoodSell(int premiumStageFoodSell) {
		this.premiumStageFoodSell = premiumStageFoodSell;
	}

	public int getPremiumStageFoodRestriction() {
		return premiumStageFoodRestriction;
	}

	public void setPremiumStageFoodRestriction(int premiumStageFoodRestriction) {
		this.premiumStageFoodRestriction = premiumStageFoodRestriction;
	}

	public MultipartFile getMultiImage() {
		return multiImage;
	}

	public void setMultiImage(MultipartFile multiImage) {
		this.multiImage = multiImage;
	}

	public String getPremiumStageImage() {
		return premiumStageImage;
	}

	public void setPremiumStageImage(String premiumStageImage) {
		this.premiumStageImage = premiumStageImage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + establishNum;
		result = prime * result + operatorNo;
		result = prime * result + ((operatorUserId == null) ? 0 : operatorUserId.hashCode());
		result = prime * result + premiumStageArea;
		result = prime * result + premiumStageCost;
		result = prime * result + premiumStageDrinking;
		result = prime * result + premiumStageFoodRestriction;
		result = prime * result + premiumStageFoodSell;
		result = prime * result + ((premiumStageImage == null) ? 0 : premiumStageImage.hashCode());
		result = prime * result + ((premiumStageLocation == null) ? 0 : premiumStageLocation.hashCode());
		result = prime * result + ((premiumStageName == null) ? 0 : premiumStageName.hashCode());
		result = prime * result + premiumStageParking;
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
		PremiumStage other = (PremiumStage) obj;
		if (establishNum != other.establishNum)
			return false;
		if (operatorNo != other.operatorNo)
			return false;
		if (operatorUserId == null) {
			if (other.operatorUserId != null)
				return false;
		} else if (!operatorUserId.equals(other.operatorUserId))
			return false;
		if (premiumStageArea != other.premiumStageArea)
			return false;
		if (premiumStageCost != other.premiumStageCost)
			return false;
		if (premiumStageDrinking != other.premiumStageDrinking)
			return false;
		if (premiumStageFoodRestriction != other.premiumStageFoodRestriction)
			return false;
		if (premiumStageFoodSell != other.premiumStageFoodSell)
			return false;
		if (premiumStageImage == null) {
			if (other.premiumStageImage != null)
				return false;
		} else if (!premiumStageImage.equals(other.premiumStageImage))
			return false;
		if (premiumStageLocation == null) {
			if (other.premiumStageLocation != null)
				return false;
		} else if (!premiumStageLocation.equals(other.premiumStageLocation))
			return false;
		if (premiumStageName == null) {
			if (other.premiumStageName != null)
				return false;
		} else if (!premiumStageName.equals(other.premiumStageName))
			return false;
		if (premiumStageParking != other.premiumStageParking)
			return false;
		return true;
	}
	
	
	
}
