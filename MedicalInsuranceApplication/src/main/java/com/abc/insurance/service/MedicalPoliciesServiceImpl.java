package com.abc.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.insurance.entity.MedicalPolicies;
import com.abc.insurance.repository.MedicalPoliciesRepository;




@Service
public class MedicalPoliciesServiceImpl implements MedicalPoliciesService {
	@Autowired
	MedicalPoliciesRepository medicalPoliciesRepository;
	
	@Override
	@Transactional
	public MedicalPolicies addMedicalPolicies(MedicalPolicies medicalPolicies) throws Exception {
		MedicalPolicies savedHomePolicy =medicalPoliciesRepository.save(medicalPolicies);
		return  savedHomePolicy;
	}

	@Override
	public List<MedicalPolicies> viewPoliciesHistory(MedicalPolicies medicalPolicies) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalPolicies> getMedicalPoliciesBetweenPolicyNumber(int range1, int range2) throws Exception {
		// TODO Auto-generated method stub
		return  medicalPoliciesRepository.getMedicalPoliciesBetweenPolicyNumber(range1, range2);
	}

	@Override
	public MedicalPolicies getMedicalPoliciesByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return medicalPoliciesRepository.getMedicalPoliciesByUserName(userName);
	}

	
	@Override
	public List<MedicalPolicies> getMedicalPoliciesBasedOnisClaimedDate(String isClaimed, String claimedDate)
			throws Exception {

		//return homePoliciesRepository.getHomePoliciesBasedOnisClaimedDate(isClaimed, claimedDate);
		return null;
	}

	

	

}