package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public String addStudent(Student student)
	{
		Student stu=studentRepo.save(student);
		if(stu!=null)
		{
			return "Registered Successfully";
		}
		return "Something went wrong";
	}
	public String deleteStudentbyId(int id)
	{
		studentRepo.deleteById(id);
		return "deleted succesfully";
	}
}
