package com.skj.gtest.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skj.gtest.entity.Student;
@Service
public interface StudentUserService {
       public List<Student> getAllStudents() throws Exception;
       public List<Student> getAllStudentsByStream() throws Exception;
       public List<Student> getAllStudentsByMarks(int r1,int r2) throws Exception;
       public Student getStudentByName(String Name) throws Exception;
       
       public String insertStudent(Student student)throws Exception;
     public Student getStudentByStreamAndLocation(String searchname, String location) throws Exception;
	
	 public List<Student> getStudentsBetweenIds(int s1, int s2)throws Exception;
	
       


}
