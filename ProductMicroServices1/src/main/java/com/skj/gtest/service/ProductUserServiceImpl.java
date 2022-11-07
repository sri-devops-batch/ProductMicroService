package com.skj.gtest.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skj.gtest.entity.Order;
import com.skj.gtest.entity.Product;
import com.skj.gtest.entity.ProductInfo;
import com.skj.gtest.repository.ProductRepository;

@Service
public class ProductUserServiceImpl implements ProductUserService {
	@Autowired
	ProductRepository productRepository;

	@Override
	@Transactional
	public String insertProduct(Product product) throws Exception {
		Product savedproduct =  productRepository.save(product);  // Note :  save() is already implemented by Spring Data JPA
		if(savedproduct != null)
		{
			return "App User Saved "+savedproduct.getProductCode()+" productName:- "+savedproduct.getProductName();
		}
		else return null;
	}

	@Override
	public List<Product> getAllProducts() throws Exception {

		List<Product> allProducts=  productRepository.findAll(); // Note : same as save
		return allProducts;
	}

	@Override
	public Product getProductByProductCode(int productCode) throws Exception {
		
		return productRepository.getProductByProductCode(productCode);
	}

	@Override
	public Product getProductByProductName(String productName) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getProductByProductName(productName);
	}

	@Override
	public List<Product> getProductByCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getProductByCategory(category);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPriceRangeandDealerName(String category, int price1, int price2,
			String dealerName) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getAllProductsByCategoryAndPriceRangeandDealerName(category,price1,price2);
	}

	@Override
	public List<Product> getAllProductsByDealerName(String dealerName) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getAllProductsByDealerName(dealerName);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPriceAndRating(String category, int price, float rating)
			throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getAllProductsByCategoryAndPriceAndRating(category,price,rating);
	}

	@Override
	@Transactional
	public Product linkProductInfo(ProductInfo savedProductInfo, Product alreadySavedProduct) {
		alreadySavedProduct.setUserProductInfo(savedProductInfo);
		return alreadySavedProduct;
	}

	@Override
	public Product addOrder(Order savedOrder, Product savedProduct) {
	
		List<Order> allOrders =savedProduct.getAllOrders();

		if(allOrders == null)
		{
			allOrders = new ArrayList<>();
			allOrders.add(savedOrder);
		}
		else
		{
			allOrders.add(savedOrder);
		}

		savedProduct.setAllOrders(allOrders);


		return savedProduct;
	}
	}

