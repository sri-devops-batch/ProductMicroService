package com.skj.gtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skj.gtest.entity.Order;
import com.skj.gtest.entity.Product;
import com.skj.gtest.entity.ProductInfo;

@Service
public interface ProductUserService {
	
	   public String insertProduct(Product product)throws Exception;
	   public List<Product> getAllProducts() throws Exception;
	   public Product getProductByProductCode(int productCode) throws Exception;
	   public Product getProductByProductName(String productName) throws Exception;
       public List<Product> getProductByCategory(String category) throws Exception;
	   public List<Product> getAllProductsByCategoryAndPriceRangeandDealerName(String category,int price1,int price2,String dealerName) throws Exception;
       
       public List<Product> getAllProductsByDealerName(String dealerName)throws Exception;
       public List<Product> getAllProductsByCategoryAndPriceAndRating(String category,int price,float rating) throws Exception;
       
	  public Product linkProductInfo(ProductInfo savedProductInfo, Product alreadySavedProduct);
	  public Product addOrder(Order savedOrder, Product savedProduct);
     
       
      

	



}
