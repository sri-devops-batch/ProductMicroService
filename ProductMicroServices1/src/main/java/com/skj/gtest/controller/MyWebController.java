package com.skj.gtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.skj.gtest.entity.Product;
import com.skj.gtest.service.ProductUserService;



@RestController
@RequestMapping("/product")
public class MyWebController {

	@Autowired
	ProductUserService productService;
	
	
	
	public MyWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}

	@GetMapping("/welcome")
	public String abc()
	{
		return "Welcome to Facebook";
	}

	@GetMapping("/code/{productCode}")
	public Product abc3(@PathVariable int productCode)throws Exception
	{
		return productService.getProductByProductCode(productCode);
		
	}
	
	@GetMapping("/category/{Category}")
	public List<Product> abc4(@PathVariable String category)throws Exception
	{
		System.out.println(" --->> 1 Inside controller "+category);
		return productService.getProductByCategory(category);
		
	}

	@GetMapping("/name/{productName}")
	public Product abc2(@PathVariable String productName)throws Exception
	{
		return productService.getProductByProductName(productName);
		
	}
	@PostMapping("/product")
	public String product(@RequestBody Product product) 
	{
		/*
		 * // request body annotation  , help u 
		 * to take user information as JSON , so it convert JSON object to AppIser Object
		 * */
		try {
			return productService.insertProduct(product);
		} catch (Exception e) {
			return "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
		}
	}
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		try {
			List<Product> allExtractedProducts = productService.getAllProducts();
			return  allExtractedProducts ;
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return null;
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
