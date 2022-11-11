package com.skj.gtest.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.checkerframework.checker.index.qual.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FBProfiles")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int profileId;
	@NotNull(message = "Username cannot be Null")
	@Size(min = 2,message = "Username is not valid, should have more than 2 characters")
	private String fullName;
	private String city;
	private String locations;
	@Email(message = "Not a valid email")
	private String email;

	private long phoneNumber;
	private String companyName;
	
	
	public Profile(String fullName, String city, String locations, String email, long phoneNumber, String companyName) {
		super();
		this.fullName = fullName;
		this.city = city;
		this.locations = locations;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
	}
	
	
	
	
}//end class