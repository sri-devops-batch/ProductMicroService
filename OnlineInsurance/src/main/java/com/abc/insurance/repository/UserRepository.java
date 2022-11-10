package com.abc.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>, IUserCustomRepository{
	


	
}
