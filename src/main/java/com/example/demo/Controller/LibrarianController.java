package com.example.demo.Controller;

import com.example.demo.Model.Librarian;
import com.example.demo.Service.LibrarianServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class LibrarianController {
	@Autowired
	LibrarianServiceImple service;
	
	@GetMapping("/librarians")
	public String getAllLibrarians(Model model) {
		model.addAttribute("librarians", service.getAll());
		return "/Librarian/librarians";
	}
	@GetMapping("/addformlibrarian")
	public String addForm(Model model) {
		Librarian librarian = new Librarian();
		model.addAttribute("librarian", librarian);
		return "/Librarian/create_librarian";
	}
	@PostMapping("/librarians")
	public String postInfo(@ModelAttribute("librarian") Librarian librarian) {
		service.addLib(librarian);
		return "redirect:/admin/librarians";
	}
	@GetMapping("/editformlibrarian/{id}")
	public String editForm(@PathVariable int id, Model model) {
		Librarian editLib =service.getLibById(id);
		model.addAttribute("editLibResult", editLib);
		return "/Librarian/edit_librarian";
	}
	@PostMapping("/librarians/{librariansSearchName}")
	public String findLibrariansByName(@Param("librariansSearchName") String librariansSearchName, Model model) {
		model.addAttribute("librariansByName", service.findLibrariansByName(librariansSearchName));
		return "/Librarian/find_librarians";
	}
	@PostMapping("/librarian/{id}")
	public String updateLibrarian(@PathVariable int id, @ModelAttribute("editLibResult") Librarian lib) {
		Librarian existingLib = service.getLibById(id);
		existingLib.setId(id);
		existingLib.setName(lib.getName());
		existingLib.setPhoneNumber(lib.getPhoneNumber());
		existingLib.setAddress(lib.getAddress());
		existingLib.setDob(lib.getDob());
		existingLib.setEmail(lib.getEmail());
		existingLib.setGender(lib.getGender());
		
		service.editLibrarian(existingLib);
		return "redirect:/admin/librarians";
	}
	@GetMapping("/deletedlibrarian/{id}")
	public String deleteLibrarian(@PathVariable int id) {
		service.deleteLibrarian(id);
		return "redirect:/admin/librarians";
	}
}
