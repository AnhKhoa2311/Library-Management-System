package com.example.demo.Repository;

import java.util.List;
import com.example.demo.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepository extends JpaRepository<Book, Integer>{
	@Query("SELECT b FROM Book b WHERE b.booksName LIKE %?1%")
	List<Book> findBooksByName(@Param("booksName") String booksName);
}
