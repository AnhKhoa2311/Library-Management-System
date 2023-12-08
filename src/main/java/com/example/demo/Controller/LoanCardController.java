package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.LoanCard;
import com.example.demo.Service.LoanCardServiceImple;

@Controller
@RequestMapping("/admin")
public class LoanCardController {
	@Autowired
	protected LoanCardServiceImple loanCardService;
	@GetMapping("/loancards")
	public String allLoanCards(Model model) {
		model.addAttribute("loancards", loanCardService.allLoanCards());
		return "/LoanCard/loan_cards_information";
	}
	@PostMapping("/postloancards")
	@ResponseBody
	public String postLoanCards(@RequestBody LoanCard loanCard) {
		loanCardService.addLoanCards(loanCard);
		return loanCard + " " + "has been added!";
	}
}
