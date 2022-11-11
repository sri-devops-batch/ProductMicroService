package com.skj.gtest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	private String studentName;
	private String Stream;
	private String location;
	private int Marks;
	public Student(String studentName, String stream, String location, int marks) {
		super();
		this.studentName = studentName;
		Stream = stream;
		this.location = location;
		Marks = marks;
	}
	
	
	}
	
	
	
	
	
