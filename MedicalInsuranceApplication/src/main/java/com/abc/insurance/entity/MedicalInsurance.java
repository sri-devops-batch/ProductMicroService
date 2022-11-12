package com.abc.insurance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	private int mId;
	
    private String insuranceName;
    private int premium;
    private int sumInsured;
    private int opdAmmount;
    private int maxSurgeryAmmount;
    private int roomRent;
    
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policies")
	private MedicalPolicies medicalPolicies;
    
    
	public MedicalInsurance(String insuranceName, int premium, int sumInsured, int opdAmmount, int maxSurgeryAmmount,
			int roomRent) {
		super();
		this.insuranceName = insuranceName;
		this.premium = premium;
		this.sumInsured = sumInsured;
		this.opdAmmount = opdAmmount;
		this.maxSurgeryAmmount = maxSurgeryAmmount;
		this.roomRent = roomRent;
	}


	

    
	
}
