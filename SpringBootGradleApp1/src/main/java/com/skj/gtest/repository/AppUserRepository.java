package com.skj.gtest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skj.gtest.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> ,IAppUserCustomRepository
{
    //no code
}