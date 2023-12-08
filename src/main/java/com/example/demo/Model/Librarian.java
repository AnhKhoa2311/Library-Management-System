package com.example.demo.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "librarian")
public class Librarian {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "email")
	private String email;
	@Column(name = "gender")
	private String gender;
	@OneToMany(mappedBy = "librariansId") // khai báo relationship của phía 1
	private Set<LoanCard> loanCard;
	
	public Librarian() {
		super();
	}
	
	public Librarian(int id) {
		super();
		this.id = id;
	}

	public Librarian(int id, String name, String phoneNumber, String address, LocalDate dob, String email, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.gender = gender;
	}
	
	public Librarian(int id, String name, String phoneNumber, String address, LocalDate dob, String email, String gender,
			Set<LoanCard> loanCard) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.gender = gender;
		this.loanCard = loanCard;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Set<LoanCard> getLoanCard() {
		return loanCard;
	}
	public void setLoanCard(Set<LoanCard> loanCard) {
		this.loanCard = loanCard;
	}
}
