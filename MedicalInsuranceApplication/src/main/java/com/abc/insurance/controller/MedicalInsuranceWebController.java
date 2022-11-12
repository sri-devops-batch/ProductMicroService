package com.abc.insurance.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.dto.DefaultResponseDTO;
import com.abc.insurance.dto.MyDTO;
import com.abc.insurance.entity.MedicalInsurance;
import com.abc.insurance.service.MedicalInsuranceService;


@RestController
@RequestMapping("/insurance")
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
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
		
	@PostMapping("/addMedicalInsurance")
	public ResponseEntity<String> addHomeInsurance(@RequestBody MedicalInsurance medicalInsurance) 
	{
		
		try {
			System.out.println(" --- > "+mylogs);
			mylogs.info("---->>>Inside try of adding home insurance");
			MedicalInsurance savedInsurance =   medicalInsuranceService.insertMedicalInsurance(medicalInsurance);
			String responseMsg = savedInsurance.getInsuranceName()+  "   save with premium:   "+savedInsurance.getPremium();
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg =  " Please, Contact to customer care 1800-250-960 or mail us :- care@gmail.com";
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/viewMedicalInsurance")
	public List<MedicalInsurance> viewAllInsurance()
	{

		try {
			List<MedicalInsurance>  allExtractedInsurance =medicalInsuranceService.getAllMedicalInsurance();
			
			return allExtractedInsurance;
			
		} catch (Exception e) {
		
			System.out.println(e);
			
		}
		
		return null;
	}
	@GetMapping("/sumInsured/{sumInsured}")
	public MedicalInsurance getMedicalInsuranceBySumInsured(@PathVariable int sumInsured)throws Exception
	{
		
		return medicalInsuranceService.getMedicalInsuranceBySumInsured(sumInsured);
		
	}
	
	@GetMapping("/premium/{premium}")
	public List<MedicalInsurance> getMedicalInsuranceByPremiumamount(@PathVariable  int premium) throws Exception
	{
		
		return medicalInsuranceService.getMedicalInsuranceByPremium(premium);
		
	}
	
	
    @GetMapping("/insuranceName/{name}")
    public MedicalInsurance getMedicalInsuranceByInsuranceName(@PathVariable String insuranceName) throws Exception
    {
    	return medicalInsuranceService.getMedicalInsuranceByInsuranceName(insuranceName);
    }
    @PutMapping("/updateMedicalInsurance")
	public MedicalInsurance updateMedicalInsurance(@RequestBody MedicalInsurance medicalInsurance)throws Exception
	{
		
		return medicalInsuranceService.updateMedicalInsurance(medicalInsurance);
		
		
	}
    @DeleteMapping("/deleteMedicalInsurance")
    public String deleteInsurance(@RequestParam int mId) throws Exception
    {
    	medicalInsuranceService.deleteInsuranceByMId(mId);
    	return "Deleted id =" +mId+ "Data";
    }
    
}//end of class}//end of class