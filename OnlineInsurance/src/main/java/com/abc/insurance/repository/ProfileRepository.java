package com.abc.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	
	
}
