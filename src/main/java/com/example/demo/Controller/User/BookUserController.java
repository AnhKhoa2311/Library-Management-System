package com.example.demo.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookServiceImple;

@Controller
public class BookUserController {
	@Autowired
	protected BookServiceImple booksServiceImple;
	@GetMapping("/details/{id}")
	public String detailsBook(@PathVariable("id") int id, Model model) {
		Book getBooks = booksServiceImple.getBookById(id);
		model.addAttribute("booksdetail", getBooks);
		return "UserFE/Book/books_detail";
	}
	@GetMapping("/confirmlibcard")
	public String confirmLibCardForm() {
		return "UserFE/ConfirmLibraryCard/confirm_libcard_form";
	}
}
