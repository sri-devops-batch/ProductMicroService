package com.skj.gtest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FBPost")
public class Post {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int postid;
	private String description;
	private String date;
	private int likes;
	private int dislikes;

	public Post(String description, String date, int likes, int dislikes) {
		super();
		this.description = description;
		this.date = date;
		this.likes = likes;
		this.dislikes = dislikes;
	}


}