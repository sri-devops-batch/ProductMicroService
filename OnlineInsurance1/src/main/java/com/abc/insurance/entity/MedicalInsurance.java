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
@Table(name = "MedicalInsurance")
public class MedicalInsurance {
      
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  tokenId;
	
	private String partyName;
	private String dateOfBirth;
	private String gender;
	private int premium;
	private int sumInsured;
	public MedicalInsurance(String partyName, String dateOfBirth, String gender, int premium, int sumInsured) {
		super();
		this.partyName = partyName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.premium = premium;
		this.sumInsured = sumInsured;
	}
	
	
}
