package com.example.demo.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.example.demo.Model.Book;
import com.example.demo.Repository.Bookrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BookServiceImple implements BookService {
	@Autowired
	Bookrepository bookRepo;
	@Override
	public List<Book> getAll() {
		return bookRepo.findAll();
		
	}
	@Override
	public Book addBook(Book book) {
		return bookRepo.save(book);
		
	}
	@Override
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
		
	}
	@Override
	public Book editBook(Book book) {
		return bookRepo.save(book);
		
	}
	@Override
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
		
	}
	@Override
	public List<Book> getBooksByName(String booksName) {
		if(booksName != null) {
			return bookRepo.findBooksByName(booksName);
		}
		return bookRepo.findAll();	

	}
	
}
