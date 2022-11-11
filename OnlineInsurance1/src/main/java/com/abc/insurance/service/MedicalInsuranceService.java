package com.abc.insurance.service;

	import java.util.List;

	import org.springframework.stereotype.Service;

import com.abc.insurance.entity.MedicalInsurance;


	@Service
	public interface MedicalInsuranceService {
	public MedicalInsurance insertMedicalInsurance(MedicalInsurance medicalInsurance)throws Exception;

	public List<MedicalInsurance> getAllMedicalInsurance()throws Exception;
	public MedicalInsurance getMedicalInsuranceBySumInsured(int sumInsured) throws Exception;

	public List<MedicalInsurance> getMedicalInsuranceByPremium(int premium) throws Exception;

	}

