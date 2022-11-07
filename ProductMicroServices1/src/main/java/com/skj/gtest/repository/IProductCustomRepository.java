package com.skj.gtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skj.gtest.entity.Product;

@Repository
public interface IProductCustomRepository {

	public Product getProductByProductCode(int productCode)throws Exception;
	public Product getProductByProductName(String productName)throws Exception;
	
	public List<Product> getProductByCategory(String category) throws Exception;
	
	@Query("from Product where category=:category and price>=:price1 and price<=:price2 and dealerName =:dealer")
	   public List<Product> getAllProductsByCategoryAndPriceRangeandDealerName(String category, int price1, int price2) throws Exception;
	public List<Product> getAllProductsByDealerName(String dealerName)throws Exception;
	@Query("from Product where category=:category and price>=:price and rating =:rating")
	  public List<Product> getAllProductsByCategoryAndPriceAndRating(String category, int price, float rating) throws Exception;
    
}
