package com.example.demo.Controller;

import com.example.demo.Model.LibraryCard;
import com.example.demo.Service.LibraryCardServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LibraryCardController {
	@Autowired
	private LibraryCardServiceImple libraryCardService;
	
	@GetMapping("/cards")
	public String cardsList(Model model) {
		model.addAttribute("cards", libraryCardService.getAllCard());
		return "LibraryCard/library_cards";
	}
	@GetMapping("/card/form")
	public String createCardForm(Model model) {
		LibraryCard libCard = new LibraryCard();
		model.addAttribute("card", libCard);
		return "LibraryCard/create_card";
	}
	@PostMapping("/cards")
	public String addCardToList(@ModelAttribute("card") LibraryCard newLibCard) {
		libraryCardService.addLibraryCard(newLibCard);
		return "redirect:/admin/cards";
	}
	@GetMapping("/card/editform/{id}")
	public String editCardForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("editCard", libraryCardService.getCardById(id));
		return "LibraryCard/edit_card";
	}
	@PostMapping("/card/result/{id}")
	public String updateCardData(@PathVariable("id") long id, @ModelAttribute("editCard") LibraryCard updateLibCard ) {
		LibraryCard existingLibCard = libraryCardService.getCardById(id);
		existingLibCard.setCardId(id);
		existingLibCard.setStartDate(updateLibCard.getStartDate());
		existingLibCard.setEndDate(updateLibCard.getEndDate());
		existingLibCard.setNote(updateLibCard.getNote());
		libraryCardService.editLibraryCard(existingLibCard);
		return "redirect:/admin/cards";
	}
	@GetMapping("card/deleted/{id}")
	public String deleteCardById(@PathVariable("id") long id) {
		libraryCardService.deleteCard(id);
		return "redirect:/admin/cards";
	}
}
