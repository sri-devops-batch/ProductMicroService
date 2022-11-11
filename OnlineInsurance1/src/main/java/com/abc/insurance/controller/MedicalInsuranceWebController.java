package com.abc.insurance.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.service.MedicalInsuranceService;




@RestController
@RequestMapping("/medicalinsurance")
public class MedicalInsuranceWebController {
	
	@Autowired
	MedicalInsuranceService medicalInsuranceService;
	public  MedicalInsuranceWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}
	@GetMapping("/welcome")
	public String welcome()
	{
		
		return "Welcome to Medical Insurance";
		
	}
	
	
		
	@PostMapping("/add")
	public ResponseEntity<String> addMedicalInsurance(@RequestBody MedicalInsurance medicalInsurance) 
	{
		
		try {
			MedicalInsurance savedInsurance =   medicalInsuranceService.insertMedicalInsurance(medicalInsurance);
			String responseMsg = savedInsurance.getPartyName()+" save with token No "+savedInsurance.getTokenId();
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg =  "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/insurance")
	public List<MedicalInsurance> getAllInsurance()
	{
		// write some code to extract users
		try {
			List<MedicalInsurance>  allExtractedUsers = medicalInsuranceService.getAllMedicalInsurance();
			
			return allExtractedUsers;
			
		} catch (Exception e) {
			// code missing for expection handling 
			System.out.println(e);
			
		}
		
		return null;
	}
	@GetMapping("/sumInsured/{sumInsured}")
	public MedicalInsurance getMedicalInsuranceBySumInsured(int sumInsured)throws Exception
	{
		
		return medicalInsuranceService.getMedicalInsuranceBySumInsured(sumInsured);
		
	}
	
	@GetMapping("/premium/{premium}")
	public List< MedicalInsurance> getMedicalInsuranceByPremiumMedicalInsurances(int premium) throws Exception
	{
		
		return  medicalInsuranceService.getMedicalInsuranceByPremium(premium);
		
	}
	}

