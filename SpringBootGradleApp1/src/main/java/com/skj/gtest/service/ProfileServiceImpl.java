package com.skj.gtest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skj.gtest.entity.Profile;
import com.skj.gtest.repository.ProfileRepository;

@Service
public class ProfileServiceImpl  implements ProfileService{

	@Autowired
	ProfileRepository profileRepository;

	@Override
	@Transactional
	public Profile addProfile(Profile profile) {
		// TODO Auto-generated method stub
		Profile savedProfile = profileRepository.save(profile);

		return savedProfile;

	}


}