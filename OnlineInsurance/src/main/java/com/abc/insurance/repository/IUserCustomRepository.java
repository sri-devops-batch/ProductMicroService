package com.abc.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.insurance.entity.User;



public interface IUserCustomRepository {

	public List<User> getAllUsersByRole(String role)throws Exception;
	public User getUsersByUsername(String username)throws Exception;

	@Query("from AppUser where userId >= :range1 and userId <= :range2")
	public List<User> getUsersBetweenIds(@Param("range1") int range1,@Param("range2") int range2)throws Exception;

}
