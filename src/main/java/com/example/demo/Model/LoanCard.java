package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
@Table(name = "loan_cards")
public class LoanCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@ManyToOne // khai báo relationship của phía n
	@JoinColumn(name = "books_id",referencedColumnName = "id") // cột sẽ tham gia vào table
	private Book booksId;
	@ManyToOne // khai báo relationship của phía n
	@JoinColumn(name = "students_id", referencedColumnName = "id") // cột sẽ tham gia vào table
	private Student studentsId;
	@ManyToOne // khai báo relationship của phía n
	@JoinColumn(name = "librarians_id", referencedColumnName = "id") // cột sẽ tham gia vào table
	private Librarian librariansId;
	@Column(name = "start_date")
	private String startDate;
	@Column(name = "end_date")
	private String endDate;
	@Column(name = "out_of_date")
	private boolean outOfDate;
	
	public LoanCard() {
		
	}
	public LoanCard(Book booksId, Student studentsId, Librarian librariansId, String startDate, String endDate,
			boolean outOfDate) {
		super();
		this.booksId = booksId;
		this.studentsId = studentsId;
		this.librariansId = librariansId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.outOfDate = outOfDate;
	}

	public LoanCard(long id, Book booksId, Student studentsId, Librarian librariansId, String startDate, String endDate,
			boolean outOfDate) {
		super();
		Id = id;
		this.booksId = booksId;
		this.studentsId = studentsId;
		this.librariansId = librariansId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.outOfDate = outOfDate;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Book getBooksId() {
		return booksId;
	}

	public void setBooksId(Book booksId) {
		this.booksId = booksId;
	}

	public Student getStudentsId() {
		return studentsId;
	}

	public void setStudentsId(Student studentsId) {
		this.studentsId = studentsId;
	}

	public Librarian getLibrariansId() {
		return librariansId;
	}

	public void setLibrariansId(Librarian librariansId) {
		this.librariansId = librariansId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String enđate) {
		this.endDate = enđate;
	}

	public boolean isOutOfDate() {
		return outOfDate;
	}

	public void setOutOfDate(boolean outOfDate) {
		this.outOfDate = outOfDate;
	}
	@Override
	public String toString() {
		return "LoanCard [Id=" + Id + ", booksId=" + booksId.getId() + ", studentsId=" + studentsId.getId() + ", librariansId="
				+ librariansId.getId() + ", startDate=" + startDate + ", endDate=" + endDate + ", outOfDate=" + outOfDate + "]";
	}
	
	
}
