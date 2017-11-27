package com.buskstop.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class Performance implements Serializable{
	private int performanceNo;
	private String performanceName;
	private String performanceTitle;
	private String performanceLocation;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date performanceDate;
	private int performanceHits;
	private String performanceContent;
	private String performanceImage;
	private String performanceUserId;
	// TODO 공연장 번호 연결 해야함.
	//private int StageNo;
	
	public Performance() {}

	public Performance(int performanceNo, String performanceName, String performanceTitle, String performanceLocation,
			Date performanceDate, int performanceHits, String performanceContent, String performanceImage,
			String performanceUserId) {
		this.performanceNo = performanceNo;
		this.performanceName = performanceName;
		this.performanceTitle = performanceTitle;
		this.performanceLocation = performanceLocation;
		this.performanceDate = performanceDate;
		this.performanceHits = performanceHits;
		this.performanceContent = performanceContent;
		this.performanceImage = performanceImage;
		this.performanceUserId = performanceUserId;
	}

	public Performance(int performanceNo, String performanceName, String performanceTitle, String performanceLocation,
			Date performanceDate, String performanceContent, String performanceImage, String performanceUserId) {
		this.performanceNo = performanceNo;
		this.performanceName = performanceName;
		this.performanceTitle = performanceTitle;
		this.performanceLocation = performanceLocation;
		this.performanceDate = performanceDate;
		this.performanceContent = performanceContent;
		this.performanceImage = performanceImage;
		this.performanceUserId = performanceUserId;
	}

	public int getPerformanceNo() {
		return performanceNo;
	}

	public void setPerformanceNo(int performanceNo) {
		this.performanceNo = performanceNo;
	}

	public String getPerformanceName() {
		return performanceName;
	}

	public void setPerformanceName(String performanceName) {
		this.performanceName = performanceName;
	}

	public String getPerformanceTitle() {
		return performanceTitle;
	}

	public void setPerformanceTitle(String performanceTitle) {
		this.performanceTitle = performanceTitle;
	}

	public String getPerformanceLocation() {
		return performanceLocation;
	}

	public void setPerformanceLocation(String performanceLocation) {
		this.performanceLocation = performanceLocation;
	}

	public Date getPerformanceDate() {
		return performanceDate;
	}

	public void setPerformanceDate(Date performanceDate) {
		this.performanceDate = performanceDate;
	}

	public int getPerformanceHits() {
		return performanceHits;
	}

	public void setPerformanceHits(int performanceHits) {
		this.performanceHits = performanceHits;
	}

	public String getPerformanceContent() {
		return performanceContent;
	}

	public void setPerformanceContent(String performanceContent) {
		this.performanceContent = performanceContent;
	}

	public String getPerformanceImage() {
		return performanceImage;
	}

	public void setPerformanceImage(String performanceImage) {
		this.performanceImage = performanceImage;
	}

	public String getPerformanceUserId() {
		return performanceUserId;
	}

	public void setPerformanceUserId(String performanceUserId) {
		this.performanceUserId = performanceUserId;
	}

	@Override
	public String toString() {
		return "Performance [performanceNo=" + performanceNo + ", performanceName=" + performanceName
				+ ", performanceTitle=" + performanceTitle + ", performanceLocation=" + performanceLocation
				+ ", performanceDate=" + performanceDate + ", performanceHits=" + performanceHits
				+ ", performanceContent=" + performanceContent + ", performanceImage=" + performanceImage
				+ ", performanceUserId=" + performanceUserId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((performanceContent == null) ? 0 : performanceContent.hashCode());
		result = prime * result + ((performanceDate == null) ? 0 : performanceDate.hashCode());
		result = prime * result + performanceHits;
		result = prime * result + ((performanceImage == null) ? 0 : performanceImage.hashCode());
		result = prime * result + ((performanceLocation == null) ? 0 : performanceLocation.hashCode());
		result = prime * result + ((performanceName == null) ? 0 : performanceName.hashCode());
		result = prime * result + performanceNo;
		result = prime * result + ((performanceTitle == null) ? 0 : performanceTitle.hashCode());
		result = prime * result + ((performanceUserId == null) ? 0 : performanceUserId.hashCode());
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
		Performance other = (Performance) obj;
		if (performanceContent == null) {
			if (other.performanceContent != null)
				return false;
		} else if (!performanceContent.equals(other.performanceContent))
			return false;
		if (performanceDate == null) {
			if (other.performanceDate != null)
				return false;
		} else if (!performanceDate.equals(other.performanceDate))
			return false;
		if (performanceHits != other.performanceHits)
			return false;
		if (performanceImage == null) {
			if (other.performanceImage != null)
				return false;
		} else if (!performanceImage.equals(other.performanceImage))
			return false;
		if (performanceLocation == null) {
			if (other.performanceLocation != null)
				return false;
		} else if (!performanceLocation.equals(other.performanceLocation))
			return false;
		if (performanceName == null) {
			if (other.performanceName != null)
				return false;
		} else if (!performanceName.equals(other.performanceName))
			return false;
		if (performanceNo != other.performanceNo)
			return false;
		if (performanceTitle == null) {
			if (other.performanceTitle != null)
				return false;
		} else if (!performanceTitle.equals(other.performanceTitle))
			return false;
		if (performanceUserId == null) {
			if (other.performanceUserId != null)
				return false;
		} else if (!performanceUserId.equals(other.performanceUserId))
			return false;
		return true;
	}

}
