package com.skj.gtest.controller;
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


import com.skj.gtest.dto.MyDTO;
import com.skj.gtest.dto.UserDefaultResponseDTO;
import com.skj.gtest.entity.AppUser;
import com.skj.gtest.service.AppUserService;
import com.skj.gtest.util.UserDTOConvertor;

@RestController
@RequestMapping("/facebook")
public class MyWebController {

	@Autowired
	AppUserService userService;



	public MyWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}


	@PostMapping("/user")
	public String addUser(@RequestBody AppUser user) 
	{
		/*
		 * // request body annotation  , help u 
		 * to take user information as JSON , so it convert JSON object to AppIser Object
		 * */
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



	// http://localhost:8001/facebook/userandrole/ramesh
		@GetMapping("/roles/{role}")
		public List<AppUser> abc(@PathVariable String role)throws Exception
		{
			System.out.println(" --->> 1 Inside controller "+role);
			return userService.getUsersByRole(role);
		}


		@GetMapping("/usersbyId")
		public List<AppUser> usersById(@RequestParam int r1 , @RequestParam int r2)throws Exception
		{

			return userService.getUsersBetweenIds(r1, r2);
		}	




	// http://localhost:8001/facebook/userandrole/ramesh
	@GetMapping("/user/{searchUsername}")
	public AppUser abc2(@PathVariable String searchUsername)throws Exception
	{
		return userService.getUserByUserName(searchUsername);
	}

	// http://localhost:8001/facebook/userandrole/ramesh?role=user
	@GetMapping("/userandrole/{searchUsername}")
	public AppUser abc3(@PathVariable String searchUsername,@RequestParam String role)throws Exception
	{
		if(role != null)
		{
			return userService.getUserByUserNameAndRole(searchUsername,role);
		}
		else return null;

	}





	@GetMapping("/users")
	public List<AppUser> getAllUsers()
	{
		// write some code to extract users
		try {
			List<AppUser>  allExtractedUsers = userService.getAllUsers();

			return allExtractedUsers;

		} catch (Exception e) {
			// code missing for expection handling 
			System.out.println(e);

		}

		return null;
	}



	@GetMapping("/user/id/{id}")
	public ResponseEntity<MyDTO> getUserByUserId(@PathVariable int id)throws Exception
	{

			AppUser user = userService.getUserById(id);

			UserDefaultResponseDTO dtoResp = UserDTOConvertor.getUserDefaultDTO(user);

			return new ResponseEntity<MyDTO>(dtoResp, HttpStatus.OK);

	}

}

