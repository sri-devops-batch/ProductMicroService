package com.skj.gtest.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.skj.gtest.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>,IStudentCustomRepository{

	
}
