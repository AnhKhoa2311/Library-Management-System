package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.LibraryCard;

public interface LibraryCardService {
	public List<LibraryCard> getAllCard();
	public LibraryCard addLibraryCard(LibraryCard libCard);
	public LibraryCard getCardById(long id);
	public LibraryCard editLibraryCard(LibraryCard libCard);
	public void deleteCard(long id);
	
}
