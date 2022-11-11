package com.skj.gtest.dto;

import org.springframework.stereotype.Component;

@Component
public class UserPostCreatedResponseDTO implements MyDTO {
	private String username;
	private int userId;
	private String postDescription;
	private String remarks;
	public UserPostCreatedResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPostCreatedResponseDTO(String username, int userId, String postDescription, String remarks) {
		super();
		this.username = username;
		this.userId = userId;
		this.postDescription = postDescription;
		this.remarks = remarks;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPostDescription() {
		return postDescription;
	}
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "UserPostCreatedResponseDTO [username=" + username + ", userId=" + userId + ", postDescription="
				+ postDescription + ", remarks=" + remarks + "]";
	}


}