package com.abc.insurance.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "policies")
public class MedicalPolicies {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int medicalPolicyId;

private int PolicyNumber;
@NotNull(message = "policy Name cannot be Null")
private String userName;
private String dateOfPurchase;
private String dateOfExpire;
private String isClaimed;
private String claimDate;

public MedicalPolicies(int policyNumber, @NotNull(message = "policy Name cannot be Null") String userName,
		String dateOfPurchase, String dateOfExpire, String isClaimed, String claimDate) {
	super();
	PolicyNumber = policyNumber;
	this.userName = userName;
	this.dateOfPurchase = dateOfPurchase;
	this.dateOfExpire = dateOfExpire;
	this.isClaimed = isClaimed;
	this.claimDate = claimDate;
}



//end of constructor


}//end of class