package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Librarian;

public interface LibrarianService {
	public List<Librarian> getAll();
	public Librarian addLib(Librarian lib);
	public Librarian getLibById(int id);
	public List<Librarian> findLibrariansByName(String librariansSearchName);
	public Librarian editLibrarian(Librarian librarian);
	public void deleteLibrarian(int id);
	
}
