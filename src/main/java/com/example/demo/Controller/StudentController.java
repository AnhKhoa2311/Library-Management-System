package com.example.demo.Controller;

import com.example.demo.Model.LibraryCard;
import com.example.demo.Model.Student;
import com.example.demo.Service.LibraryCardServiceImple;
import com.example.demo.Service.StudentService;
import com.example.demo.Service.StudentServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class StudentController {
	@Autowired
	private StudentServiceImple service;
	
	@Autowired
	private LibraryCardServiceImple libCardService;
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());
		return "/Reader/students";
	}
	@GetMapping("/students/new")
	public String addStudent(Model model) {
// HOLD DATA FROM A FORM
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("cards", libCardService.getAllCard());
		return "/Reader/create_student";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/admin/students";
	}
	@PostMapping("/students/find/{searchName}")
	public String findStudentsByName(@Param("searchName") String searchName, Model model) {
		model.addAttribute("studentsByName", service.findStudentsByName(searchName));
		return "/Reader/find_students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("editStudent", service.getStudentById(id));
		model.addAttribute("editCard", libCardService.getAllCard());
		return "/Reader/edit_student";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id,
			@ModelAttribute("editStudent") Student student, @Param("cardId") Long cardId, Model model) {
// GET STUDENT FROM DATABSE BY ID
		Student existingStudent = service.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setPhoneNumber(student.getPhoneNumber());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setDob(student.getDob());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setGender(student.getGender());
		existingStudent.setLibraryCard(student.getLibraryCard());
// SAVE AND UPDATE STUDENT INFO
		service.updateStudent(existingStudent);
		return "redirect:/admin/students";
	}
	@GetMapping("/students/deleted/{id}")
	public String deleteStudent(@PathVariable int id) {
		service.deleteStudents(id);	
		return "redirect:/admin/students";
	}
}	
