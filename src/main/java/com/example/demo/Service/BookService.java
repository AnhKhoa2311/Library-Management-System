package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Book;

import org.springframework.web.multipart.MultipartFile;

public interface BookService {
	public List<Book> getAll();
	public Book addBook(Book book);
	public Book getBookById(int id);
	public List<Book> getBooksByName(String booksName);
	public Book editBook(Book book);
	public void deleteBook(int id);
}
