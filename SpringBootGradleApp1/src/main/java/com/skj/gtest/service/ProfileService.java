package com.skj.gtest.service;


import org.springframework.stereotype.Service;

import com.skj.gtest.entity.Profile;

@Service
public interface ProfileService {

	public Profile addProfile(Profile profile);
	
}