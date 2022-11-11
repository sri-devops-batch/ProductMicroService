package com.skj.gtest.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.skj.gtest.entity.AppUser;
import com.skj.gtest.entity.Post;
import com.skj.gtest.entity.Profile;
@Service
public interface AppUserService {
	public List<AppUser> getAllUsers()throws Exception;
	public List<AppUser> getAllUsers(String role)throws Exception;
	public AppUser getUserByUserName(String username)throws Exception;
	public List<AppUser> getUsersConnections(String username)throws Exception;
	public AppUser getUserByUserNameAndRole(String username,String role)throws Exception;
	public List<AppUser> getUsersByRole(String role)throws Exception;
	public List<AppUser> getUsersBetweenIds(int range1,int range2)throws Exception;

	public String insertUser(AppUser user)throws Exception;
	public AppUser addHobbies(List<String> allHobbies,AppUser appUser);
	public String insertUser1(AppUser user)throws Exception;
	public AppUser addPost(Post post,AppUser appUser);
	public AppUser getUserById(int searchedUserId)throws Exception;

	public AppUser linkProfile(Profile profile,AppUser appUser);
}