package com.abc.insurance.service;

import java.util.List;



import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.entity.MedicalPolicies;
import com.abc.insurance.repository.MedicalInsuranceRepository;



@Service
public class MedicalInsuranceServiceImpl implements MedicalInsuranceService {
	
	@Autowired
	MedicalInsuranceRepository medicalInsuranceRepository;

	@Override
	public MedicalInsurance insertMedicalInsurance(MedicalInsurance medicalInsurance)throws Exception {
		
		MedicalInsurance savedMedicalInsurance =  medicalInsuranceRepository.save(medicalInsurance);  // Note :  save() is already implemented by Spring Data JPA
		if(savedMedicalInsurance != null)
		{
			return savedMedicalInsurance;
		}
		else return null;
	}

	@Override
	public List<MedicalInsurance> getAllMedicalInsurance() throws Exception {

		List<MedicalInsurance> allInsurance = medicalInsuranceRepository.findAll(); // Note : same as save
		return allInsurance;
	}

	@Override
	public MedicalInsurance getMedicalInsuranceBySumInsured(int sumInsured) throws Exception {
		return  medicalInsuranceRepository.getMedicalInsuranceBySumInsured(sumInsured);
	}

	@Override
	public List<MedicalInsurance> getMedicalInsuranceByPremium(int premium) throws Exception {
	
		return medicalInsuranceRepository.getMedicalInsuranceByPremium(premium);
	}

	@Override
	public MedicalInsurance updateMedicalInsurance(MedicalInsurance medicalInsurance) throws Exception{
		return medicalInsuranceRepository.save(medicalInsurance);
	}

	@Override
	public MedicalInsurance getMedicalInsuranceByInsuranceName(String insuranceName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInsuranceByMId(int mId) throws Exception {
		medicalInsuranceRepository.deleteById(mId);
		
	}

	@Override
	@Transactional
	public MedicalInsurance linkMedicalPolicy(MedicalPolicies medicalPolicies, MedicalInsurance medicalInsurance) {
		medicalInsurance.setMedicalPolicies(medicalPolicies);
		return medicalInsurance;
	}



	

	

}//end of class