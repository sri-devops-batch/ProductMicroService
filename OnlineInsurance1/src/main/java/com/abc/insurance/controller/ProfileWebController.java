package com.abc.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.entity.Profile;
import com.abc.insurance.entity.User;
import com.abc.insurance.service.ProfileService;
import com.abc.insurance.service.UserService;


@RestController
@RequestMapping("insurance/profile")
@Validated
public class ProfileWebController {

	@Autowired
	ProfileService profileService;

	@Autowired
	UserService userService;

	@PostMapping("/add") 
	public User doProfileThings(@RequestBody Profile profile,@RequestParam String userName)
	{
		User alreadySavedUser = null;
		try
		{
			Profile savedProfile = profileService.addProfile(profile);
			if(savedProfile.getProfileId() != 0)
			{
				alreadySavedUser = userService.getUserByUserName(userName);
				if(alreadySavedUser != null)
				{
					User profileAddUser = userService.linkProfile(savedProfile, alreadySavedUser);

					return profileAddUser;
				}
				else
				{
					throw new Exception("User not found ,  "+alreadySavedUser+" for "+userName);
				}

			}
		}
		catch (Exception e) {
			System.out.println(e);
			return alreadySavedUser;
		}

		return alreadySavedUser;

		// code to add the profile
	}

}