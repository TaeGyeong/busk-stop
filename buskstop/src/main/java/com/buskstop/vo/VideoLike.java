package com.buskstop.vo;

import java.io.Serializable;
import java.util.List;

public class VideoLike implements Serializable {
	private int videoLikeNum;
	private List<User> likeUser;
	
	public VideoLike() {}

	public VideoLike(int videoLikeNum, List<User> likeUser) {
		this.videoLikeNum = videoLikeNum;
		this.likeUser = likeUser;
	}

	public int getVideoLikeNum() {
		return videoLikeNum;
	}

	public void setVideoLikeNum(int videoLikeNum) {
		this.videoLikeNum = videoLikeNum;
	}

	public List<User> getLikeUser() {
		return likeUser;
	}

	public void setLikeUser(List<User> likeUser) {
		this.likeUser = likeUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((likeUser == null) ? 0 : likeUser.hashCode());
		result = prime * result + videoLikeNum;
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
		VideoLike other = (VideoLike) obj;
		if (likeUser == null) {
			if (other.likeUser != null)
				return false;
		} else if (!likeUser.equals(other.likeUser))
			return false;
		if (videoLikeNum != other.videoLikeNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VideoLike [videoLikeNum=" + videoLikeNum + ", likeUser=" + likeUser + "]";
	}

	
}
