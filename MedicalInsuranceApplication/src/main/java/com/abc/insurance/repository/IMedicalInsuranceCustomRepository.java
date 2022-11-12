package com.abc.insurance.repository;


import java.util.List;


import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.MedicalInsurance;


@Repository
public interface IMedicalInsuranceCustomRepository {
	public List<MedicalInsurance> getMedicalInsuranceByPremium(int premium)throws Exception;
	public MedicalInsurance getMedicalInsuranceBySumInsured(int sumInsured)throws Exception;
	public MedicalInsurance getMedicalInsuranceByInsuranceName(String insuranceName)throws Exception;
}