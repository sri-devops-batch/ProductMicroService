package com.skj.gtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skj.gtest.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}