package com.buskstop.vo;

import java.io.Serializable;

public class Authority implements Serializable{
	private String authorityId;
	private String authority;
	public Authority() {
	}
	public Authority(String authorityId, String authority) {
		this.authorityId = authorityId;
		this.authority = authority;
	}
	public String getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((authorityId == null) ? 0 : authorityId.hashCode());
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
		Authority other = (Authority) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (authorityId == null) {
			if (other.authorityId != null)
				return false;
		} else if (!authorityId.equals(other.authorityId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Authority [authorityId=" + authorityId + ", authority=" + authority + "]";
	}
	
}
