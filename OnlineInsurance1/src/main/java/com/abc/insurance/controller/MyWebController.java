package com.abc.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.entity.User;
import com.abc.insurance.service.UserService;

@RestController
@RequestMapping("/insurance")
public class MyWebController {

	@Autowired
     UserService userService;



	public MyWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}


	@PostMapping("/user")
	public String addUser(@RequestBody User user) 
	{
		System.out.println("1. Inside webcontroller adduser");
		try {
			String abc= userService.insertUser(user);
			System.out.println("3. abc "+ abc);
			return abc;
		} catch (Exception e) {
			return "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
		}
	}


	@GetMapping("/welcome")
	public String abc()
	{
		return "Welcome to Facebook";
	}



	// http://localhost:8001/insurance/userandrole/ramesh
		@GetMapping("/roles/{role}")
		public List<User> abc(@PathVariable String role)throws Exception
		{
			System.out.println(" --->> 1 Inside controller "+role);
			return userService.getUsersByRole(role);
		}

	// http://localhost:8002/insurance/userandrole/ramesh
	@GetMapping("/user/{searchUsername}")
	public User abc2(@PathVariable String searchUsername)throws Exception
	{
		return userService.getUserByUserName(searchUsername);
	}

	// http://localhost:8002/insurance/userandrole/ramesh?role=user
	@GetMapping("/userandrole/{searchUsername}")
	public User abc3(@PathVariable String searchUsername,@RequestParam String role)throws Exception
	{
		if(role != null)
		{
			return userService.getUserByUserNameAndRole(searchUsername,role);
		}
		else return null;

	}





	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		// write some code to extract users
		try {
			List<User>  allExtractedUsers = userService.getAllUsers();

			return allExtractedUsers;

		} catch (Exception e) {
			// code missing for expection handling 
			System.out.println(e);

		}

		return null;
	}




}