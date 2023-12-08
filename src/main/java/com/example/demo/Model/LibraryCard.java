package com.example.demo.Model;

import java.time.LocalDate;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "library_cards")
public class LibraryCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardId;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	@Column(name = "note")
	private String note;
	
	@OneToOne(mappedBy = "libraryCard")
	private Student student;
	
	public LibraryCard() {
		super();
	}
	
	public LibraryCard(Long cardId) {
		super();
		this.cardId = cardId;
	}

	public LibraryCard(Long cardId, LocalDate startDate, LocalDate endDate, String note) {
		super();
		this.cardId = cardId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.note = note;
	}
	
	public LibraryCard(Long cardId, LocalDate startDate, LocalDate endDate, String note, Student student) {
		super();
		this.cardId = cardId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.note = note;
		this.student = student;
	}
	public Long getCardId() {
		return cardId;
	}
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
