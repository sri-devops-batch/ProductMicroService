package com.abc.insurance.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.abc.insurance.dto.DefaultResponseDTO;
import com.abc.insurance.entity.MedicalInsurance;



@Component
@Scope("singleton")
public class MedicalInsuranceDTOConvertor {
	public static DefaultResponseDTO  getMedicalInsuranceDefaultDTO(MedicalInsurance medicalInsurance)
	{
		DefaultResponseDTO dto = new DefaultResponseDTO(
				medicalInsurance.getInsuranceName(), 
				medicalInsurance.getMId(), 
				medicalInsurance.getMedicalPolicies().getUserName(),
				                 "User Policies Created , policy Id : "+medicalInsurance.getMedicalPolicies().getMedicalPolicyId());
		
		return dto;
	}

	
	
}