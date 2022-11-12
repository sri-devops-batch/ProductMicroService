package com.abc.insurance.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.MedicalPolicies;


@Service
public interface MedicalPoliciesService {
	public MedicalPolicies addMedicalPolicies(MedicalPolicies medicalPolicies)throws Exception;
	public List<MedicalPolicies> viewPoliciesHistory(MedicalPolicies medicalPolicies)throws Exception;
	public List<MedicalPolicies> getMedicalPoliciesBetweenPolicyNumber(@Param("range1") int range1,@Param("range2") int range2)throws Exception;
	public MedicalPolicies getMedicalPoliciesByUserName(String userName)throws Exception;
	public List<MedicalPolicies> getMedicalPoliciesBasedOnisClaimedDate(String isClaimed,String claimedDate)throws Exception;

}