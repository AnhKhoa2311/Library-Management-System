package com.example.demo.Controller;

import com.example.demo.Service.BookServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class index {
	@Autowired
	protected BookServiceImple service;
	
	@GetMapping("/admin")
	public String index(Model model) {
		model.addAttribute("getbooks", service.getAll());
		return "Dashboard/dashboard";
	}
	
}
