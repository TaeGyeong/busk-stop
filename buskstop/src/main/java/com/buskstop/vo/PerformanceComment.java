package com.buskstop.vo;

import java.io.Serializable;

public class PerformanceComment implements Serializable{
	
	private int performanceCommentNo;
	private int performanceNo;
	private String performanceCommentUserId;
	private String performanceComment;
	
	public PerformanceComment() {}
	
	@Override
	public String toString() {
		return "PerformanceComment [performanceCommentNo=" + performanceCommentNo + ", performanceNo=" + performanceNo
				+ ", performanceCommentUserId=" + performanceCommentUserId + ", performanceComment="
				+ performanceComment + "]";
	}
	
	public PerformanceComment(int performanceCommentNo, int performanceNo, String performanceCommentUserId,
			String performanceComment) {
		this.performanceCommentNo = performanceCommentNo;
		this.performanceNo = performanceNo;
		this.performanceCommentUserId = performanceCommentUserId;
		this.performanceComment = performanceComment;
	}

	public int getPerformanceCommentNo() {
		return performanceCommentNo;
	}

	public void setPerformanceCommentNo(int performanceCommentNo) {
		this.performanceCommentNo = performanceCommentNo;
	}

	public int getPerformanceNo() {
		return performanceNo;
	}

	public void setPerformanceNo(int performanceNo) {
		this.performanceNo = performanceNo;
	}

	public String getPerformanceCommentUserId() {
		return performanceCommentUserId;
	}

	public void setPerformanceCommentUserId(String performanceCommentUserId) {
		this.performanceCommentUserId = performanceCommentUserId;
	}

	public String getPerformanceComment() {
		return performanceComment;
	}

	public void setPerformanceComment(String performanceComment) {
		this.performanceComment = performanceComment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((performanceComment == null) ? 0 : performanceComment.hashCode());
		result = prime * result + performanceCommentNo;
		result = prime * result + ((performanceCommentUserId == null) ? 0 : performanceCommentUserId.hashCode());
		result = prime * result + performanceNo;
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
		PerformanceComment other = (PerformanceComment) obj;
		if (performanceComment == null) {
			if (other.performanceComment != null)
				return false;
		} else if (!performanceComment.equals(other.performanceComment))
			return false;
		if (performanceCommentNo != other.performanceCommentNo)
			return false;
		if (performanceCommentUserId == null) {
			if (other.performanceCommentUserId != null)
				return false;
		} else if (!performanceCommentUserId.equals(other.performanceCommentUserId))
			return false;
		if (performanceNo != other.performanceNo)
			return false;
		return true;
	}
	
}
