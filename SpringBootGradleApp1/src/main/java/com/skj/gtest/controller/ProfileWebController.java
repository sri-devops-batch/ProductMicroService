package com.skj.gtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skj.gtest.entity.AppUser;
import com.skj.gtest.entity.Profile;
import com.skj.gtest.service.AppUserService;
import com.skj.gtest.service.ProfileService;


@RestController
@RequestMapping("fb/profile")
@Validated
public class ProfileWebController {

	@Autowired
	ProfileService profileService;

	@Autowired
	AppUserService userService;

	@PostMapping("/add")  // ....../fbusers/profile/add?username=mike
	public AppUser doProfileThings(@RequestBody Profile profile,@RequestParam String username)
	{
		AppUser alreadySavedUser = null;
		try
		{
			Profile savedProfile = profileService.addProfile(profile);
			if(savedProfile.getProfileId() != 0)
			{
				alreadySavedUser = userService.getUserByUserName(username);
				if(alreadySavedUser != null)
				{
					AppUser profileAddUser = userService.linkProfile(savedProfile, alreadySavedUser);

					return profileAddUser;
				}
				else
				{
					throw new Exception("User not found ,  "+alreadySavedUser+" for "+username);
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