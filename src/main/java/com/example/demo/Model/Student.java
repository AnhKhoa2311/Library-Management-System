package com.example.demo.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@Column(name = "email")
	private String email;
	@Column(name = "gender")
	private String gender;
	
	@OneToOne(cascade = CascadeType.ALL) // khai báo relationship
	@JoinColumn(name = "cardId", referencedColumnName = "cardId") // khóa ngoại cardId ( foreign key) tham chiếu đến cardId bên entity LibraryCard
	private LibraryCard libraryCard;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountId", referencedColumnName = "id")
	private UserAccount account;
	@OneToMany(mappedBy = "studentsId") // khai báo relationship của phía 1
	private Set<LoanCard> loanCard;
	public Student() {
		super();
	}
	
	public Student(long id) {
		super();
		this.id = id;
	}
	public Student(LibraryCard libraryCard) {
		super();
		this.libraryCard = libraryCard;
	}
	
	public Student(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Student(String firstName, String lastName, String phoneNumber, String address, LocalDate dob,
			String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
	}

	public Student(long id, String firstName, String lastName, String phoneNumber, String address, LocalDate dob,
			String email, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.gender = gender;
	}
	
	public Student(String firstName, String lastName, String phoneNumber, String address, LocalDate dob, String gender, UserAccount account) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.account = account;
	}

	public Student(long id, String firstName, String lastName, String phoneNumber, String address, LocalDate dob,
			String email, String gender, LibraryCard libraryCard) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.gender = gender;
		this.libraryCard = libraryCard;
	}
	
	public Student(long id, String firstName, String lastName, String phoneNumber, String address, LocalDate dob,
			String email, String gender, LibraryCard libraryCard, UserAccount account, Set<LoanCard> loanCard) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.gender = gender;
		this.libraryCard = libraryCard;
		this.account = account;
		this.loanCard = loanCard;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LibraryCard getLibraryCard() {
		return libraryCard;
	}
	public void setLibraryCard(LibraryCard libraryCard) {
		this.libraryCard = libraryCard;
	}

	public UserAccount getAccount() {
		return account;
	}

	public void setAccount(UserAccount account) {
		this.account = account;
	}

	public Set<LoanCard> getLoanCard() {
		return loanCard;
	}

	public void setLoanCard(Set<LoanCard> loanCard) {
		this.loanCard = loanCard;
	}
}
