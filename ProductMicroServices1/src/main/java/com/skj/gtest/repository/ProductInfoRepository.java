package com.skj.gtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skj.gtest.entity.ProductInfo;
@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo,Integer>{

	
}
