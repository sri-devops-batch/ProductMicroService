package com.skj.gtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skj.gtest.entity.AppUser;

public interface IAppUserCustomRepository {

	public List<AppUser> getAllUsersByRole(String role)throws Exception;
	public AppUser getUsersByUsername(String username)throws Exception;

	@Query("from AppUser where userId >= :range1 and userId <= :range2")
	public List<AppUser> getUsersBetweenIds(@Param("range1") int range1,@Param("range2") int range2)throws Exception;

}