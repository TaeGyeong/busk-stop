package com.buskstop.vo;

import java.io.Serializable;

public class Artist implements Serializable {
	
	private String artistId;
	private String artistName;
	private String performance;
	private String profile;
	private String artistMembers;
	public Artist() {
	}
	public Artist(String artistId, String artistName, String performance, String profile, String artistMembers) {
		this.artistId = artistId;
		this.artistName = artistName;
		this.performance = performance;
		this.profile = profile;
		this.artistMembers = artistMembers;
	}
	public String getArtistId() {
		return artistId;
	}
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getArtistMembers() {
		return artistMembers;
	}
	public void setArtistMembers(String artistMembers) {
		this.artistMembers = artistMembers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistId == null) ? 0 : artistId.hashCode());
		result = prime * result + ((artistMembers == null) ? 0 : artistMembers.hashCode());
		result = prime * result + ((artistName == null) ? 0 : artistName.hashCode());
		result = prime * result + ((performance == null) ? 0 : performance.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
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
		Artist other = (Artist) obj;
		if (artistId == null) {
			if (other.artistId != null)
				return false;
		} else if (!artistId.equals(other.artistId))
			return false;
		if (artistMembers == null) {
			if (other.artistMembers != null)
				return false;
		} else if (!artistMembers.equals(other.artistMembers))
			return false;
		if (artistName == null) {
			if (other.artistName != null)
				return false;
		} else if (!artistName.equals(other.artistName))
			return false;
		if (performance == null) {
			if (other.performance != null)
				return false;
		} else if (!performance.equals(other.performance))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", performance=" + performance
				+ ", profile=" + profile + ", artistMembers=" + artistMembers + "]";
	}
	
	
}
