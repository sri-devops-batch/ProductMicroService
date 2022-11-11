package com.skj.gtest.dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skj.gtest.entity.AppUser;
@Component
public class UserDatabase {

	public List<AppUser> allUsers = new ArrayList<>();

	 UserDatabase() {

		 System.out.println(" inside user database");

		AppUser user1 = new AppUser("ramesh", "a", "user");
		AppUser user2 = new AppUser("suresh", "a", "user");
		AppUser user3 = new AppUser("mahesh", "a", "admin");
		AppUser user4 = new AppUser("rakesh", "a", "admin");


		allUsers.add(user1);
		allUsers.add(user2);
		allUsers.add(user3);
		allUsers.add(user4);


	}

	public List<AppUser> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<AppUser> allUsers) {
		this.allUsers = allUsers;
	}



}