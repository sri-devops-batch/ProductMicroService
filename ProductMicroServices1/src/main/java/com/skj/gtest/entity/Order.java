package com.skj.gtest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	private String description;
	private int customerNumber;
	private String customerName;
	
	public Order(String description, int customerNumber, String customerName) {
		super();
		this.description = description;
		this.customerNumber = customerNumber;
		this.customerName = customerName;
	}
	
	
}
