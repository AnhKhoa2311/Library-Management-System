package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Student;
import com.example.demo.Repository.LibrarianRepository;
import com.example.demo.Repository.StudentRepoistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImple implements StudentService {
	@Autowired
	private StudentRepoistory repository;
	

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
	   return repository.save(student);
	}


	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
	   return repository.findById(id).get();
	}
	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
	   return repository.save(student);
	}

	@Override
	public void deleteStudents(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Student> findStudentsByName(String searchName) {
		// TODO Auto-generated method stub
		if(searchName != null) {
			return repository.findStudentsByName(searchName);
		}
		return repository.findAll();
	}


	@Override
	public Student getStudentInformationByAccountId(long id) {
		// TODO Auto-generated method stub
		return repository.getStudentInformationByAccountId(id);
	}




	

}
