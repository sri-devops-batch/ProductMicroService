package com.skj.gtest.service;

import org.springframework.stereotype.Service;

import com.skj.gtest.entity.Post;

@Service
public interface PostService {
	public Post addPost(Post post);

}