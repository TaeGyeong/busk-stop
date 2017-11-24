package com.buskstop.vo;

import java.io.Serializable;
import java.util.List;

public class VideoComment implements Serializable{
	
	private int videoId;
	private String userId;
	private String videoComment;
	public VideoComment() {
	}
	public VideoComment(int videoId, String userId, String videoComment) {
		this.videoId = videoId;
		this.userId = userId;
		this.videoComment = videoComment;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVideoComment() {
		return videoComment;
	}
	public void setVideoComment(String videoComment) {
		this.videoComment = videoComment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((videoComment == null) ? 0 : videoComment.hashCode());
		result = prime * result + videoId;
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
		VideoComment other = (VideoComment) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (videoComment == null) {
			if (other.videoComment != null)
				return false;
		} else if (!videoComment.equals(other.videoComment))
			return false;
		if (videoId != other.videoId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "VideoComment [videoId=" + videoId + ", userId=" + userId + ", videoComment=" + videoComment + "]";
	}
	
	
}
