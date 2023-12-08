package com.example.demo.Repository;

import java.util.List;

import com.example.demo.Model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepoistory extends JpaRepository<Student, Integer> {
	@Query("SELECT s FROM Student s WHERE s.lastName LIKE %?1%")
	List<Student> findStudentsByName(@Param("searchName") String searchName);
	@Query("SELECT s FROM Student s WHERE s.account.id = ?1 ")
	Student getStudentInformationByAccountId(@Param("id") long id);

}
