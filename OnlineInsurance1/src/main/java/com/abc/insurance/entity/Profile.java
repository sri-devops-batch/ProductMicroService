package com.abc.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userProfile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int profileId;
	
	private String fullName;
	private int phoneNumber;
	private String email;
	private String locations;
	
	public Profile(String fullName, int phoneNumber, String email, String locations) {
		super();
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.locations = locations;
	}
	
	
	
}