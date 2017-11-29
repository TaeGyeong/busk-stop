package com.buskstop.vo;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable{
	private int videoNo;
	private String videoTitle;
	private String videoRink;
	private String videoLocation;//영상속 장소
	private String videoContent;
	private Date videoDate;
	private String videoArtist;
	private String videoCategory;//아티스트 홍보영상, 공연영상, 연습영상
	private Date videoRegTime;
	private int videoUserId;
	
	
	public Video() {
	}


	public Video(int videoNo, String videoTitle, String videoRink, String videoLocation, String videoContent,
			Date videoDate, String videoArtist, String videoCategory, Date videoRegTime, int videoUserId) {
		super();
		this.videoNo = videoNo;
		this.videoTitle = videoTitle;
		this.videoRink = videoRink;
		this.videoLocation = videoLocation;
		this.videoContent = videoContent;
		this.videoDate = videoDate;
		this.videoArtist = videoArtist;
		this.videoCategory = videoCategory;
		this.videoRegTime = videoRegTime;
		this.videoUserId = videoUserId;
	}


	public int getVideoNo() {
		return videoNo;
	}


	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}


	public String getVideoTitle() {
		return videoTitle;
	}


	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}


	public String getVideoRink() {
		return videoRink;
	}


	public void setVideoRink(String videoRink) {
		this.videoRink = videoRink;
	}


	public String getVideoLocation() {
		return videoLocation;
	}


	public void setVideoLocation(String videoLocation) {
		this.videoLocation = videoLocation;
	}


	public String getVideoContent() {
		return videoContent;
	}


	public void setVideoContent(String videoContent) {
		this.videoContent = videoContent;
	}


	public Date getVideoDate() {
		return videoDate;
	}


	public void setVideoDate(Date videoDate) {
		this.videoDate = videoDate;
	}


	public String getVideoArtist() {
		return videoArtist;
	}


	public void setVideoArtist(String videoArtist) {
		this.videoArtist = videoArtist;
	}


	public String getVideoCategory() {
		return videoCategory;
	}


	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}


	public Date getVideoRegTime() {
		return videoRegTime;
	}


	public void setVideoRegTime(Date videoRegTime) {
		this.videoRegTime = videoRegTime;
	}


	public int getVideoUserId() {
		return videoUserId;
	}


	public void setVideoUserId(int videoUserId) {
		this.videoUserId = videoUserId;
	}


	@Override
	public String toString() {
		return "Video [videoNo=" + videoNo + ", videoTitle=" + videoTitle + ", videoRink=" + videoRink
				+ ", videoLocation=" + videoLocation + ", videoContent=" + videoContent + ", videoDate=" + videoDate
				+ ", videoArtist=" + videoArtist + ", videoCategory=" + videoCategory + ", videoRegTime=" + videoRegTime
				+ ", videoUserId=" + videoUserId + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((videoArtist == null) ? 0 : videoArtist.hashCode());
		result = prime * result + ((videoCategory == null) ? 0 : videoCategory.hashCode());
		result = prime * result + ((videoContent == null) ? 0 : videoContent.hashCode());
		result = prime * result + ((videoDate == null) ? 0 : videoDate.hashCode());
		result = prime * result + ((videoLocation == null) ? 0 : videoLocation.hashCode());
		result = prime * result + videoNo;
		result = prime * result + ((videoRegTime == null) ? 0 : videoRegTime.hashCode());
		result = prime * result + ((videoRink == null) ? 0 : videoRink.hashCode());
		result = prime * result + ((videoTitle == null) ? 0 : videoTitle.hashCode());
		result = prime * result + videoUserId;
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
		Video other = (Video) obj;
		if (videoArtist == null) {
			if (other.videoArtist != null)
				return false;
		} else if (!videoArtist.equals(other.videoArtist))
			return false;
		if (videoCategory == null) {
			if (other.videoCategory != null)
				return false;
		} else if (!videoCategory.equals(other.videoCategory))
			return false;
		if (videoContent == null) {
			if (other.videoContent != null)
				return false;
		} else if (!videoContent.equals(other.videoContent))
			return false;
		if (videoDate == null) {
			if (other.videoDate != null)
				return false;
		} else if (!videoDate.equals(other.videoDate))
			return false;
		if (videoLocation == null) {
			if (other.videoLocation != null)
				return false;
		} else if (!videoLocation.equals(other.videoLocation))
			return false;
		if (videoNo != other.videoNo)
			return false;
		if (videoRegTime == null) {
			if (other.videoRegTime != null)
				return false;
		} else if (!videoRegTime.equals(other.videoRegTime))
			return false;
		if (videoRink == null) {
			if (other.videoRink != null)
				return false;
		} else if (!videoRink.equals(other.videoRink))
			return false;
		if (videoTitle == null) {
			if (other.videoTitle != null)
				return false;
		} else if (!videoTitle.equals(other.videoTitle))
			return false;
		if (videoUserId != other.videoUserId)
			return false;
		return true;
	}

}