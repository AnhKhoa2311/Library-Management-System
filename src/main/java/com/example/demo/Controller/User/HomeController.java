package com.example.demo.Controller.User;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Student;
import com.example.demo.Model.UserAccount;
import com.example.demo.Service.BookServiceImple;
import com.example.demo.Service.StudentServiceImple;
import com.example.demo.Service.UserAccountService;
import com.example.demo.Service.UserAccountServiceImple;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.RemoteEndpoint.Async;


@Controller
public class HomeController {
	@Autowired
	protected UserAccountServiceImple userAccountService;
	@Autowired
	protected StudentServiceImple userInformationService;
	@Autowired
	protected BookServiceImple booksServiceImple;
	@Autowired
	protected BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allbooks", booksServiceImple.getAll());
		return "UserFE/Home/home";
	}
	// SPRING BOOT AUTOMATICALLY CREATE A POST METHOD FOR LOGIN AUTHENTICATION SO THERE IS
	// NO NEED TO RE-CREATE AN ENDPOINT FOR LOGIN TO AUTHENTICATE (CHECK THE SecurityConfig FILE)
	@GetMapping("/login")
	public String loginForm(Model model) {
		UserAccount userAccount = new UserAccount();
		model.addAttribute("auth", userAccount);
		return "UserFE/Login/login";
	}
	@GetMapping("/getinfo")
	public String getPrincipalInformation(org.springframework.security.core.Authentication auth, Model model) {
		UserAccount account = userAccountService.getUserAccountInformation(auth.getName());
		Student student = userAccountService.getInformations(account.getId());
		model.addAttribute("informations", student);
		model.addAttribute("currentaccount", account);
		return "UserFE/Information/personal_information";
	}
	@GetMapping("/createinformationform")
	public String createUserInformationForm(org.springframework.security.core.Authentication auth, Model model) {
		Student createStudentsInfor = new Student();// CREATE STUDENT OBJECT FOR PASS THIS OBJECT TO HTML FILE
		model.addAttribute("studentupdate", createStudentsInfor);
		return "UserFE/Information/update_information";
	}
	@PostMapping("/createinfor")
	public String createUserInformation(org.springframework.security.core.Authentication auth,@ModelAttribute("studentupdate") Student student) {
		UserAccount account = userAccountService.getUserAccountInformation(auth.getName()); // GET ACCOUNT BY NAME (EMAIL)
		Student studentUpdate = new Student();
		studentUpdate.setFirstName(student.getFirstName());
		studentUpdate.setLastName(student.getLastName());
		studentUpdate.setAddress(student.getAddress());
		studentUpdate.setDob(student.getDob());
		studentUpdate.setGender(student.getGender());
		studentUpdate.setPhoneNumber(student.getPhoneNumber());
		studentUpdate.setAccount(account); // SET account_id = THE ID OF CURRENT USER
		userInformationService.saveStudent(studentUpdate); // UPDATE THE INFORMATION 
		return "redirect:/getinfo";
	}
	// SPRING BOOT AUTOMATICALLY CREATE A GET METHOD FOR LOGOUT SO THERE IS
	// NO NEED TO RE-CREATE AN ENDPOINT FOR LOGOUT PROCESS (CHECK THE SecurityConfig FILE)
	@GetMapping("/editinformationform")
	public String editInformationForm(Model model, org.springframework.security.core.Authentication auth) {
		UserAccount account = userAccountService.getUserAccountInformation(auth.getName());
		Student studentFoundForEdit = userInformationService.getStudentInformationByAccountId(account.getId());
		model.addAttribute("studentinfoedit", studentFoundForEdit);
		return "UserFE/Information/edit_information";
	}
	@PostMapping("updateinformation")
	public String updateInformation(org.springframework.security.core.Authentication auth, @ModelAttribute("studentinfoedit") Student studentUpdate) {
		UserAccount account = userAccountService.getUserAccountInformation(auth.getName()); // GET ACCOUNT BY NAME (EMAIL)
		Student studentFoundForEdit = userInformationService.getStudentInformationByAccountId(account.getId()); // GET INFORMATION OF THIS ACCOUNT 
																												// BY ID (USE THE ACCOUNT GET ABOVE
																												// TO GET ID)
		studentFoundForEdit.setFirstName(studentUpdate.getFirstName());
		studentFoundForEdit.setLastName(studentUpdate.getLastName());
		studentFoundForEdit.setAddress(studentUpdate.getAddress());
		studentFoundForEdit.setPhoneNumber(studentUpdate.getPhoneNumber());
		studentFoundForEdit.setDob(studentUpdate.getDob());
		studentFoundForEdit.setGender(studentUpdate.getGender());
		studentFoundForEdit.setAccount(account);
		userInformationService.saveStudent(studentFoundForEdit);
		return "redirect:/getinfo";
	}
	@GetMapping("/register")
	public String registerForm(Model model) {
		UserAccount userAccount = new UserAccount();
		model.addAttribute("account", userAccount);
		return "UserFE/Login/register";
	}
	@PostMapping("/create")
	public String createUser(@ModelAttribute("account") UserAccount userAccount) {
		userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
		userAccount.setCreatedAt(LocalDateTime.now());
		userAccountService.createAccount(userAccount);
		return "redirect:/";
	}
}
