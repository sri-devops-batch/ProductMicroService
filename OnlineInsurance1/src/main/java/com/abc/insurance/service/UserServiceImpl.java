package com.abc.insurance.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.Profile;
import com.abc.insurance.entity.User;
import com.abc.insurance.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() throws Exception {

		List<User> allUsers =  userRepository.findAll(); // Note : same as save
		return allUsers;
		// TODO Auto-generated method stub
	}
	@Override
	public User getUserByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.getUsersByUsername(username);
	}

	@Override
	public User getUserByUserNameAndRole(String userName, String role) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByRole(String role) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" ---->> Inside Servive Impl role "+role);
		return userRepository.getAllUsersByRole(role);
	}

	@Override
	public String insertUser(User user) throws Exception {
		User savedUser =  userRepository.save(user);  // Note :  save() is already implemented by Spring Data JPA
		if(savedUser != null)
		{
			System.out.println("2. Inside insert user serviceImpl  "+ savedUser);
			return " User Saved "+savedUser.getUserId()+" username :- "+savedUser.getUserName();
		}
		else return null;
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	public User linkProfile(Profile profile, User userName) {

		userName.setUserProfile(profile);
		return userName;

	}

	@Override
	public User getUserById(int searchedUserId) throws Exception {
		// TODO Auto-generated method stub
		 User outputUser = userRepository.getReferenceById(searchedUserId);
		 return outputUser;
	}

	
	

}