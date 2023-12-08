package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Librarian;
import com.example.demo.Repository.LibrarianRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarianServiceImple implements LibrarianService {
	
	@Autowired
	LibrarianRepository repo;

	@Override
	public List<Librarian> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Librarian addLib(Librarian lib) {
		// TODO Auto-generated method stub
		return repo.save(lib);
	}

	@Override
	public Librarian getLibById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Librarian editLibrarian(Librarian librarian) {
		// TODO Auto-generated method stub
		return repo.save(librarian);
	}

	@Override
	public void deleteLibrarian(int id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
	}

	@Override
	public List<Librarian> findLibrariansByName(String librariansSearchName) {
		if(librariansSearchName != null) {
			return repo.findLibrariansByName(librariansSearchName);
		}
		return repo.findAll();
	}
	
	
	
}
