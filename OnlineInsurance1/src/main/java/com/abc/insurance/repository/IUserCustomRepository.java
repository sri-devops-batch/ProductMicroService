package com.abc.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.User;


@Repository
public interface IUserCustomRepository {

	public List<User> getAllUsersByRole(String role)throws Exception;
	public User getUsersByUsername(String userName)throws Exception;

	
}