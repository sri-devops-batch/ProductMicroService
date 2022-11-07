package com.skj.gtest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProductInfo")
public class ProductInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ProductId;
	
   private String countryOfOrigin;
   private int manufacturingDate;
   private int certificateNumber;
   private int weight;
   private String color;
   
   public ProductInfo(String countryOfOrigin, int manufacturingDate, int certificateNumber, int weight, String color) {
	super();
	this.countryOfOrigin = countryOfOrigin;
	this.manufacturingDate = manufacturingDate;
	this.certificateNumber = certificateNumber;
	this.weight = weight;
	this.color = color;
}
   
   
}
