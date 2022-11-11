package com.skj.gtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skj.gtest.entity.Student;

public interface IStudentCustomRepository {

	
	@Query("from Student where marks >= :range1 and marks<= :range2")
	public List<Student> getAllStudentsByMarks(@Param("range1") int range1,@Param("range2") int range2)throws Exception;
	
	@Query("from Student where studentId>= :s1 and studentId<= :s2")
	 public List<Student> getStudentsBetweenIds(int s1, int s2)throws Exception;
	
	
}
