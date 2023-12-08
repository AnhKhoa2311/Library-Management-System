package com.example.demo.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;
import com.example.demo.Service.BookServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Path;

@Controller
@RequestMapping("/admin")
public class BookController {
//	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	protected BookServiceImple service;
	@GetMapping("/books")
	public String getAllBooks(Model model) {
		model.addAttribute("books", service.getAll());
		return "/Book/book";
	}
	@GetMapping("/addform")
	public String createBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "/Book/create_book";
	}
	@PostMapping("/books")
	public String addBook(@ModelAttribute("book") Book book) {
		service.addBook(book);
		return "redirect:/admin/books";
	}
	
	@PostMapping("/books/{booksName}")
	public String findBooksByName(@Param("booksName") String booksName, Model model) {
//		Book book = new Book(booksName);
		model.addAttribute("booksByName", service.getBooksByName(booksName));
		return "/Book/find_books";
	}
	@GetMapping("/editform/{id}")
	public String editForm(@PathVariable int id, Model model) {
		model.addAttribute("editBook", service.getBookById(id));
		return "/Book/edit_book";
	}
	@PostMapping("/{id}")
	public String updateBook(@ModelAttribute("editBook") Book book, @PathVariable int id) {
		Book existingBook = service.getBookById(id);
		existingBook.setId(id);
		existingBook.setBooksImg(book.getBooksImg());
		existingBook.setBooksName(book.getBooksName());
		existingBook.setBookSeriesName(book.getBookSeriesName());
		existingBook.setEpisode(book.getEpisode());
		existingBook.setType(book.getType());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setPublishCompany(book.getPublishCompany());
		
		service.editBook(existingBook);
		return "redirect:/admin/books";
	}
	@GetMapping("/deleted/{id}")
	public String deleteBookById(@PathVariable int id) {
		service.deleteBook(id);
		return "redirect:/admin/books";
	}
}
