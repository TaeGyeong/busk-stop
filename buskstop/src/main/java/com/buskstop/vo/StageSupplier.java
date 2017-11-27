package com.buskstop.vo;

import java.io.Serializable;

public class StageSupplier implements Serializable{
	private int establishNum; // 사업장번호
	private int operatorNum; // 사업자번호
	
	private String stageName; // 장소명
	private String stageLocation; // 주소
	private String stageArea; // 면적
	private String stageImage; // 대표사진
	
	private String userId; // 사용자 정보

	public StageSupplier() {
	}

	public StageSupplier(int establishNum, int operatorNum, String stageName, String stageLocation, String stageArea,
			String stageImage, String userId) {
		this.establishNum = establishNum;
		this.operatorNum = operatorNum;
		this.stageName = stageName;
		this.stageLocation = stageLocation;
		this.stageArea = stageArea;
		this.stageImage = stageImage;
		this.userId = userId;
	}

	public int getEstablishNum() {
		return establishNum;
	}

	public void setEstablishNum(int establishNum) {
		this.establishNum = establishNum;
	}

	public int getOperatorNum() {
		return operatorNum;
	}

	public void setOperatorNum(int operatorNum) {
		this.operatorNum = operatorNum;
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

	public String getStageArea() {
		return stageArea;
	}

	public void setStageArea(String stageArea) {
		this.stageArea = stageArea;
	}

	public String getStageImage() {
		return stageImage;
	}

	public void setStageImage(String stageImage) {
		this.stageImage = stageImage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + establishNum;
		result = prime * result + operatorNum;
		result = prime * result + ((stageArea == null) ? 0 : stageArea.hashCode());
		result = prime * result + ((stageImage == null) ? 0 : stageImage.hashCode());
		result = prime * result + ((stageLocation == null) ? 0 : stageLocation.hashCode());
		result = prime * result + ((stageName == null) ? 0 : stageName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		StageSupplier other = (StageSupplier) obj;
		if (establishNum != other.establishNum)
			return false;
		if (operatorNum != other.operatorNum)
			return false;
		if (stageArea == null) {
			if (other.stageArea != null)
				return false;
		} else if (!stageArea.equals(other.stageArea))
			return false;
		if (stageImage == null) {
			if (other.stageImage != null)
				return false;
		} else if (!stageImage.equals(other.stageImage))
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StageSupplier [establishNum=" + establishNum + ", operatorNum=" + operatorNum + ", stageName="
				+ stageName + ", stageLocation=" + stageLocation + ", stageArea=" + stageArea + ", stageImage="
				+ stageImage + ", userId=" + userId + "]";
	}

	
}
