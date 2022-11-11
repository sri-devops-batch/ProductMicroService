package com.skj.gtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skj.gtest.dao.StudentUserDAO;
import com.skj.gtest.entity.Student;
import com.skj.gtest.repository.StudentRepository;
@Service
public class StudentUserServiceImpl implements StudentUserService {

	@Autowired
	    StudentRepository studentrepo;

	
	@Override
	public String insertStudent(Student student) throws Exception {
		Student savedstudent =  studentrepo.save(student);  // Note :  save() is already implemented by Spring Data JPA
		if(savedstudent != null)
		{
			return "App User Saved "+savedstudent.getStudentId()+" username :- "+savedstudent.getStudentName();
		}
		else return null;
	}
	
	@Override
	public List<Student> getAllStudents()  throws Exception  {

		// may contains other code like security , loggging , validation 
		
		List<Student> allStudents =  studentrepo.findAll(); // Note : same as save
		return allStudents;
	}
	

	@Override
	public List<Student> getAllStudentsByStream() throws Exception {

		List<Student> allStudents =  studentrepo.findAll(); // Note : same as save
		return getAllStudentsByStream()  ;
	}
	
	@Override
	public List<Student> getAllStudentsByMarks(int ranger1, int ranger2)  throws Exception{
		
		return studentrepo.getAllStudentsByMarks(ranger1, ranger2);
	}

	@Override
	public List<Student> getStudentsBetweenIds(int s1, int s2) throws Exception {
		// TODO Auto-generated method stub
		return studentrepo.getStudentsBetweenIds(s1, s2);
	}

	
	@Override
	public Student getStudentByName(String Name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentByStreamAndLocation(String searchname, String location) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	}
	 

