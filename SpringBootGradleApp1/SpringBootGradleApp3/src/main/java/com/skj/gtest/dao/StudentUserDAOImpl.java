package com.skj.gtest.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skj.gtest.entity.Student;
@Repository
public class StudentUserDAOImpl  implements StudentUserDAO {
	@Autowired
	StudentDatabase db;
	
	@Override
	public Student getStudentByStreamAndLocation(String searchname, String location) throws Exception {
		List<Student> allStudents= getAllStudents();
		
		 Student student = allStudents.stream().filter((u)->{
			if(u.getStudentName().equals(searchname) && u.getLocation().equals(location))
			{
				return true;
			}
			else return false;
		}).findFirst().get();
		 
		return student;
	}


	@Override
	public List<Student> getAllStudents() throws Exception {
		// TODO Auto-generated method stub
		return db.getAllStudents();
	}

	@Override
	public List<Student> getAllStudentsByStream() throws Exception {
		// TODO Auto-generated method stub
		return db.getStudentByStream;
	}


	@Override
	public List<Student> getStudentsBetweenIds(int s1, int s2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudentsByMarks(int r1, int r2) throws Exception {
		// TODO Auto-generated method stub
		return db.getAllStudentsByMarks;
	}
	@Override
	public String insertStudent(Student student) throws Exception {
		 List<Student> list =   db.getAllStudents();
		 list.add(student);
		 db.setAllStudents(list); // adding the new user in the previous list
		 return "done";
	}
	

	@Override
	public Student getStudentByName(String Name) throws Exception {
		List<Student> allStudents = getAllStudents();
		Student s=(Student) allStudents.stream().filter((u)->{
			if(u.getStudentName().equals(Name))
			{
				return true;
			}
			else return false;
		}).findFirst().get();

		return s;
		}
	

	
}






















