package com.buskstop.vo;

import java.io.Serializable;

public class StageReview implements Serializable{
	private int stageNo;
	private String userId;
	private int starScore;
	private String comment;
	private String commentRegTime;
	
	public StageReview() {
	}
	
	public StageReview(int stageNo, String userId, int starScore, String comment, String commentRegTime) {
		this.stageNo = stageNo;
		this.userId = userId;
		this.starScore = starScore;
		this.comment = comment;
		this.commentRegTime = commentRegTime;
	}
	public int getStageNo() {
		return stageNo;
	}
	public void setStageNo(int stageNo) {
		this.stageNo = stageNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getStarScore() {
		return starScore;
	}
	public void setStarScore(int starScore) {
		this.starScore = starScore;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentRegTime() {
		return commentRegTime;
	}
	public void setCommentRegTime(String commentRegTime) {
		this.commentRegTime = commentRegTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((commentRegTime == null) ? 0 : commentRegTime.hashCode());
		result = prime * result + stageNo;
		result = prime * result + starScore;
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
		StageReview other = (StageReview) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commentRegTime == null) {
			if (other.commentRegTime != null)
				return false;
		} else if (!commentRegTime.equals(other.commentRegTime))
			return false;
		if (stageNo != other.stageNo)
			return false;
		if (starScore != other.starScore)
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
		return "StageReview [stageNo=" + stageNo + ", userId=" + userId + ", starScore=" + starScore + ", comment="
				+ comment + ", commentRegTime=" + commentRegTime + "]";
	}
	
}
