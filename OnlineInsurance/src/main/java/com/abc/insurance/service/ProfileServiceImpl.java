package com.abc.insurance.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.Profile;
import com.abc.insurance.repository.ProfileRepository;

@Service
public class ProfileServiceImpl  implements ProfileService {


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
