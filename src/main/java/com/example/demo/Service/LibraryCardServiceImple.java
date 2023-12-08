package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.LibraryCard;
import com.example.demo.Repository.LibraryCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryCardServiceImple implements LibraryCardService{
	@Autowired
	private LibraryCardRepository libraryCardRepo;
	@Override
	public List<LibraryCard> getAllCard() {
		// TODO Auto-generated method stub
		return libraryCardRepo.findAll();
	}
	@Override
	public LibraryCard addLibraryCard(LibraryCard libCard) {
		// TODO Auto-generated method stub
		return libraryCardRepo.save(libCard);
	}
	@Override
	public LibraryCard getCardById(long id) {
		// TODO Auto-generated method stub
		return libraryCardRepo.findById(id).get();
	}
	@Override
	public void deleteCard(long id) {
		// TODO Auto-generated method stub
		 libraryCardRepo.deleteById(id);
	}
	@Override
	public LibraryCard editLibraryCard(LibraryCard libCard) {
		// TODO Auto-generated method stub
		return libraryCardRepo.save(libCard);
	}

}
