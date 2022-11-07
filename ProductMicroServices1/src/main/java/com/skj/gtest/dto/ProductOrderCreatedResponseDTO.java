package com.skj.gtest.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductOrderCreatedResponseDTO {

	private String productname;
	private int productId;
	private String orderDescription;
	private String remarks;
	
}
