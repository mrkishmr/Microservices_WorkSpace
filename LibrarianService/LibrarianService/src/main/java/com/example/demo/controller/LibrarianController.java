package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Book;

@RestController
@RequestMapping("/librarianservice")
public class LibrarianController {

	@Autowired
	private RestTemplate restTemplate;
	
	@DeleteMapping("/deleteBookById/{id}")
	public String deleteBookById(@PathVariable Integer id)
	{
		restTemplate.delete("http://bookservice/bookService/deleteBookById/{id}",id);
		return "Removed Book Successfully";
	}
	@DeleteMapping("/deleteStudentById/{id}")
	public String deleteStudentById(@PathVariable Integer id)
	{
		restTemplate.delete("http://studentservice/studentservice/deletestudentbyid/{id}",id);
		return "Student Removed Successfully";
	}
	@PostMapping("/addBook")
	public String registerBook(@RequestBody Book book)
	{
		String result=restTemplate.postForObject("http://bookservice/bookService/addBook",book,String.class);
		return result;
	}
}
