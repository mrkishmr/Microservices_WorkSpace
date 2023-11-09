package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Book;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/studentservice")
public class StudentController {

	@Autowired
	private StudentService stuservice;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/registerstudent")
	public String registerStudent(@RequestBody Student student)
	{
		String email=student.getStudentEmail();
		String response=restTemplate.getForObject("http://emailservice/emailservice/sendOtp/"+email, String.class);
		System.out.println(response);
		return stuservice.addStudent(student);
	}
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks()
	{
		Book[] books=restTemplate.getForObject("http://bookservice/bookService/getAllBooks",Book[].class);
		List al=Arrays.asList(books);
		return al;
	}
	@DeleteMapping("/deletestudentbyid/{id}")
	public String deleteStudent(@PathVariable Integer id)
	{
		return stuservice.deleteStudentbyId(id);
	}
}
