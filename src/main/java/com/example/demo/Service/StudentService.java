package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(int id);
	List<Student> findStudentsByName(String searchName);
	Student updateStudent(Student student);
	Student getStudentInformationByAccountId(long id);
	void deleteStudents(int id);
}
