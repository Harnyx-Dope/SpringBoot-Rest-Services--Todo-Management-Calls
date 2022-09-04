package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Student;
import com.example.demo.StudentRepostitory.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	StudentRepository repository;
	public boolean checkBookAlreayExist(int id)
	{ 
		 Optional<Student> libt= repository.findById(id);
		 if(libt.isPresent())
		return false;
		 else
			 return true;
		
		
	}
	
}
