package com.buskstop.vo;

import java.io.Serializable;
import java.sql.Date;

public class Video implements Serializable{
	private int videoNum;
	private String videoTitle;
	private String videoRink;
	private String videoLocation;
	private String videoContent;
	private Date videoDate;
	private String artist;
	private User videoUser;
	
	public Video() {
	}
	public Video(int videoNum, String videoTitle, String videoRink, String videoLocation, String videoContent,
			Date videoDate, String artist, User videoUser) {
		this.videoNum = videoNum;
		this.videoTitle = videoTitle;
		this.videoRink = videoRink;
		this.videoLocation = videoLocation;
		this.videoContent = videoContent;
		this.videoDate = videoDate;
		this.artist = artist;
		this.videoUser = videoUser;
	}
	public int getVideoNum() {
		return videoNum;
	}
	public void setVideoNum(int videoNum) {
		this.videoNum = videoNum;
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
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public User getVideoUser() {
		return videoUser;
	}
	public void setVideoUser(User videoUser) {
		this.videoUser = videoUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((videoContent == null) ? 0 : videoContent.hashCode());
		result = prime * result + ((videoDate == null) ? 0 : videoDate.hashCode());
		result = prime * result + ((videoLocation == null) ? 0 : videoLocation.hashCode());
		result = prime * result + videoNum;
		result = prime * result + ((videoRink == null) ? 0 : videoRink.hashCode());
		result = prime * result + ((videoTitle == null) ? 0 : videoTitle.hashCode());
		result = prime * result + ((videoUser == null) ? 0 : videoUser.hashCode());
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
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
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
		if (videoNum != other.videoNum)
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
		if (videoUser == null) {
			if (other.videoUser != null)
				return false;
		} else if (!videoUser.equals(other.videoUser))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Video [videoNum=" + videoNum + ", videoTitle=" + videoTitle + ", videoRink=" + videoRink
				+ ", videoLocation=" + videoLocation + ", videoContent=" + videoContent + ", videoDate=" + videoDate
				+ ", artist=" + artist + ", videoUser=" + videoUser + "]";
	}
	
	
}
