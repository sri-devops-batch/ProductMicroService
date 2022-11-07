package com.skj.gtest.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skj.gtest.dto.ErrorDTO;
import com.skj.gtest.dto.MyDTO;
import com.skj.gtest.dto.ProductOrderCreatedResponseDTO;
import com.skj.gtest.entity.Order;
import com.skj.gtest.entity.Product;
import com.skj.gtest.service.OrderService;
import com.skj.gtest.service.ProductUserService;
import com.skj.gtest.util.ProductUserDTOConvertor;

@RestController
@RequestMapping("/Orders")
public class OrderRestController {
	@Autowired
	OrderService orderService;

	@Autowired
	ProductUserService userService;


	@PostMapping("/product/{productname}/order/{description}")
	public ResponseEntity<MyDTO> addOrderByProduct(@PathVariable String productname,@PathVariable String description)
	{

		Product savedProduct = null; 
		try {
		    savedProduct = userService.getProductByProductName(productname);
			if( savedProduct != null)
			{
				Order order = new Order();
			    Order savedOrder = orderService.addOrder(order);

				if(savedOrder.getId() != 0)
				{
					// code to link post with user
					Product updatedProductWithOrder = userService.addOrder(savedOrder, savedProduct);

					ProductOrderCreatedResponseDTO dto = ProductUserDTOConvertor.getOrderCreatedDTO(updatedProductWithOrder,order);

					return new ResponseEntity<MyDTO>(HttpStatus.OK);
				}

			}
			else
			{
				throw new Exception("User not found "+savedProduct+" for "+productname);
			}

		} catch (Exception e) {
			System.out.println(savedProduct+" is not");

			ErrorDTO errorDto = new ErrorDTO(e.getMessage());
			return new ResponseEntity<MyDTO>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);

		}



		return null;

	}
}

