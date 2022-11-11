package com.skj.gtest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skj.gtest.entity.Post;
import com.skj.gtest.repository.PostRepository;
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;

	@Override
	public Post addPost(Post post) {

		Post savedPost = postRepository.save(post);
		return savedPost;
	}

}