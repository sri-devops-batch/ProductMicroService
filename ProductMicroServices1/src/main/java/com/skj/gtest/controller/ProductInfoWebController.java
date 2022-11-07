package com.skj.gtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skj.gtest.entity.Product;
import com.skj.gtest.entity.ProductInfo;
import com.skj.gtest.service.ProductInfoService;
import com.skj.gtest.service.ProductUserService;

@RestController
@RequestMapping("/pro")
public class ProductInfoWebController {
	@Autowired
	ProductInfoService productinfoService;
	
	@Autowired
	ProductUserService userService;
	
	@PostMapping("/productInfo")// ....../product/productInfo/add?productName=dal
	public Product doProductInfoThings(@RequestBody ProductInfo productInfo,@RequestParam String productName)
	{
		Product alreadySavedProduct =null;
		try {
			ProductInfo savedProductInfo =productinfoService.addProductInfo(productInfo);
			if(savedProductInfo.getProductId()!=0)
			{
				alreadySavedProduct = userService.getProductByProductName(productName);
				if(alreadySavedProduct!=null)
				{
					Product ProductInfoAddUser = userService.linkProductInfo(savedProductInfo,alreadySavedProduct);
					
					return ProductInfoAddUser;
				}
				else 
				{
					throw new Exception("Product info not found ,"+alreadySavedProduct+" for "+productName);
				}
			}
		}
	catch(Exception e) {
		System.out.println(e);
		return alreadySavedProduct;
		
	}
		return alreadySavedProduct;
}
}