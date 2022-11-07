package com.skj.gtest.service;

import org.springframework.stereotype.Service;

import com.skj.gtest.entity.ProductInfo;
@Service
public interface ProductInfoService {
	
   public ProductInfo addProductInfo(ProductInfo product);
}
