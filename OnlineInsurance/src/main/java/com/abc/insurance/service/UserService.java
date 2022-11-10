package com.abc.insurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.insurance.entity.Profile;
import com.abc.insurance.entity.User;
@Service
public interface UserService {

	public String insertUser(User user)throws Exception;

	public List<User> getUsersByRole(String role) throws Exception;

	public User getUserByUserName(String searchUsername)throws Exception;

	public User getUserByUserNameAndRole(String searchUsername, String role)throws Exception;

	public User linkProfile(Profile savedProfile, User alreadySavedUser)throws Exception;

	public User getUserById(int searchedUserId) throws Exception;

	public List<User> getAllUsers() throws Exception;



	

}
