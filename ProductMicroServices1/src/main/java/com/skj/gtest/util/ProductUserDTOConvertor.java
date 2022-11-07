package com.skj.gtest.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.skj.gtest.dto.ProductDefaultResponseDTO;
import com.skj.gtest.dto.ProductOrderCreatedResponseDTO;

import com.skj.gtest.entity.Order;

import com.skj.gtest.entity.Product;
@Component
@Scope("singleton")
public class ProductUserDTOConvertor {
	public static ProductDefaultResponseDTO  getProductDefaultDTO(Product product)
	{
	ProductDefaultResponseDTO dto = new ProductDefaultResponseDTO(
			  product.getProductName(), 
              product.getProductCode(), 
              product.getUserProductInfo().getColor(),
               "Product ProductInfo Created , ProductInfo Id : "+product.getUserProductInfo().getProductId());

	return dto;
		}
	public static ProductOrderCreatedResponseDTO getOrderCreatedDTO(Product updatedProductWithOrder, Order order) {
		// TODO Auto-generated method stub
	{
		ProductOrderCreatedResponseDTO dto = new ProductOrderCreatedResponseDTO(
				 updatedProductWithOrder.getDealerName(), 
				 updatedProductWithOrder.getPrice(), 
                 order.getDescription(),
                 "Post Added "+order.getCustomerName());
		return dto;
	}
	}
}

	
                
		
		
	

