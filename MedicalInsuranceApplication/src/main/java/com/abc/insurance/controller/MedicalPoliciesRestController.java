package com.abc.insurance.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.dto.DefaultResponseDTO;
import com.abc.insurance.dto.ErrorDTO;
import com.abc.insurance.dto.MyDTO;
import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.entity.MedicalPolicies;
import com.abc.insurance.service.MedicalInsuranceService;
import com.abc.insurance.service.MedicalPoliciesService;
import com.abc.insurance.util.MedicalInsuranceDTOConvertor;


import lombok.Value;

@RestController
@RequestMapping("/policy/client/medicalPolicies")
@Validated
public class MedicalPoliciesRestController {
	@Autowired
	MedicalPoliciesService medicalPoliciesService;
	
	@Autowired
	MedicalInsuranceService medicalInsuranceService;
	
	@Autowired
	MedicalInsuranceDTOConvertor dtoConvertor;
	
   private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	
	@PostMapping("/addpolicies")  // ....../localhost:8003/policy/client/medicalPolicies/addpolicies?insuranceName=family Insurance
	public ResponseEntity<MyDTO> doMedicalPoliciesThings(@RequestBody @Valid MedicalPolicies medicalPolicies,@RequestParam String insuranceName)
	{
		MedicalInsurance alreadySavedInsurance = null;
		try
		{
			System.out.println(" --- > "+mylogs);
			mylogs.info("---->>>Inside try of doMedicalPolicies Things");
		MedicalPolicies  savedPolicy = medicalPoliciesService.addMedicalPolicies(medicalPolicies);
			if(savedPolicy .getMedicalPolicyId()!= 0)
			{
				mylogs.info("---->>>Inside if get medical policy");
				alreadySavedInsurance  = medicalInsuranceService.getMedicalInsuranceByInsuranceName(insuranceName);
				if(alreadySavedInsurance!= null)
				{ 
					mylogs.info("---->>>Inside if alreadySavedInsurance not equal to null");
					MedicalInsurance medicalPolicyAddInsurance = medicalInsuranceService.linkMedicalPolicy(medicalPolicies, alreadySavedInsurance);
					
					DefaultResponseDTO dtoResponse = dtoConvertor.getMedicalInsuranceDefaultDTO(alreadySavedInsurance);
					
					return new ResponseEntity<>(HttpStatus.OK);
					
				}
				else
				{
					mylogs.error("Insurance not found in post mapping uri : add");
					throw new Exception("Insurance not found ,  "+alreadySavedInsurance+" for "+insuranceName);
					//"errorMsg": "Insurance not found ,  null for Fire Insurance"
				}
				
			}
		}
		catch (Exception e) {
			System.out.println(e);
			ErrorDTO errorDTo = new ErrorDTO(e.getMessage());
			return new ResponseEntity<>(errorDTo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return null;
		
	
	}

	@GetMapping("/policiesByPolicyNo")
	public List<MedicalPolicies> policiesBetweenPolicyNumber(@RequestParam int r1 , @RequestParam int r2)throws Exception
	{
		
		return medicalPoliciesService.getMedicalPoliciesBetweenPolicyNumber(r1, r2);
	}	
	
	@GetMapping("/policies/{searchuserName}")
	public MedicalPolicies getByClientName(@PathVariable String userName)throws Exception
	{
		return medicalPoliciesService.getMedicalPoliciesByUserName(userName);
	}
	@GetMapping("/isClaimed/{claimedDate}")
	public List<MedicalPolicies> getPoliciesOnClaimedDate(@PathVariable String isClaimed,@RequestParam String claimedDate)throws Exception
	{
		if(claimedDate != null)
		{
			return medicalPoliciesService.getMedicalPoliciesBasedOnisClaimedDate(isClaimed, claimedDate);
		}
		else return null;
	}
	
	
}