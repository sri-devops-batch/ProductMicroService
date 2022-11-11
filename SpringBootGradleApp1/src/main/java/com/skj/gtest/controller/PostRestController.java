package com.skj.gtest.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skj.gtest.dto.ErrorDTO;
import com.skj.gtest.dto.MyDTO;
import com.skj.gtest.dto.UserDefaultResponseDTO;
import com.skj.gtest.dto.UserPostCreatedResponseDTO;
import com.skj.gtest.entity.AppUser;
import com.skj.gtest.entity.Post;
import com.skj.gtest.service.AppUserService;
import com.skj.gtest.service.PostService;
import com.skj.gtest.util.UserDTOConvertor;

@RestController
@RequestMapping("/fb/post")
public class PostRestController {

	@Autowired
	PostService postService;

	@Autowired
	AppUserService userService;


	@PostMapping("/user/{username}/post/{description}")
	public ResponseEntity<MyDTO> addPostByUser(@PathVariable String username,@PathVariable String description)
	{

		AppUser savedUser = null; 
		try {
		    savedUser = userService.getUserByUserName(username);
			if(savedUser != null)
			{
				Post post = new Post(description, LocalDate.now().toString(), 0, 0);
				Post savedPost = postService.addPost(post);

				if(savedPost.getPostid() != 0)
				{
					// code to link post with user
					AppUser updatedUserWithPost = userService.addPost(savedPost, savedUser);

					UserPostCreatedResponseDTO dto = UserDTOConvertor.getPostCreatedDTO(updatedUserWithPost,post);

					return new ResponseEntity<MyDTO>(dto, HttpStatus.OK);
				}

			}
			else
			{
				throw new Exception("User not found "+savedUser+" for "+username);
			}

		} catch (Exception e) {
			System.out.println(savedUser+" is not");

			ErrorDTO errorDto = new ErrorDTO(e.getMessage());
			return new ResponseEntity<MyDTO>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);

		}



		return null;

	}
}