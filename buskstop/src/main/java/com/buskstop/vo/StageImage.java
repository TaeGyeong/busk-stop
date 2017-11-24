package com.buskstop.vo;

import java.io.Serializable;

public class StageImage implements Serializable{
	private int stageImageNum;
	private String stageImageLocation;
	private int stageNum;
	public StageImage() {
	}
	public StageImage(int stageImageNum, String stageImageLocation, int stageNum) {
		this.stageImageNum = stageImageNum;
		this.stageImageLocation = stageImageLocation;
		this.stageNum = stageNum;
	}
	public int getStageImageNum() {
		return stageImageNum;
	}
	public void setStageImageNum(int stageImageNum) {
		this.stageImageNum = stageImageNum;
	}
	public String getStageImageLocation() {
		return stageImageLocation;
	}
	public void setStageImageLocation(String stageImageLocation) {
		this.stageImageLocation = stageImageLocation;
	}
	public int getStageNum() {
		return stageNum;
	}
	public void setStageNum(int stageNum) {
		this.stageNum = stageNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stageImageLocation == null) ? 0 : stageImageLocation.hashCode());
		result = prime * result + stageImageNum;
		result = prime * result + stageNum;
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
		StageImage other = (StageImage) obj;
		if (stageImageLocation == null) {
			if (other.stageImageLocation != null)
				return false;
		} else if (!stageImageLocation.equals(other.stageImageLocation))
			return false;
		if (stageImageNum != other.stageImageNum)
			return false;
		if (stageNum != other.stageNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StageImage [stageImageNum=" + stageImageNum + ", stageImageLocation=" + stageImageLocation
				+ ", stageNum=" + stageNum + "]";
	}
	
}
