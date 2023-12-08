package com.example.demo.Repository;

import java.util.List;

import com.example.demo.Model.Librarian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
	@Query("SELECT l FROM Librarian l WHERE l.name LIKE %?1%")
	List<Librarian> findLibrariansByName(@Param("librariansSearchName") String librariansSearchName);
}
