package com.example.demo.StudentRepostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;
 

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{

 
	 
}
