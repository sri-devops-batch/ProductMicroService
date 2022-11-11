package com.skj.gtest.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDefaultResponseDTO implements MyDTO{


	private String username;
	private int userId;
	private String registeredEmail;
	private String remarks;
	public UserDefaultResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDefaultResponseDTO(String username, int userId, String registeredEmail, String remarks) {
		super();
		this.username = username;
		this.userId = userId;
		this.registeredEmail = registeredEmail;
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
	public String getRegisteredEmail() {
		return registeredEmail;
	}
	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "UserDefaultResponseDTO [username=" + username + ", userId=" + userId + ", registeredEmail="
				+ registeredEmail + ", remarks=" + remarks + "]";
	}



}