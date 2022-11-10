package com.abc.insurance.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicalInsurance {

	private String partyName;
	private String dateOfBirth;
	private String gender;
	private int premium;
	private int sumInsured;
	
}
