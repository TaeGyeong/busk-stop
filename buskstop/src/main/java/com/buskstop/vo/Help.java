package com.buskstop.vo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Help implements Serializable{
	private int helpNum;
	private String helpCategory;
	private String helpTitle;
	private String helpContent;
	private String helpImage1;
	private String helpImage2;
	private String helpUserId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date helpRegTime;
	
	public Help() {
	}
	
	public Help(int helpNum, String helpCategory, String helpTitle, String helpContent, String helpImage1,
			String helpImage2, String helpUserId, Date helpRegTime) {
		this.helpNum = helpNum;
		this.helpCategory = helpCategory;
		this.helpTitle = helpTitle;
		this.helpContent = helpContent;
		this.helpImage1 = helpImage1;
		this.helpImage2 = helpImage2;
		this.helpUserId = helpUserId;
		this.helpRegTime = helpRegTime;
	}
	@Override
	public String toString() {
		return "Help [helpNum=" + helpNum + ", helpCategory=" + helpCategory + ", helpTitle=" + helpTitle
				+ ", helpContent=" + helpContent + ", helpImage1=" + helpImage1 + ", helpImage2=" + helpImage2
				+ ", helpUserId=" + helpUserId + ", helpRegTime=" + helpRegTime + "]";
	}
	public int getHelpNum() {
		return helpNum;
	}
	public String getHelpCategory() {
		return helpCategory;
	}
	public String getHelpTitle() {
		return helpTitle;
	}
	public String getHelpContent() {
		return helpContent;
	}
	public String getHelpImage1() {
		return helpImage1;
	}
	public String getHelpImage2() {
		return helpImage2;
	}
	public String getHelpUserId() {
		return helpUserId;
	}
	public Date getHelpRegTime() {
		return helpRegTime;
	}
	public void setHelpNum(int helpNum) {
		this.helpNum = helpNum;
	}
	public void setHelpCategory(String helpCategory) {
		this.helpCategory = helpCategory;
	}
	public void setHelpTitle(String helpTitle) {
		this.helpTitle = helpTitle;
	}
	public void setHelpContent(String helpContent) {
		this.helpContent = helpContent;
	}
	public void setHelpImage1(String helpImage1) {
		this.helpImage1 = helpImage1;
	}
	public void setHelpImage2(String helpImage2) {
		this.helpImage2 = helpImage2;
	}
	public void setHelpUserId(String helpUserId) {
		this.helpUserId = helpUserId;
	}
	public void setHelpRegTime(Date helpRegTime) {
		this.helpRegTime = helpRegTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((helpCategory == null) ? 0 : helpCategory.hashCode());
		result = prime * result + ((helpContent == null) ? 0 : helpContent.hashCode());
		result = prime * result + ((helpImage1 == null) ? 0 : helpImage1.hashCode());
		result = prime * result + ((helpImage2 == null) ? 0 : helpImage2.hashCode());
		result = prime * result + helpNum;
		result = prime * result + ((helpRegTime == null) ? 0 : helpRegTime.hashCode());
		result = prime * result + ((helpTitle == null) ? 0 : helpTitle.hashCode());
		result = prime * result + ((helpUserId == null) ? 0 : helpUserId.hashCode());
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
		Help other = (Help) obj;
		if (helpCategory == null) {
			if (other.helpCategory != null)
				return false;
		} else if (!helpCategory.equals(other.helpCategory))
			return false;
		if (helpContent == null) {
			if (other.helpContent != null)
				return false;
		} else if (!helpContent.equals(other.helpContent))
			return false;
		if (helpImage1 == null) {
			if (other.helpImage1 != null)
				return false;
		} else if (!helpImage1.equals(other.helpImage1))
			return false;
		if (helpImage2 == null) {
			if (other.helpImage2 != null)
				return false;
		} else if (!helpImage2.equals(other.helpImage2))
			return false;
		if (helpNum != other.helpNum)
			return false;
		if (helpRegTime == null) {
			if (other.helpRegTime != null)
				return false;
		} else if (!helpRegTime.equals(other.helpRegTime))
			return false;
		if (helpTitle == null) {
			if (other.helpTitle != null)
				return false;
		} else if (!helpTitle.equals(other.helpTitle))
			return false;
		if (helpUserId == null) {
			if (other.helpUserId != null)
				return false;
		} else if (!helpUserId.equals(other.helpUserId))
			return false;
		return true;
	}
	
	
}
