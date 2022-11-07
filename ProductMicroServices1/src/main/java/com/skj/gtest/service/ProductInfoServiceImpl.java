package com.skj.gtest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skj.gtest.entity.ProductInfo;
import com.skj.gtest.repository.ProductInfoRepository;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	ProductInfoRepository productInfo;

	@Override
	@Transactional
	public ProductInfo addProductInfo(ProductInfo product) {
		
	    ProductInfo savedProductInfo=productInfo.save(product);
		return savedProductInfo;
	}
	
	
}
