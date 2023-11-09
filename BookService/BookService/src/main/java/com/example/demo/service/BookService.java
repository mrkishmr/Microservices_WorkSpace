package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public String addBook(Book book)
	{
		Book book1=bookRepo.save(book);
		if(book1!=null)
		{
			return "Registered book successfully";
		}
		return "something went wrong";
	}
	public String deleteBook(Book book)
	{
		try
		{
		bookRepo.delete(book);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "Deleted successfully";
	}
	public List<Book> getAllBooks()
	{
		List<Book> books=bookRepo.findAll();
		return books;
	}
	public String removeBookById(int id)
	{
		bookRepo.deleteById(id);
		return "deleted successfully";
	}
}
