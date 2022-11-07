package com.skj.gtest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productCode;
	
	private String category;
	private String productName;
	private int price;
	private String dealerName;
	private float userRating;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProductInfo")
	private ProductInfo userProductInfo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ProductOrder")
	private List<Order> allOrders;



	
	public Product(String category, String productName, int price, String dealerName, float userRating) {
		super();
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.dealerName = dealerName;
		this.userRating = userRating;
	}


	
	
}
	
	
	
	
	


