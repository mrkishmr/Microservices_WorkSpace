package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/bookService")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public String registerBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
	@DeleteMapping("/deleteBook")
	public String removeBook(@RequestBody Book book )
	{
		return bookService.deleteBook(book);
	}
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks()
	{
		return bookService.getAllBooks();
	}
	@DeleteMapping("/deleteBookById/{id}")
	public String removeBookById(@PathVariable Integer id)
	{
		return bookService.removeBookById(id);
	}
}
