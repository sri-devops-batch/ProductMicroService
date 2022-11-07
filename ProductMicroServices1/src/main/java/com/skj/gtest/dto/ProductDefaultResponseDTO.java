package com.skj.gtest.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDefaultResponseDTO implements MyDTO {


	private String productname;
	private int productId;
	private String registeredEmail;
	private String remarks;
}