package com.skj.gtest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skj.gtest.entity.Student;
@Component
public class StudentDatabase {
	

	public List<Student> allStudents = new ArrayList<>();
	public List<Student> getAllStudentsByMarks = new ArrayList<>();
	public List<Student> getStudentByStream = new ArrayList<>();
	

	 StudentDatabase() {

		 System.out.println(" inside Student database");
		 
		 Student s1= new Student("Deva","Bsc","Banglore",98);
		 Student s2= new Student("Rani", "BBA","chennai",76);
		 Student s3= new Student("Thanu","Bcom","Hyderabad",50);
		 
		 allStudents.add(s1);
		 allStudents.add(s2);
		 allStudents.add(s3);
		 
		 
	 }


	public List<Student> getAllStudents() {
		return allStudents;
	}


	public void setAllStudents(List<Student> allStudents) {
		this.allStudents = allStudents;
	}


	

	
}