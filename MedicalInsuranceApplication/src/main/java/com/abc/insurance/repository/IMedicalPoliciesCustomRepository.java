package com.abc.insurance.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.MedicalPolicies;



@Repository
public interface IMedicalPoliciesCustomRepository {
	@Query("from MedicalPolicies where PolicyNumber >= :range1 and PolicyNumber <= :range2")
	public List<MedicalPolicies> getMedicalPoliciesBetweenPolicyNumber(@Param("range1") int range1,@Param("range2") int range2)throws Exception;
	public MedicalPolicies getMedicalPoliciesByUserName(String userName)throws Exception;
	

}