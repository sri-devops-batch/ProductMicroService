package com.skj.gtest.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skj.gtest.entity.Student;
import com.skj.gtest.service.StudentUserService;

@RestController
@RequestMapping("/college")
public class MyWebController {

	@Autowired
	StudentUserService studentService;
	
	
	public MyWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}
	@PostMapping("/student")
	public String Student(@RequestBody Student student) 
	{
		/*
		 * // request body annotation  , help u 
		 * to take user information as JSON , so it convert JSON object to AppIser Object
		 * */
		try {
			return studentService.insertStudent(student);
		} catch (Exception e) {
			return "Contact to principle care 1800-250-960 or mail us :- vijayam@123.com"+e;
		}
	}
	
	@GetMapping("/location/{searchlocation}")
	public Student abc2(@PathVariable String searchname,@RequestParam String location)throws Exception
	{
		if(location !=null) {
			return studentService.getStudentByStreamAndLocation(searchname,location);
			
		}
		else return null;
	}
	@GetMapping("/studentsbyId")
	public List<Student> getStudentsBetweenIds(@RequestParam int s1 , @RequestParam int s2)throws Exception
	{
		
		return studentService.getStudentsBetweenIds(s1, s2);
	}

	
	
	@GetMapping("/name/{searchname}")
	public Student abc3(@PathVariable String searchname)throws Exception
	{
		return studentService.getStudentByName(searchname);
		
	}

	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		// write some code to extract users
		try {
			List<Student>  allExtractedStudents = studentService.getAllStudents();
			
			return allExtractedStudents;
			
		} catch (Exception e) {
			// code missing for expection handling 
			System.out.println(e);
			
		}
		return null;
		
		
	}
	

	
		
	}